package gameobject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Chest extends GameObject {
    public Chest() {
        name = "Chest";
        try {
            image = ImageIO.read(new File("2DGame/res/gameobjects/chest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
