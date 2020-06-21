package Model;
import java.awt.*;
import javafx.scene.image.Image;

// ABSTRACT CLASS THAT IMPLEMENTS CARDINTERFACE INTERFACE
/**
 *
 */
public abstract class Card implements CardInterface{

    protected String name;
    protected String description;
    protected Color color;
    protected String category;
    protected Image image;

    public Card(){
        // DEFAULT CONSTRUCTOR
    }

    // CONSTRUCTOR
    public Card (String name, String description, Color color, String category, Image image){
        this.name = name;
        this.description = description;
        this.color = color;
        this.category = category;
        this.image = image;
    }

    //
    /**
     * RETURNS THE NAME OF THE CARD
     */
    public String getName () {
        return name;
    }

    //
    /**
     * RETURNS THE DESCRIPTION OF THE CARD
     */
    public String getDescription() {
        return description;
    }

    //
    /**
     * RETURNS THE COLOR OF THE CARD
     */
    public Color getColor() {
        return color;
    }

    //
    /**
     * RETURNS THE CATEGORY OF THE CARD
     */
    public String getCategory() {
        return category;
    }


    //
    /**
     * RETURNS THE IMAGE OF THE CARD
     */
    public Image getImage() { return image; }
}
