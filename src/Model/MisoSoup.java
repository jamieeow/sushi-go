package Model;

import javafx.scene.image.Image;

import java.awt.*;

//

/**
 * MISO SOUP CLASS EXTENDING CARD CLASS
 */
public class MisoSoup extends Appetizer {
    public MisoSoup(String name, String description, Color color, String category, Image image) {
        super.name = name;
        super.description = description;
        super.color = color;
        super.category = category;
        super.image = image;
    }
}
