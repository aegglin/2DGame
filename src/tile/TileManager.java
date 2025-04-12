package tile;

import main.GamePanel;

public class TileManager {
    private GamePanel gp;
    private Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
    }
}
