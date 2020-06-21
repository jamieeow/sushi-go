package Model;

import java.awt.*;
import javafx.scene.image.Image;

// TEA CLASS EXTENDING SPECIALCLASS
public class Tea extends Special{
    public Tea (String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}





