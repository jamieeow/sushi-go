package Model;

import javafx.scene.image.Image;

import java.awt.*;


//
/**
 * DESSERT CLASS EXTENDING CARD CLASS
 */

public class Dessert extends Card {
    public Dessert () {}
    public Dessert(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
