package Model;
import java.util.ArrayList;
import java.util.Collections;

//

/**
 * MAIN DECK WHICH INCLUDES THE CARDS AND DESSERT COUNT
 */
public class MainDeck {

    private ArrayList<Card> cards;
    private int dessertCount;

    // CONSTRUCTOR //
    public MainDeck (ArrayList<Card> cards, int dessertCount){
        this.cards = cards;
        this.dessertCount = dessertCount;
    }

    // METHODS //

    //

    /**
     * ADDING OF DESSERT CARDS TO THE MAIN DECK OF CARDS
     * @param dessert
     */
    public void addDessert(Dessert dessert){
        for (int i = 0; i < dessertCount; i++) {
            cards.add(dessert);
            System.out.println("added "+ dessert.getName());
        }
    }

    //

    /**
     * SHUFFLE THE MAIN DECK //
     */
    public void shuffleCards() {
        Collections.shuffle(cards);
    }

    // GETTERS //

    //

    /**
     * RETURNS THE MAIN DECK OF CARDS //
     * @return ArrayList<Cards>
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    //

    /**
     * RETURNS THE DESSERT COUNT //
     * @return dessertCount
     */
    public int getDessertCount() {
        return dessertCount;
    }

    // SETTERS //

    //

    /**
     * SETS THE COUNT OF DESSERT CARDS THAT WILL BE ADDED FOR THE ROUND
     * @param count
     */
    public void setDessertCount(int count) {
        dessertCount = count;
    }
}
