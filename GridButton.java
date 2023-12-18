package BattleShip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class GridButton extends JButton {
    private final Coordinate coord;
    private final ImageIcon greyDot = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("Images/" + "GreyDot" + ".png"))));
    private boolean hit = false;

    public GridButton( int col, int row ) throws IOException {
        super();
        this.coord = new Coordinate(col, row);
    }

    public Coordinate getCoord(){ return this.coord; }

    protected void miss(){
        if(!hit){ this.setIcon(greyDot); }
    }
    protected void makeShip(boolean isPlayer, int orientation) throws IOException {
        ImageIcon shipDot = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("Images/state" + isPlayer + ".png"))));
        this.setIcon(shipDot);
    }
    protected void hitShip() throws IOException{
        hit = true;
        ImageIcon hitDot = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("Images/" + "A" + ".png"))));
        this.setIcon(hitDot);
    }
}
