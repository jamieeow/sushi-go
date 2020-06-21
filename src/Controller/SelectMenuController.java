package Controller;

import Driver.Main;
import Model.GameData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class SelectMenuController {

    @FXML Button startGameButton;
    @FXML RadioButton defaultMenu, ownMenu;
    @FXML CheckBox tempura, sashimi, misoSoup, dumplings, tofu, iceCream, pudding;
    @FXML Pane boardPane;

    ArrayList<String> sushi = new ArrayList<>();
    ArrayList<String> defaultSushi = new ArrayList<>();


    public void initialize() {
        EventHandler eh = (EventHandler<ActionEvent>) event -> {
            if (event.getSource() instanceof CheckBox) {
                CheckBox chk = (CheckBox) event.getSource();
                System.out.println("Action performed on checkbox " + chk.getText());

                if (chk.isSelected())
                    sushi.add(chk.getText());
                else
                    sushi.remove(chk.getText());
            }
        };

        for(Node node: boardPane.getChildren())
            if (node instanceof CheckBox)
                ((CheckBox) node).setOnAction(eh);

        defaultSushi.add("Tempura");
        defaultSushi.add("Sashimi");
        defaultSushi.add("Miso Soup");
        defaultSushi.add("Green Tea Ice Cream");

        selectDefault();
        defaultMenu.setSelected(true);
        GameData.initializeMenu();
    }

    public void selectDefault () {

        ownMenu.setSelected(false);

        for (Node node: boardPane.getChildren())
            if (node instanceof CheckBox)
                node.setDisable(true);

    }
    public void createMenu () {

        defaultMenu.setSelected(false);

        for (Node node: boardPane.getChildren())
            if (node instanceof CheckBox)
                node.setDisable(false);
    }

    public void initializeData () {
        if (ownMenu.isSelected()) {
            if (checker()) {
                for (String string : sushi) {
                    GameData.menu.add(string);
                    GameData.imageCards.add(new Image("View/resources/CARDS/" + string + ".png"));
                    GameData.imageMenu.add(new Image("/View/resources/CARDS/MENU/" + string + ".png"));
                }
                GameData.initializeGame();
                playGame();
            }
        } else {
            for (String string: defaultSushi) {
                GameData.imageCards.add(new Image("View/resources/CARDS/" + string + ".png"));
                GameData.imageMenu.add(new Image("/View/resources/CARDS/MENU/" + string + ".png"));
                GameData.menu.add(string);
            }
            GameData.initializeGame();
            playGame();
        }
    }

    private void playGame() {
        try{
            Stage stage = Main.getMainStage();

            // two player
            if (GameData.is2Player) {
                Parent root = FXMLLoader.load(getClass().getResource("/View/MainView2P.fxml"));
                stage.setScene(new Scene(root, 965, 656));
            }
            // three player
            else {
                Parent root = FXMLLoader.load(getClass().getResource("/View/MainView3P.fxml"));
                stage.setScene(new Scene(root, 965, 656));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checker(){
        int appetizer = 0, dessert = 0;
        for (String string: sushi) {
            switch (string) {
                case "Tempura":
                    appetizer++;
                    break;
                case "Sashimi":
                    appetizer++;
                    break;
                case "Miso Soup":
                    appetizer++;
                    break;
                case "Dumplings":
                    appetizer++;
                    break;
                case "Tofu":
                    appetizer++;
                    break;
                case "Green Tea Ice Cream":
                    dessert++;
                    break;
                case "Pudding":
                    dessert++;
                    break;
            }
        }

        if (!defaultMenu.isSelected() && !ownMenu.isSelected()) {
            JOptionPane.showMessageDialog(new JFrame(), "Select a menu!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (dessert == 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Select a dessert!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (appetizer < 3) {
            JOptionPane.showMessageDialog(new JFrame(), "Select 3 appetizers!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (appetizer > 3) {
            JOptionPane.showMessageDialog(new JFrame(), "Select only 3 appetizers!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (dessert > 1) {
            JOptionPane.showMessageDialog(new JFrame(), "Select only 1 dessert!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

}


