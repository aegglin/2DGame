package gameobject;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends GameObject {

    public Key() {
        name = "Key";
        try {
            image = ImageIO.read(new File("2DGame/res/gameobjects/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
