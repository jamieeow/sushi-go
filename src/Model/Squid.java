package Model;

import javafx.scene.image.Image;

import java.awt.*;

// SQUID CLASS EXTENDING NIGIRI CLASS
public class Squid extends Nigiri {
    public Squid(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
