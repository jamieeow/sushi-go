 package Model;

import java.util.ArrayList;
import java.util.List;

 /**
  * THE MAIN BOARD WHICH HOLDS ALL THE GAME VARIABLES
  *
  */
 public class Board {

    private final ArrayList<Player> players;
    private final RoundStatistics roundStatistics;
    private final PointsCalculator pointsCalculator;
    private MainDeck mainDeck;

    // CONSTRUCTOR
    public Board (ArrayList<Player> players, RoundStatistics roundStatistics, PointsCalculator pointsCalculator, MainDeck mainDeck) {
        this.players = players;
        this.roundStatistics = roundStatistics;
        this.pointsCalculator = pointsCalculator;
        this.mainDeck = mainDeck;
    }

     /**
      * EXCHANGES THE PILES OF PLAYER 1 AND 2
      *
      */
    public void passPile(Player player1, Player player2) {
        List<Card> tempPile;
        tempPile = player1.getPassPile();
        player1.setPassPile(player2.getPassPile());
        player2.setPassPile(tempPile);
    }

     /**
      *
      * ROTATES THE CARD PILES OF PLAYER 1, 2, AND 3
      */
    public void passPile(Player player1, Player player2, Player player3) {
        // THIS AINT DONE
        // TODO

//        ArrayList<Card> tempPile;
//        tempPile = player3.getPassPile();
//
//        player1.setPassPile(player2.getPassPile());
//        player2.setPassPile(tempPile);
    }

    //
     /**
      * RETURNS THE PLAYERS
      */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    //
     /**
      * RETURNS THE ROUND STATISTICS CLASS
      */
    public RoundStatistics getRound() {
        return roundStatistics;
    }

    //
     /**
      * RETURNS THE POINTS CALCULATOR
      */
    public PointsCalculator getPointsCalculator() {
        return pointsCalculator;
    }

    //
     /**
      * RETURNS THE MAIN DECK
      */
    public MainDeck getMainDeck() {
        return mainDeck;
    }
}
