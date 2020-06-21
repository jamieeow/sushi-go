package Model;

import java.util.ArrayList;
import java.util.List;

//

/**
 * PLAYER CLASS
 */
public class Player {

    private String name;
    private boolean playedWasabi;
    private boolean playedMiso;
    private int totalPoints;
    private List<Card> passPile;
    private List<Card> keepPile;

    // CONSTRUCTOR //

    /**
     * Constructor
     * @param name
     */
    public Player (String name) {
        this.name = name;
        this.playedWasabi = false;
        this.playedMiso = false;
        this.totalPoints = 0;
        passPile = new ArrayList<>();
        keepPile = new ArrayList<>();
    }

    // METHODS //

    //

    /**
     * ADDS THE POINTS TO THE TOTAL POINTS
     * @param points
     */
    public void addPoints(int points) {
        totalPoints += points;
    }

    //

    /**
     * ADDS A CARDS TO THE PASS PILE
     * @param card
     */
    public void addToPassPile(Card card) { passPile.add(card); }

    //

    /**
     * ADDS A CARD TO THE KEEP PILE
     * @param card
     */
    public void addToKeepPile (Card card) {
        keepPile.add(card);
    }

    // GETTERS //
    //

    /**
     * RETURNS THE NAME OF THE PLAYER
     * @return
     */
    public String getName() {
        return name;
    }

    //

    /**
     * RETURNS BOOLEAN IF THE PLAYER PLAYED WASABI
     * @return
     */
    public boolean getPlayedWasabi() {
        return playedWasabi;
    }

    //

    /**
     * RETURNS BOOLEAN IF THE PLAYER PLAYED MISO
     * @return
     */
    public boolean getPlayedMiso() {
        return playedMiso;
    }

    //

    /**
     * RETURNS THE TOTAL POINTS OF THE PLAYER
     * @return
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    //

    /**
     * RETURNS THE LIST OF CARDS FROM THE PLAYER'S PASS PILE
     * @return
     */
    public List<Card> getPassPile() {
        return passPile;
    }

    // RETURNS THE LIST OF CARDS FROM THE PLAYER'S KEEP PILE
    public List<Card> getKeepPile() {
        return keepPile;
    }

    // SETTERS //
    // SETS IF THE PLAYER PLAYED WASABI
    public void setPlayedWasabi(boolean playedWasabi) {
        this.playedWasabi = playedWasabi;
    }

    // SETS IF THE PLAYER PLAYED MISO
    public void setPlayedMiso(boolean playedMiso) {
        this.playedMiso = playedMiso;
    }

    // SETS A LIST OF CARDS TO THE PLAYER'S PASS PILE
    public void setPassPile(List<Card> pass) {
        passPile = pass;
    }

}
