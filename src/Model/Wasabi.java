package Model;

import javafx.scene.image.Image;

import java.awt.*;

// WASABI CLASS EXTENDING SPECIAL CLASS
public class Wasabi extends Special{
    public Wasabi (String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
