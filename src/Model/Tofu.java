package Model;

import javafx.scene.image.Image;

// TOFU CLASS EXTENDING APPETIZER CLASS
import java.awt.*;

public class Tofu extends Appetizer {
    public Tofu (String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
