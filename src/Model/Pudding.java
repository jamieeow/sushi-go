package Model;

import javafx.scene.image.Image;

import java.awt.*;

// PUDDING CLASS EXTENDING DESSERT CLASS
public class Pudding extends Dessert{
    public Pudding (String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
