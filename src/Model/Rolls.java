package Model;

import javafx.scene.image.Image;

import java.awt.*;

// ROLL CLASS EXTENDING CARD CLASS
public class Rolls extends Card {
    public Rolls () {}
    public Rolls(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
