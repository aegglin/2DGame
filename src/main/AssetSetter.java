package main;

import gameobject.Chest;
import gameobject.Door;
import gameobject.Key;

public class AssetSetter {
    
    public GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.gameObjects[0] = new Key();
        gp.gameObjects[0].worldX = 23 * gp.tileSize;
        gp.gameObjects[0].worldY = 7 * gp.tileSize;

        gp.gameObjects[1] = new Key();
        gp.gameObjects[1].worldX = 23 * gp.tileSize;
        gp.gameObjects[1].worldY = 40 * gp.tileSize;

        gp.gameObjects[2] = new Key();
        gp.gameObjects[2].worldX = 38 * gp.tileSize;
        gp.gameObjects[2].worldY = 8 * gp.tileSize;

        gp.gameObjects[3] = new Door();
        gp.gameObjects[3].worldX = 10 * gp.tileSize;
        gp.gameObjects[3].worldY = 11 * gp.tileSize;

        gp.gameObjects[4] = new Door();
        gp.gameObjects[4].worldX = 8 * gp.tileSize;
        gp.gameObjects[4].worldY = 28 * gp.tileSize;

        gp.gameObjects[5] = new Door();
        gp.gameObjects[5].worldX = 12 * gp.tileSize;
        gp.gameObjects[5].worldY = 22 * gp.tileSize;

        gp.gameObjects[6] = new Chest();
        gp.gameObjects[6].worldX = 10 * gp.tileSize;
        gp.gameObjects[6].worldY = 7 * gp.tileSize;
    }
}
