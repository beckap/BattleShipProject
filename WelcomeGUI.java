package BattleShip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI extends JFrame {

    public WelcomeGUI() {
        JFrame welcomeFrame = new JFrame();
        setLocation(300,300);
        setSize(400,100);
        JLabel welcomeLabel = new JLabel("Welcome to Battleship!");
        Font myFont = new Font("SansSerif", Font.BOLD, 23);
        JLabel label = new JLabel("Choose your grid:");
        JButton tenButton = new JButton("10x10");
        JButton eightButton = new JButton("8x8");
        welcomeLabel.setFont(myFont);
        Font bodyFont = new Font("SansSarif", Font.PLAIN, 15);
        label.setFont(bodyFont);
        JPanel panel = new JPanel();
        add(welcomeLabel, BorderLayout.CENTER);
        panel.add(label, BorderLayout.NORTH);
        panel.add(eightButton, BorderLayout.EAST);
        panel.add(tenButton, BorderLayout.WEST);
        add(panel, BorderLayout.SOUTH);
    }

    protected void changeFrames(JButton button, JFrame frame1, JFrame frame2) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                frame2.setVisible(true);
            }
        });
    }
}
