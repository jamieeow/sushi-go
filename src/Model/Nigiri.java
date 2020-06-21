package Model;

import javafx.scene.image.Image;

import java.awt.*;

//

/**
 * NIGIRI CLASS EXTENDING CARD CLASS
 */
public class Nigiri extends Card {
    public Nigiri(){}
    public Nigiri(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
