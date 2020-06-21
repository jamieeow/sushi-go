package Model;

import javafx.scene.image.Image;

import java.awt.*;

/**
 *
 * APPETIZER CLASS EXTENDING CARD CLASS
 */
public class Appetizer extends Card {
    public Appetizer () {}
    public Appetizer(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
