package Controller;

import Driver.Main;
import Model.GameData;
import Model.Player;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
/**
// SHOW PLAYERS AND THEIR SCORES //
 */
public class GameOverController {

    @FXML TableView<PlayerRow> resultTable;
    @FXML
    TableColumn<PlayerRow, String> playerColumn;
    @FXML
    TableColumn<PlayerRow, Integer> scoreColumn;


    /**
    // INITIALIZE TABLE VALUES //
     */
    public void initialize() {

        playerColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().playerName));
        scoreColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().score));
        resultTable.setItems(getPlayerRows());

    }
/**
    // GET THE VALUES //
 */
    private ObservableList<PlayerRow> getPlayerRows() {

        ObservableList<PlayerRow> playerRows = FXCollections.observableArrayList();
        for (Player player: GameData.players)
            playerRows.add(new PlayerRow(player.getName(), player.getTotalPoints()));
        return playerRows;

    }
/**
    // EXIT THE GAME //
 */
    public void exitGame() {
        Platform.exit();
    }

/**
    // PLAY AGAIN //
 */
    public void playGame() {
        try{
            Stage stage = Main.getMainStage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Start.fxml"));
            stage.setScene(new Scene(root, 965, 656));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**
    // PLAYER ROW CLASS //
 */
    class PlayerRow {
        String playerName;
        int score;
        public PlayerRow(String name, int score) {
            this.playerName = name;
            this.score = score;
        }
    }
}
