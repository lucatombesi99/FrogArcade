package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RankingTable {

    private static int numClickAdd = 0;

    private static TextField nameInput;
    private static TableView<Player> table;


    public static void scoreRecord() {

        Stage scoreStage = new Stage();
        scoreStage.setTitle("Ranking");

        Text score = new Text("\t \t RANKING:\n");
        nameInput = new TextField();
        nameInput.setPromptText("Player NAME");


        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
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


        table = new TableView<>();
        table.setItems(getPlayer());
        //noinspection unchecked
        table.getColumns().addAll(nameColumn, scoreColumn);

        gridPane.add(hBox, 0, 2);

        gridPane.add(score, 0, 0);
        gridPane.add(table, 0, 1);


        Scene scene = new Scene(gridPane, 500, 500);
        scoreStage.setScene(scene);
        scoreStage.show();

        resumeButton.setOnAction(e -> {
            scoreStage.close();
            MenuActions.autoPlay = true;
            MenuActions.mediaPlayer.play();

        });


    }

    public static void addButtonClicked() {
        Player player = new Player();
        player.setName(nameInput.getText());

        if (numClickAdd == 0) {
            table.getItems().add(player);
            nameInput.clear();
            numClickAdd++;
        }
    }


    public static ObservableList<Player> getPlayer(){
        ObservableList<Player> players = FXCollections.observableArrayList();
        players.add(new Player("Christian", 125));
        players.add(new Player("Christian", 825));
        players.add(new Player("Christian", 225));
        players.add(new Player("Christian", 325));
        players.add(new Player("Christian", 925));
        return players;

    }
}

