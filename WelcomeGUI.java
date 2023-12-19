package BattleShip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeGUI extends JFrame {
    String fileName = "options.ini";
    File optionFile = new File(fileName);
    PrintWriter writer;

    public WelcomeGUI() {
        createFile();
        setLocation(300,300);
        setSize(400,100);
        JLabel welcomeLabel = new JLabel("Welcome to Battleship!");
        Font myFont = new Font("SansSerif", Font.BOLD, 23);
        JButton tenButton = new JButton("Start Game!");
        tenButton.addActionListener(iniWriter);
        welcomeLabel.setFont(myFont);
        JPanel panel = new JPanel();
        add(welcomeLabel, BorderLayout.CENTER);
        panel.add(tenButton, BorderLayout.WEST);
        add(panel, BorderLayout.SOUTH);
        this.setVisible(true);
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

    ActionListener iniWriter = e ->  {
        try {
            new GameFrame();
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        /*JButton b = (JButton)e.getSource();
        System.out.println(b.getText().substring(0, b.getText().indexOf("x")));
        writer.write(b.getText().substring(0, b.getText().indexOf("x")));
        writer.close();*/
    };

    private void createFile(){
        try {
            optionFile.createNewFile();
            writer = new PrintWriter(optionFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomeGUI::new);
    }
}
