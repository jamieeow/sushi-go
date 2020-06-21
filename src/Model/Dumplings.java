package Model;

import javafx.scene.image.Image;

import java.awt.*;

//
/**
 * DUMPLINGS CLASS EXTENDING CARD CLASS
 */
public class Dumplings extends Appetizer {
    public Dumplings(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
