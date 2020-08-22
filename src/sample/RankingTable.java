package sample;


import gameSystem.GameScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static sample.Main.IMAGE_PATH;

//stramodificato
public class RankingTable {


    static String fileName = IMAGE_PATH+"RankingTable.csv";
    static String charset = "UTF-8";
    static PlayerData playerData=new PlayerData();
    static int numScores=0;
    static int numClick=0;

    static List<Integer> scoreRecords= new ArrayList<>();;


    private static TextField nameInput;
    private static TableView<Player> table;


    public static void scoreRecord() throws IOException {

        Stage scoreStage = new Stage();
        scoreStage.setTitle("Ranking");

        Text score = new Text("\t \t RANKING:\n");
        nameInput = new TextField();
        nameInput.setPromptText("Player NAME");

        //caricamento ranking
        LinkedList<String[]> lstRows = FileManagment.read(fileName, charset);
        for (String[] sArr : lstRows) {
            playerData.add(new Player(sArr[0], Integer.parseInt(sArr[1])));
            scoreRecords.add(Integer.parseInt(sArr[1]));
        }
        numScores = scoreRecords.size();
        //sorting the scores in decreasing values
        Collections.sort(scoreRecords, Collections.reverseOrder());



        Button addButton = new Button("Add");
        if (numScores >9 && scoreRecords.get(9) > GameScene.points) {
            addButton.setDisable(true);
            nameInput.setDisable(true);

        }

        addButton.setOnAction(e -> {
            try {
                addButtonClicked(addButton);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Button resumeButton = new Button("Resume");


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, addButton, resumeButton);

        //Button


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        //Column name
        TableColumn<Player, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Column score
        TableColumn<Player, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setMinWidth(100);
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        if (numClick < 1) {
            table = new TableView<>();

            table.setItems(getPlayer(playerData));

            //noinspection unchecked
            table.getColumns().addAll(nameColumn, scoreColumn);
        }

        gridPane.add(hBox, 0, 2);

        gridPane.add(score, 0, 0);
        gridPane.add(table, 0, 1);


        Scene scene = new Scene(gridPane, 500, 500);
        scoreStage.setScene(scene);
        scoreStage.show();

        resumeButton.setOnAction(e -> {
            numClick++;
            scoreStage.close();
            MenuActions.autoPlay = true;
            MenuActions.mediaPlayer.play();

        });

        scoreStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                numClick++;
            }
        });

    }

    public static void addButtonClicked(Button button) throws IOException {

            Player player = new Player();
            player.setName(nameInput.getText());
            player.setScore(GameScene.points);
            scoreRecords.add(GameScene.points);
            playerData.add(player);
            Collections.sort(scoreRecords, Collections.reverseOrder());
            playerData=sortPlayers(playerData);
            playerData.remove(9);
            scoreRecords.remove(9);
            FileManagment.write(fileName, charset, playerData.asListOfStringArray());
            table.getItems().clear();
            table.setItems(getPlayer(playerData));
            nameInput.clear();

        button.setDisable(true);

    }


    public static ObservableList<Player> getPlayer(PlayerData playerLst){

        PlayerData sortedPlayers=sortPlayers(playerLst);
        ObservableList<Player> players = FXCollections.observableArrayList();
        LinkedList<Player>  allPlayers= sortedPlayers.getListOfPlayers();
        players.addAll(allPlayers);





        return players;

    }
    public static PlayerData sortPlayers(PlayerData allplayers){
        Player player;
        for(int i=0;i<scoreRecords.size();i++)
            for(int j=0;j<scoreRecords.size();j++)
                if(scoreRecords.get(i)==allplayers.get(j).getScore()) {
                    player = allplayers.get(j);
                    allplayers.set(j, allplayers.get(i));
                    allplayers.set(i, player);
                }
        return allplayers;
    }

}

