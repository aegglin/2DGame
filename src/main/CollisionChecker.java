package main;

import entity.Entity;

public class CollisionChecker {
    
    public GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    // Don't want to pass a parameter, also want an entity
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.entityCollisionArea.x;
        int entityRightWorldX = entity.worldX + entity.entityCollisionArea.x + entity.entityCollisionArea.width;
        int entityTopWorldY = entity.worldY + entity.entityCollisionArea.y;
        int entityBottomWorldY = entity.worldY + entity.entityCollisionArea.y + entity.entityCollisionArea.height;
    
        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNumber1, tileNumber2;

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                if (gp.tileManager.tile[tileNumber1].collision || gp.tileManager.tile[tileNumber2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNumber1].collision || gp.tileManager.tile[tileNumber2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityLeftCol][entityTopRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityLeftCol][entityBottomRow];
                if (gp.tileManager.tile[tileNumber1].collision || gp.tileManager.tile[tileNumber2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNumber1 = gp.tileManager.mapTileNumber[entityRightCol][entityTopRow];
                tileNumber2 = gp.tileManager.mapTileNumber[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNumber1].collision || gp.tileManager.tile[tileNumber2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.gameObjects.length; i++) {
            if (gp.gameObjects[i] != null) {
                //Get entity's solid area position
               entity.entityCollisionArea.x = entity.worldX + entity.entityCollisionArea.x;
               entity.entityCollisionArea.y = entity.worldY = entity.entityCollisionArea.y;

                // Get object's solid area position/
                gp.gameObjects[i].gameObjectCollisionArea.x = gp.gameObjects[i].worldX + gp.gameObjects[i].gameObjectCollisionArea.x;
                gp.gameObjects[i].gameObjectCollisionArea.y = gp.gameObjects[i].worldY + gp.gameObjects[i].gameObjectCollisionArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.entityCollisionArea.y -= entity.speed;
                        if (entity.entityCollisionArea.intersects(gp.gameObjects[i].gameObjectCollisionArea)) {
                            System.out.println("Up collision");
                        }
                        break;
                    case "down":
                        entity.entityCollisionArea.y += entity.speed;
                        if (entity.entityCollisionArea.intersects(gp.gameObjects[i].gameObjectCollisionArea)) {
                            System.out.println("Down collision");
                        }
                        break;
                    case "left":
                        entity.entityCollisionArea.x -= entity.speed;
                        if (entity.entityCollisionArea.intersects(gp.gameObjects[i].gameObjectCollisionArea)) {
                            System.out.println("Left collision");
                        }
                        break;
                    case "right":
                        entity.entityCollisionArea.x += entity.speed;
                        if (entity.entityCollisionArea.intersects(gp.gameObjects[i].gameObjectCollisionArea)) {
                            System.out.println("Right collision");
                        }
                        break;
                }
                entity.entityCollisionArea.x = entity.entityCollisionAreaDefaultX;
                entity.entityCollisionArea.y = entity.entityCollisionAreaDefaultY;
                gp.gameObjects[i].gameObjectCollisionArea.x = gp.gameObjects[i].gameObjectDefaultX;
                gp.gameObjects[i].gameObjectCollisionArea.y = gp.gameObjects[i].gameObjectDefaultY;
            }
        }

        return index;
    }
}
