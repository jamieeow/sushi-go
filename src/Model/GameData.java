package Model;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

import java.awt.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

//

/**
 * A RECORD OF ALL THE GAME'S DATA
 */
public class GameData {
    public static boolean is2Player;
    public static ArrayList<String> menu = new ArrayList<>();
    public static ArrayList<Card> cards = new ArrayList<>();
    public static ArrayList<Appetizer> selectedAppetizers = new ArrayList<>();
    public static Dessert selectedDessert = new Dessert();
    public static ArrayList<Image> imageCards = new ArrayList<>();
    public static ArrayList<Image> imageMenu = new ArrayList<>();

    public static MainDeck mainDeck;

    public static String playerOneName;
    public static String playerTwoName;
    public static String playerThreeName;

    public static ArrayList<Player> players;

    public static Board board;

    // SUSHI DESCRIPTIONS //
    private static String NIGIRI_DESCRIPTION = "There are three types of nigiri.\n" +
            "\n" +
            "A squid nigiri scores 3 points.\n" +
            "A salmon nigiri scores 2 points.\n" +
            "An egg nigiri scores 1 point.";
    private static String ROLL_DESCRIPTION = "Each player adds up the maki roll icons at the top of their maki roll cards. The player with the most icons scores 6 points. \n" +
            "\n" +
            "If multiple players tie for the most, they split the 6 points evenly (ignoring any remainder) and no second place points are awarded.\n" +
            "\n" +
            "The player with the second most icons scores 3 points. If multiple players tie for second place, they split the points evenly (ignoring any remainder).";
    private static String TEMPURA_DESCRIPTION = "A set of 2 tempura card scores 5 points. A single tempura card is worth nothing. You may score multiple sets of tempura in one round.";
    private static String SASHIMI_DESCRIPTION = "A set of 3 sashimi card scores 10 points. A single sashimi card or a set of only 2 is worth nothing. You may score multiple sets of sashimi in one round.";
    private static String DUMPLINGS_DESCRIPTION = "The more dumpling cards you have, the more points you will score.\n" +
            "\n" + "Count: 1 2 3 4 5+" + "\n" +
            "Points: 1 3 6 10 15";
    private static String MISOSOUP_DESCRIPTION = "If only one miso soup is played in a turn by all players, the miso soup card stays in the player’s area until the end of the round and will score 3 points.\n" +
            "\n" +
            "If more than one player plays miso soup in a turn, all these miso soup cards are immediately discarded and will not score at the end of the round. These discarded miso soup cards should be shuffled back into the deck for the next round.";
    private static String TOFU_DESCRIPTION = "If the player has one tofu, player scores 2 points.\n" +
            "If the player has 2 tofu, player scores 6 points.\n" +
            "If player has 3 or more tofu, all are worth 0 points.";
    private static String WASABI_DESCRIPTION = "Wasabi doubles the points of a nigiri. A wasabi must be played first before a nigiri for the points of the nigiri to double.";
    private static String TEA_DESCRIPTION = "Count the number of cards in the largest (or tied for largest) set of cards with the same background color for each player. Having the tea is worth 1 point per card in that set.";
    private static String GREEN_DESCRIPTION = "A set of 4 green tea ice cream cards scores 12 points. At the end of the game, 1, 2 or 3 green tea ice cream cards are worth nothing. A player may have multiple sets of green tea ice cream.";
    private static String PUDDING_DESCRIPTION = "Players with the most pudding cards scores 6 points. Players with the least (including 0) loses 6 points. In a 2 player game, the player with the fewest pudding does not lose any points.";

    // SUSHI IMAGES //
    private static Image eggImage = new Image("/View/resources/CARDS/Egg.png");
    private static Image salmonImage = new Image("/View/resources/CARDS/Salmon.png");
    private static Image squidImage = new Image("/View/resources/CARDS/Squid.png");
    private static Image makiImage = new Image("/View/resources/CARDS/Maki.png");
    private static Image wasabiImage = new Image("/View/resources/CARDS/Wasabi.png");
    private static Image teaImage = new Image("/View/resources/CARDS/Tea.png");
    private static Image tempuraImage = new Image("/View/resources/CARDS/Tempura.png");
    private static Image sashimiImage = new Image("/View/resources/CARDS/Sashimi.png");
    private static Image dumplingsImage = new Image("/View/resources/CARDS/Dumplings.png");
    private static Image misoSoupImage = new Image("/View/resources/CARDS/Miso Soup.png");
    private static Image tofuImage = new Image("/View/resources/CARDS/Tofu.png");
    private static Image greenTeaImage = new Image("/View/resources/CARDS/Green Tea Ice Cream.png");
    private static Image puddingImage = new Image("/View/resources/CARDS/Pudding.png");

    // SUSHI CLASSES //
    private static Card squid = new Squid("Squid", NIGIRI_DESCRIPTION, new Color(252, 191, 44), "Nigiri", eggImage);
    private static Card salmon = new Salmon("Salmon", NIGIRI_DESCRIPTION, new Color(252, 191, 44), "Nigiri", salmonImage);
    private static Card egg = new Egg("Egg", NIGIRI_DESCRIPTION, new Color(252, 191, 44), "Nigiri", eggImage);
    private static Card maki = new Maki("Maki", ROLL_DESCRIPTION, new Color(199, 22, 38), "Roll", makiImage);
    private static Card wasabi = new Wasabi("Wasabi", WASABI_DESCRIPTION, new Color(252, 191, 44), "Special", wasabiImage);
    private static Card tea = new Tea("Tea", TEA_DESCRIPTION, new Color(133, 10, 24), "Special", teaImage);
    private static Card tempura = new Tempura("Tempura", TEMPURA_DESCRIPTION, new Color(180, 130, 184), "Appetizer", tempuraImage);
    private static Card sashimi = new Sashimi("Sashimi", SASHIMI_DESCRIPTION, new Color(189, 214, 50), "Appetizer", sashimiImage);
    private static Card dumplings = new Dumplings("Dumplings", DUMPLINGS_DESCRIPTION, new Color(90, 132, 195), "Appetizer", dumplingsImage);
    private static Card misoSoup = new MisoSoup("Miso Soup", MISOSOUP_DESCRIPTION, new Color(22, 114, 104), "Appetizer", misoSoupImage);
    private static Card tofu = new Tofu("Tofu", TOFU_DESCRIPTION, new Color(97, 154, 50), "Appetizer", tofuImage);
    private static Card greenTea = new GreenTeaIceCream("Green Tea Ice Cream", GREEN_DESCRIPTION, new Color(54, 143, 164), "Dessert", greenTeaImage);
    private static Card pudding = new Pudding("Pudding", PUDDING_DESCRIPTION, new Color(246, 162, 167), "Dessert", puddingImage);


