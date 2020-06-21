package Controller;

import Driver.Main;
import Model.*;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
* CONTROLLER OF THE MAIN VIEW FOR 2 PLAYERS
 */
public class MainController2P implements Initializable{
    @FXML Pane mainPane, passPilePane, keepPilePane1, keepPilePane2;
    @FXML Label player1Name, player2Name, roundLbl, p1scoreLbl, p2scoreLbl,
            highestMakiLbl, secondHighestMakiLbl, highestPuddingLbl, leastPuddingLbl, playerTurnLbl;
    @FXML ImageView menu_nigiri, menu_rolls, menu_app1, menu_app2, menu_app3, menu_special1, menu_special2, menu_dessert;
    @FXML Button nextRoundBtn;

    private Player player1, player2;
    private Board board;
    private MainDeck mainDeck;
    private PointsCalculator pointsCalculator;
    private RoundStatistics roundStatistics;
    private int numPassCard;

    private ArrayList<ImageView> player1PileIV = new ArrayList<>(),
            player2PileIV = new ArrayList<>(),
            passPileIV = new ArrayList<>();

    private Image faceDown = new Image("/View/resources/CARDS/face down.png");
    private Image emptyCard = new Image("/View/resources/CARDS/_BLANK.png");

/**
    * INITIALIZES SYSTEM VARIABLES FOR THE GAME VIEW
 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeToolbar();
        nextRoundBtn.setDisable(true);

        ArrayList<ImageView> menus = new ArrayList<>();
        menus.add(menu_nigiri);
        menus.add(menu_rolls);
        menus.add(menu_special1);
        menus.add(menu_special2);
        menus.add(menu_app1);
        menus.add(menu_app2);
        menus.add(menu_app3);
        menus.add(menu_dessert);

        for (int i=0; i < menus.size(); i++)
            menus.get(i).setImage(GameData.imageMenu.get(i));

        // PLAYER 1 PILE OF IMAGE VIEW
        for (Node node: keepPilePane1.getChildren()) {
            if (node instanceof ImageView) {
                ImageView iv = (ImageView) node;
                player1PileIV.add(iv);
            }
        }

        // PLAYER 2 PILE OF IMAGE VIEW
        for (Node node: keepPilePane2.getChildren()) {
            if (node instanceof ImageView) {
                ImageView iv = (ImageView) node;
                player2PileIV.add(iv);
            }
        }

        // SET PLAYER NAME TEXT TO PLAYER PILE
        player1Name.setText(GameData.playerOneName);
        player2Name.setText(GameData.playerTwoName);

        // GETTING PLAYERS TO LOCAL VARIABLE
        player1 = GameData.players.get(0);
        player2 = GameData.players.get(1);

        // GETTING GAME DATA VARIABLES TO LOCAL VARIABLES
        board = GameData.board;
        mainDeck = GameData.board.getMainDeck();
        roundStatistics = GameData.board.getRound();
        pointsCalculator = GameData.board.getPointsCalculator();

        // GETTING PASS PILE IMAGE VIEW ARRAYLIST
        for (Node node: passPilePane.getChildren()) {
            if (node instanceof ImageView) {
                ImageView iv = (ImageView) node;
//                CardImage ci = (CardImage) iv;
                passPileIV.add(iv);
            }
        }


        // TODO


        startRound();
    }

/**
    * INITIALIZES THE TOOLBAR WHERE THE CLOSE BUTTON IS LOCATED
 */
    private void initializeToolbar(){
        ToolBar toolBar = new ToolBar();

        int height = 25;
        toolBar.setPrefHeight(height);
        toolBar.setMinHeight(height);
        toolBar.setMaxHeight(height);
        toolBar.getItems().add(new WindowButtons());

        mainPane.getChildren().add(0, toolBar);
    }

    class WindowButtons extends HBox {

        public WindowButtons() {
            Button closeBtn = new Button("X");

            closeBtn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent actionEvent) {
                    Platform.exit();
                }
            });

            this.getChildren().add(closeBtn);
        }
    }

/**
     INITIALIZES NECESSARY VARIABLES FOR THE ROUND
 */
    private void startRound() {

        // SHUFFLE CARDS //
        mainDeck.shuffleCards();

        // CLEAR BOTH PLAYERS KEEP PILE //
        player1.getKeepPile().clear();
        player2.getKeepPile().clear();
        for (int i = 0; i < 10; i++) {
            player1PileIV.get(i).setImage(emptyCard);
            player2PileIV.get(i).setImage(emptyCard);
        }
        

        // SET ROUND NUMBER //
        roundLbl.setText("ROUND: "+ roundStatistics.getRoundCount());

        // DISTRIBUTE TO PASS PILE //
        for (int i = 0; i < 10; i++) {
            Card card = mainDeck.getCards().get(0);
            player1.addToPassPile(card);
            mainDeck.getCards().remove(card);

            card = mainDeck.getCards().get(0);
            player2.addToPassPile(card);
            mainDeck.getCards().remove(card);

        }

        // RESET NUMBER OF CARDS THAT HAVE BEEN PASSED BY BOTH PLAYERS //
        numPassCard=0;

        // ROUND STARTS WITH PLAYER 1 //
        showPassPile(player1);

    }

