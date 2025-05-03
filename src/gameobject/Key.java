package gameobject;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Key extends SuperObject{

    public Key() {
        name = "Key";
        try {
            C://Users//aiden//dev//java//2DGame//2DGame//res//gameobjects//key.png
            image = ImageIO.read(new File("C://Users//aiden//dev//java//2DGame//2DGame//res//gameobjects//key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