    //

    /**
     * INITIALIZATION OF MENU //
     */
    public static void initializeMenu() {
        menu.add("Nigiri");
        menu.add("Maki");
        menu.add("Wasabi");
        menu.add("Tea");
        cards.add(squid);
        cards.add(salmon);
        cards.add(egg);
        cards.add(maki);
        cards.add(wasabi);
        cards.add(tea);
        imageCards.add(new Image("/View/resources/CARDS/Egg.png"));
        imageCards.add(new Image("/View/resources/CARDS/Salmon.png"));
        imageCards.add(new Image("/View/resources/CARDS/Squid.png"));
        imageCards.add(new Image("/View/resources/CARDS/Maki.png"));
        imageCards.add(new Image("/View/resources/CARDS/Wasabi.png"));
        imageCards.add(new Image("/View/resources/CARDS/Tea.png"));
        imageMenu.add(new Image("/View/resources/CARDS/MENU/Default/Nigiri.png"));
        imageMenu.add(new Image("/View/resources/CARDS/MENU/Default/Maki.png"));
        imageMenu.add(new Image("/View/resources/CARDS/MENU/Default/Wasabi.png"));
        imageMenu.add(new Image("/View/resources/CARDS/MENU/Default/Tea.png"));
    }

    //

    /**
     *  INITIALIZES THE GAME
     */
    public static void initializeGame() {
        initializeCards();
        initializeMainDeck();
        initializePlayers();
        initializeBoard();

        for (Card card: mainDeck.getCards())
            System.out.println(card.getName());
    }

    //

    /**
     * INITIALIZE CARDS //
     */
    public static void initializeCards() {
        for (String string: menu) {
            switch (string) {
                case "Tempura":
                    cards.add(tempura);
                    break;
                case "Sashimi":
                    cards.add(sashimi);
                    break;
                case "Dumplings":
                    cards.add(dumplings);
                    break;
                case "Miso Soup":
                    cards.add(misoSoup);
                    break;
                case "Tofu":
                    cards.add(tofu);
                    break;
                case "Green Tea Ice Cream":
                    cards.add(greenTea);
                    break;
                case "Pudding":
                    cards.add(pudding);
                    break;
            }
        }
        int index=0;
        for (Card card: cards) {
            if (card instanceof Appetizer) {
                Appetizer app = (Appetizer) card;
                selectedAppetizers.add(index, app);
                index++;
            }
            else if (card instanceof Dessert)
                selectedDessert = (Dessert) card;
        }

    }

    // //

    /**
     * INITIALIZATION OF PLAYERS, BOARD, AND MAIN DECK
     */
    public static void initializeMainDeck() {
        Random random = new Random();

        ArrayList<Card> mainDeckCards = new ArrayList<>();

        // INSTANTIATING 12 ROLLS AND 12 NIGIRI CARDS
        for (int i = 0; i < 12; i++) {
            mainDeckCards.add(maki);

            int num = random.nextInt(3 - 1 + 1) + 1;
            switch (num) {
                case 1:
                    mainDeckCards.add(egg);
                    break;
                case 2:
                    mainDeckCards.add(salmon);
                    break;
                case 3:
                    mainDeckCards.add(squid);
                    break;
            }
        }

        // INSTANTIATING 3 OF EACH SPECIAL CARD
        for (int i = 0; i < 3; i++) {
            mainDeckCards.add(wasabi);
            mainDeckCards.add(tea);
        }

        // INSTANTIATING 8 OF EACH APPETIZER
        for (int i = 0; i < 8; i++) {
            mainDeckCards.add(selectedAppetizers.get(0));
            mainDeckCards.add(selectedAppetizers.get(1));
            mainDeckCards.add(selectedAppetizers.get(2));
        }

        mainDeck = new MainDeck(mainDeckCards, 5);

        mainDeck.addDessert(selectedDessert);
    }

    //

    /**
     * INITIALIZES PLAYERS
     */
    public static void initializePlayers() {
        if (is2Player) {
            Player player1 = new Player(playerOneName);
            Player player2 = new Player(playerTwoName);
            players = new ArrayList<>();
            players.add(player1);
            players.add(player2);
        } else {
            Player player1 = new Player(playerOneName);
            Player player2 = new Player(playerTwoName);
            Player player3 = new Player(playerThreeName);
            players = new ArrayList<>();
            players.add(player1);
            players.add(player2);
            players.add(player3);
        }
    }

    //

    /**
     * INITIALIZES THE BOARD
     */
    public static void initializeBoard() {
        if (is2Player) {
            board = new Board(players, new RoundStatistics(), new PointsCalculator(), mainDeck);
        } else {
            board = new Board(players, new RoundStatistics(), new PointsCalculator(), mainDeck);
        }
    }
}
