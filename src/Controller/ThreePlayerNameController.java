package Controller;

import Driver.Main;
import Model.GameData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ThreePlayerNameController {

    @FXML TextField p1Name, p2Name, p3Name;
    public void selectMenu() throws IOException {

        if (checker()) {
            GameData.playerOneName = p1Name.getText();
            GameData.playerTwoName = p2Name.getText();
            GameData.playerThreeName = p3Name.getText();

            Stage stage = Main.getMainStage();

            Parent root = FXMLLoader.load(getClass().getResource("/View/SelectMenu.fxml"));
            stage.setScene(new Scene(root, 965, 656));
        }
    }

    public boolean checker () {
        if (p1Name.getText() == null || p1Name.getText().trim().isEmpty() ||
                p2Name.getText() == null || p2Name.getText().trim().isEmpty() ||
                p3Name.getText() == null || p3Name.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Fill out all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
