package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel); // Add panel to the JFrame

        window.pack();

        window.setLocationRelativeTo(null);//Window will be displayed at center of game
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
