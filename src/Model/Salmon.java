package Model;

import javafx.scene.image.Image;

import java.awt.*;

// SALMON CLASS EXTENDING NIGIRI CLASS
public class Salmon extends Nigiri {
    public Salmon(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
