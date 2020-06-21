package Controller;

import Driver.Main;
import Model.GameData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.IIOException;
import java.io.IOException;

public class StartController {
    @FXML Button start2PButton, start3PButton, exitButton;

    public void exitGame(){
        Platform.exit();
    }

    public void start2P() throws IOException {
        GameData.is2Player = true;
        Stage stage = Main.getMainStage();

        Parent root = FXMLLoader.load(getClass().getResource("/View/TwoPlayerGetNames.fxml"));
        stage.setScene(new Scene(root, 965, 656));
    }

    public void start3P() throws IOException{
        GameData.is2Player = false;
        Stage stage = Main.getMainStage();

        Parent root = FXMLLoader.load(getClass().getResource("/View/ThreePlayerGetNames.fxml"));
        stage.setScene(new Scene(root, 965, 656));
    }

}
