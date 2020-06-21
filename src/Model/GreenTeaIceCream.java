package Model;

import javafx.scene.image.Image;

import java.awt.*;

//

/**
 * GREEN TEA ICE CREAM CLASS EXTENDING DESSERT CLASS
 */
public class GreenTeaIceCream extends Dessert{
    public GreenTeaIceCream (String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
