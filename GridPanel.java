package BattleShip;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class GridPanel extends JPanel {
    private final int size = 10;
    private final int columns = size + 1;
    private final int rows = size + 1;
    private Player p1;
    private Player p2;
    private Map<String, ImageIcon> resourceMap = new HashMap<>();
    private GridButton[][] buttonArrayArray = new GridButton[columns][rows];

    public GridPanel( boolean isPlayer ) throws IOException {
        resourceMap.put("01", getImageIcon("A"));
        resourceMap.put("02", getImageIcon("B"));
        resourceMap.put("03", getImageIcon("C"));
        resourceMap.put("04", getImageIcon("D"));
        resourceMap.put("05", getImageIcon("E"));
        resourceMap.put("06", getImageIcon("F"));
        resourceMap.put("07", getImageIcon("G"));
        resourceMap.put("08", getImageIcon("H"));
        resourceMap.put("09", getImageIcon("I"));
        resourceMap.put("010", getImageIcon("J"));
        resourceMap.put("10", getImageIcon("1"));
        resourceMap.put("20", getImageIcon("2"));
        resourceMap.put("30", getImageIcon("3"));
        resourceMap.put("40", getImageIcon("4"));
        resourceMap.put("50", getImageIcon("5"));
        resourceMap.put("60", getImageIcon("6"));
        resourceMap.put("70", getImageIcon("7"));
        resourceMap.put("80", getImageIcon("8"));
        resourceMap.put("90", getImageIcon("9"));
        resourceMap.put("100", getImageIcon("10"));

        setLayout(new GridLayout(rows, columns, 0, 0));
        for( int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                GridButton button = new GridButton(col, row);
                buttonArrayArray[row][col] = button;
                if(col==0 && row==0){
                    button.setVisible(false);
                }
                else if(col==0 || row==0) {
                    JLabel icon = new JLabel(resourceMap.get(String.valueOf(col) + String.valueOf(row)));
                    add(icon);
                    continue;
                }
                if(!isPlayer) { button.addActionListener(ButtonListener); }
                button.setPreferredSize(new Dimension(50, 50));
                add(button);
            }
        }
        if (isPlayer) {
            this.setBorder(new EmptyBorder(10, 0, 25, 30));
            p1 = new Player(this.buttonArrayArray, true);
        }
        else{
            this.setBorder(new EmptyBorder(10, 30, 25, 0));
            p2 = new PlayerComputer(this.buttonArrayArray, false);
        }
    }
    protected final Image getImage( String name ) throws IOException {
        return ImageIO.read(Objects.requireNonNull(getClass().getResource("Images/" + name + ".png")));
    }
    protected final ImageIcon getImageIcon( String name ) throws IOException {
        return new ImageIcon(getImage(name));
    }
    public int getGridSize(){
        return this.size;
    }
    public GridButton[][] getButtonArrayArray(){ return this.buttonArrayArray.clone(); }

    ActionListener ButtonListener = e ->  {
        GridButton b = (GridButton) e.getSource();
        try {
            GameFrame.getPlayerPanel().getGridPanel().p1.turn(p2, b.getCoord());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        for( ActionListener al : b.getActionListeners()){ b.removeActionListener(al); }
        System.out.println("Col: " + b.getCoord().getX() + " Row: " + b.getCoord().getY());
    };

}