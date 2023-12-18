package BattleShip;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    private static ComputerPanel pPanel;

    static {
        try {
            pPanel = new ComputerPanel(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ComputerPanel cPanel = new ComputerPanel(false);

    GameFrame() throws IOException {
        this.setTitle("Java Battleship");
        this.add(pPanel, BorderLayout.WEST);
        this.add(cPanel, BorderLayout.EAST);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    public static ComputerPanel getPlayerPanel(){ return pPanel; }
    public ComputerPanel getComputerPanel(){ return this.cPanel; }
}
