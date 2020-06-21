package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardImage extends ImageView {
    private Card card;

    public CardImage() {}
    public CardImage(Card card ) {
        this.card = card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

}
