package main;

import entity.Player;
import tile.TileManager;

import java.lang.Thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    private final int originalTileSize = 16; // 16 x 16 tile
    private final int scale = 3; // used for scaling for higher resolution monitors

    public final int tileSize = originalTileSize * scale; // 48 x 48 tile
    public  final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    // World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    private int fps = 60;

    public TileManager tileManager = new TileManager(this);
    private KeyHandler keyHandler = new KeyHandler();
    private Thread gameThread; // Can start and stop

    public Player player = new Player(this, keyHandler);
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    public GamePanel() {
        // JPanel methods
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // better rendering performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Thread method
    // @Override
    // public void run() {
        
    //     // Divide one second (1 billion nanoseconds) by fps
    //     double drawInterval = 1000000000/fps;
    //     double nextDrawTime = System.nanoTime() + drawInterval;

    //     // Main game loop
    //     while (gameThread != null) {
    //         update();
    //         repaint();

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime();
    //             remainingTime = remainingTime / 1000000; // Convert nanoseconds to

    //             if (remainingTime < 0) {
    //                 remainingTime = 0;
    //             }
    //             Thread.sleep((long)remainingTime);
    //             nextDrawTime += drawInterval;
    //         }
    //         catch(InterruptedException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    // Delta accumulator method
    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta --;
            }
        }
    }

    public void update() {
       player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tileManager.draw(g2);
        player.draw(g2);

        g2.dispose(); // Not strictly necessary
    }
}
