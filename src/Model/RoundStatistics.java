package Model;

import java.util.ArrayList;
import java.util.List;

//

/**
 * RECORDS STATISTICS PER ROUND
 */
public class RoundStatistics {

    private int roundCount;
    private Player highestMaki, secondMostMaki, highestPudding, leastPudding;

    // CONSTRUCTOR //

    public RoundStatistics() {
        roundCount = 1;
    }

    // GETTERS //

    //

    /**
     * RETURNS THE CURRENT ROUND
     * @return roundCount
     */
    public int getRoundCount() {
        return roundCount;
    }

    //

    /**
     * RETURNS THE PLAYER WITH THE HIGHEST MAKI OF THE ROUND
     * @return highestMaki
     */
    public Player getHighestMaki() {
        return highestMaki;
    }

    //

    /**
     * RETURNS THE PLAYER WITH THE SECOND MOST MAKI OF THE ROUND
     * @return secondMostMaki
     */
    public Player getSecondMostMaki() {
        return secondMostMaki;
    }

    //

    /**
     * RETURNS THE PLAYER WITH THE HIGHEST PUDDING OF THE ROUND
     * @return highestPudding
     */
    public Player getHighestPudding() {
        return highestPudding;
    }

    //

    /**
     * RETURNS THE PLAYER WITH THE LEAST PUDDING OF THE ROUND
     * @return leastPudding
     */
    public Player getLeastPudding() {
        return leastPudding;
    }

    // METHODS //

    //

    /**
     * ADDS THE ROUND COUNT; CURRENT ROUND
     */
    public void nextRound() {
        this.roundCount++;
    }

    //

    /**
     * COMPUTES THE STATISTICS OF THE ROUND BY GETTING THE LIST OF PLAYERS
     * @param players
     */
    public void getRoundStats(ArrayList<Player> players) {

        int[] makiCount = new int[players.size()];
        int[] puddingCount = new int[players.size()];

        // COUNTS ALL THE MAKI AND PUDDING IN EACH PLAYERS' LIST OF CARDS
        int i=0;
        for (Player player: players) {
            makiCount[i]=0;
            puddingCount[i]=0;
            for (Card card: player.getKeepPile()) {
                if (card instanceof Maki)
                    makiCount[i]++;
                else if (card instanceof Pudding)
                    puddingCount[i]++;
                else if (card instanceof Wasabi)
                    player.setPlayedWasabi(true);
                else if (card instanceof MisoSoup)
                    player.setPlayedMiso(true);
            }
            i++;
        }

        //
        /**
         * GETS ALL THE PLAYER WITH THE MOST MAKI, SECOND MOST MAKI, MOST PUDDING, LEAST PUDDING OF THE ROUND
         */
        int makiHighest=0, makiIndex=0, makiSecond=0, makiSecondIndex=0, puddingMax=0, puddingMaxIndex=0, puddingLeast=0, puddingLeastIndex=0;
        for (i=0; i<players.size(); i++) {
            if (makiHighest < makiCount[i]) {
                makiSecond = makiHighest;
                makiSecondIndex = makiIndex;
                makiHighest = makiCount[i];
                makiIndex = i;
            } else if (makiSecond < makiCount[i]) {
                makiSecond = makiCount[i];
                makiSecondIndex = i;
            } if (puddingMax < puddingCount[i]) {
                puddingMax = puddingCount[i];
                puddingMaxIndex = i;
            } if (puddingLeast >= puddingCount[i]) {
                puddingLeast = puddingCount[i];
                puddingLeastIndex = i;
            }
        }

        highestMaki = players.get(makiIndex);
        highestPudding = players.get(puddingMaxIndex);
        secondMostMaki = players.get(makiSecondIndex);
        leastPudding = players.get(puddingLeastIndex);

    }
}