/**
   *  SETS IMAGES TO THE PASS PILE
 */
    private void showPassPile(Player player) {

        // WHICH PLAYER'S TURN
        playerTurnLbl.setText(player.getName() + "'s Turn");

        if (!player.getPassPile().isEmpty()) {
            int i;
            for (i=0; i< player.getPassPile().size(); i++) {
                Image image = player.getPassPile().get(i).getImage();
                ImageView imageView = passPileIV.get(i);
                imageView.setImage(image);
            }
            for (int j=i; j < 10; j++) {
                passPileIV.get(j).setImage(emptyCard);
            }

            System.out.println("before going to passpile listener");
            setListenerToPassPile(player, passPileIV);
        } else {
            passPileIV.get(0).setImage(emptyCard);
            passPileIV.get(0).setOnMouseClicked(null);
            showRoundResults();
        }
    }

/**
   *  ADD LISTENER TO THE IMAGE VIEWS OF PASS PILE
 */
    private void setListenerToPassPile(Player player, ArrayList<ImageView> passPile) {

//        for (ImageView iv: passPile) {

            // GET THOSE WHICH ARE NOT EMPTY CARDS

                // GIVE A MOUSE CLICK LISTENER TO THE IMAGE VIEW
            int i;
            for (i=0; i<player.getPassPile().size(); i++) {
                ImageView imageView = passPileIV.get(i);
                if (!imageView.getImage().equals(emptyCard)) {

                    imageView.setOnMouseClicked(event -> {
                        System.out.println("Tile pressed ");

                        int index = passPileIV.indexOf(imageView);
                        player.addToKeepPile(player.getPassPile().get(index));
                        player.getPassPile().remove(index);

                        if (player.equals(player1)) {
                            player1PileIV.get(numPassCard).setImage(faceDown);

                            showPassPile(player2);
                        }
                        else {
                            List<Card> temp = player1.getPassPile();
                            player1.setPassPile(player.getPassPile());
                            player2.setPassPile(temp);
                            player2PileIV.get(numPassCard).setImage(faceDown);

                            numPassCard++;

                            showPassPile(player1);
                        }

                        event.consume();
                    });
                }
            }

            for (int j=i; j<10; j++) {
                passPileIV.get(i).setOnMouseClicked(null);
            }

    }

/**
     * SHOWS THE RESULTS OF THE ROUND
 * */
    private void showRoundResults() {

        // ROUND STATISTICS GET WHO GOT HIGHEST WHAT
        roundStatistics.getRoundStats(board.getPlayers());
        playerTurnLbl.setText("End of Round " + roundStatistics.getRoundCount());

        // ROUND STATISTICS SHOW WHO GOT THE HIGHEST WHAT
        highestMakiLbl.setText(roundStatistics.getHighestMaki().getName());
        secondHighestMakiLbl.setText(roundStatistics.getSecondMostMaki().getName());
        if (GameData.selectedDessert instanceof Pudding) {
            highestPuddingLbl.setText(roundStatistics.getHighestPudding().getName());
            leastPuddingLbl.setText(roundStatistics.getLeastPudding().getName());
        } else {
            highestPuddingLbl.setText("");
            leastPuddingLbl.setText("");
        }

        // REVEAL CARDS FROM PLAYERS' KEEP PILE
        for (int i = 0; i < 10; i++) {
            player1PileIV.get(i).setImage(player1.getKeepPile().get(i).getImage());
            player2PileIV.get(i).setImage(player2.getKeepPile().get(i).getImage());
        }

        // CALCULATION OF POINTS
        int player1Points = pointsCalculator.calculateSushis(board.getPlayers(), player1, roundStatistics);
        int player2Points = pointsCalculator.calculateSushis(board.getPlayers(), player2, roundStatistics);

        // SETTING TEXT TO SHOW ROUND SCORES
        p1scoreLbl.setText("Player 1 Score: " + player1Points);
        p2scoreLbl.setText("Player 2 Score: " + player2Points);

        // ADD THE POINTS TO THEIR ACTUAL SCORES
        player1.addPoints(player1Points);
        player2.addPoints(player2Points);

        // ENABLE THE BUTTON THAT GOES TO THE NEXT ROUND
        nextRoundBtn.setDisable(false);
        if (roundStatistics.getRoundCount() == 3)
            nextRoundBtn.setText("End Game");
    }

/**
     * SETS UP THE VARIABLES AND VALUES FOR THE NEXT ROUND
 * */
    public void setupForNextRound() {

        // DISABLE THE BUTTON THAT GOES TO THE NEXT ROUND
        nextRoundBtn.setDisable(true);

        roundStatistics.nextRound();

        if (roundStatistics.getRoundCount() == 2) {
            board.getMainDeck().setDessertCount(3);
            board.getMainDeck().addDessert(GameData.selectedDessert);
            startRound();
        }
        else if (roundStatistics.getRoundCount() == 3) {
            board.getMainDeck().setDessertCount(2);
            board.getMainDeck().addDessert(GameData.selectedDessert);
            startRound();
        } else {
            endGame();
        }

    }
/**
   *  ENDS THE GAME
 *  */
    private void endGame() {
        try{
            Stage stage = Main.getMainStage();
            Parent root = FXMLLoader.load(getClass().getResource("/View/GameOver.fxml"));
            stage.setScene(new Scene(root, 965, 656));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
