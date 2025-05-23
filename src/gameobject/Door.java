package gameobject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Door extends GameObject {
    public Door() {
        name = "Door";
        try {
            image = ImageIO.read(new File("2DGame/res/gameobjects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
