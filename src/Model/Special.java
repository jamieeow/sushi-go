package Model;

import javafx.scene.image.Image;

import java.awt.*;

// SPECIAL CLASS EXTENDING CARD CLASS
public class Special extends Card {
    public Special () {}
    public Special (String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
