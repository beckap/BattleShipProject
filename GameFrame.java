package BattleShip;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    GameFrame() throws IOException {
        this.setTitle("Java Battleship");
        ComputerPanel pPanel = new ComputerPanel(true);
        ComputerPanel cPanel = new ComputerPanel(false);
        this.add(pPanel, BorderLayout.WEST);
        this.add(cPanel, BorderLayout.EAST);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
