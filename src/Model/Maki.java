package Model;

import javafx.scene.image.Image;

import java.awt.*;

//

/**
 * MAKI CLASS EXTENDING ROLL CLASS
 */
public class Maki extends Rolls {
    public Maki(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
