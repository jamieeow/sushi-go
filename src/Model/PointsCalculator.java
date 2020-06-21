package Model;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

//

/**
 * A CALCULATOR OF POINTS FOR ALL KINDS OF SUSHI
 */
public class PointsCalculator {

    private int tempuraCount;
    private int sashimiCount;
    private int dumplingsCount;
    private int tofuCount;
    private int rollPoints;
    private int greenTeaCount;
    private int totalPoints;
    private boolean playedWasabi;

    public PointsCalculator (){
        this.tempuraCount = 0;
        this.sashimiCount = 0;
        this.dumplingsCount = 0;
        this.tofuCount = 0;
        this.rollPoints = 0;
        this.greenTeaCount = 0;
    }

    // METHODS //

    //

    /**
     * RETURNS THE TOTAL POINTS GARNERED OF THE PLAYER PARAMETER
     * @param players
     * @param player
     * @param round
     * @return
     */
    public int calculateSushis(ArrayList<Player> players, Player player, RoundStatistics round){

        // INITIATE VALUES
        this.tempuraCount = 0;
        this.sashimiCount = 0;
        this.dumplingsCount = 0;
        this.tofuCount = 0;
        this.rollPoints = 0;
        this.greenTeaCount = 0;
        this.totalPoints = 0;
        this.playedWasabi = false;

        ArrayList<Card> sushis = (ArrayList<Card>) player.getKeepPile();

        // ADDS TO THE TOTAL POINT FOR EACH KIND OF CARD
        for (Card card: sushis) {
            if (card instanceof Nigiri)
                totalPoints += calculateNigiri((Nigiri) card);
            else if (card instanceof Tempura)
                tempuraCount++;
            else if (card instanceof Sashimi)
                sashimiCount++;
            else if (card instanceof Dumplings)
                dumplingsCount++;
            else if (card instanceof Tofu)
                tofuCount++;
            else if (card instanceof GreenTeaIceCream)
                greenTeaCount++;
            else if (card instanceof Wasabi)
                playedWasabi = true;
            else if (card instanceof Tea)
                totalPoints += calculateTea(players);
            else if (card instanceof Pudding)
                totalPoints += calculatePudding(player, round);
            else if (card instanceof Rolls)
                totalPoints += calculateMaki(player, round);
            else if (card instanceof MisoSoup)
                totalPoints += calculateMiso(player, players, (MisoSoup) card);
        }

        totalPoints += calculateTempura();
        totalPoints += calculateSashimi();
        totalPoints += calculateDumplings();
        totalPoints += calculateTofu();
        totalPoints += calculateGreenTea();

        return totalPoints;
    }

    //

    /**
     * COMPUTATION FOR NIGIRI
     * @param nigiri
     * @return int
     */
    public int calculateNigiri(Nigiri nigiri){
        if (nigiri instanceof Egg)
            return 1;
        else if (nigiri instanceof Salmon)
            return 2;

        return 3;
    }

    //

    /**
     * COMPUTATION FOR TEMPURA
     * @return int
     */
    public int calculateTempura(){
        if (tempuraCount >= 2)
            return 5*(tempuraCount/2);

        return 0;
    }

    //

    /**
     * COMPUTATION FOR SASHIMI
     * @return int
     */
    public int calculateSashimi(){
        // TODO
        if (sashimiCount >= 3 )
            return 10 * (sashimiCount/3);

        return 0;
    }

    //

    /**
     * COMPUTATION FOR DUMPLINGS
     * @return
     */
    public int calculateDumplings(){
        // TODO
        if (dumplingsCount >= 5)
            return 15;
        else if (dumplingsCount == 4)
            return 10;
        else if (dumplingsCount == 3)
            return 6;
        else if (dumplingsCount == 2)
            return 3;

        return dumplingsCount;
    }

    //

    /**
     * COMPUTATION FOR TOFU
     * @return
     */
    public int calculateTofu(){
        // TODO
        if (tofuCount==1)
            return 2;
        else if (tofuCount==2)
            return 6;

        return 0;
    }

    //

    /**
     * COMPUTATION FOR GREEN TEA ICE CREAM
     * @return int
     */
    public int calculateGreenTea(){
        if (greenTeaCount >= 4)
            return 12 * (greenTeaCount/4);

        return 0;
    }

    //

    /**
     * COMPUTATION FOR MAKI
     * @param player
     * @param roundStatistics
     * @return int
     */
    public int calculateMaki(Player player, RoundStatistics roundStatistics){
        if (player.equals(roundStatistics.getHighestMaki()))
            return 6;
        else if (player.equals(roundStatistics.getSecondMostMaki()))
            return 3;
        return 0;
    }

    //

    /**
     * COMPUTATION FOR MISO SOUP
     * @param player
     * @param players
     * @param misoSoup
     * @return int
     */
    public int calculateMiso(Player player, ArrayList<Player> players, MisoSoup misoSoup){
        // TODO
        boolean playedMiso = player.getPlayedMiso();
        boolean othersPlayed = false;

        for (Player p: players) {
            if (p.getPlayedMiso()) {
                if(!player.equals(p))
                    othersPlayed = true;
            }
        }

        if (!othersPlayed && playedMiso)
            return 3;
        else {
            GameData.board.getMainDeck().getCards().add(misoSoup);
            return 0;
        }

    }

    //

    /**
     * COMPUTATION FOR TEA
     * @param players
     * @return int
     */
    public int calculateTea(ArrayList<Player> players){
        // TODO

        int highest=0;

        // GETTING LARGEST SET OF SAME BACKGROUND COLOR OF EACH PLAYER
        for (Player player: players) {
            Map<Color, Long> counting = player.getKeepPile().stream().collect(
                    Collectors.groupingBy(Card::getColor, Collectors.counting()));

            Map.Entry<Color, Long> maxEntry = null;
            for (Map.Entry<Color, Long> entry: counting.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                    maxEntry = entry;
            }
            String value = maxEntry.getValue().toString();
            int intValue = Integer.parseInt(value);
            if (intValue < highest)
                highest = intValue;
        }


        return highest;
    }

    //

    /**
     * COMPUTATION FOR PUDDING
     * @param player
     * @param roundStatistics
     * @return int
     */
    public int calculatePudding(Player player, RoundStatistics roundStatistics){

        if (roundStatistics.getHighestPudding().equals(player))
            return 6;

        if (GameData.is2Player)
            if (roundStatistics.getLeastPudding().equals(player))
                return -6;
        return 0;
    }

}
