package Model;

import javafx.scene.image.Image;

import java.awt.*;

// SASHIMI CLASS EXTENDING APPETIZER CLASS
public class Sashimi extends Appetizer {
    public Sashimi(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
