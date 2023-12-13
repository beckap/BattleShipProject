package BattleShip;

import javax.swing.*;

public class GridButton extends JButton {
    private final int col;
    private final int row;

    public GridButton( int col, int row ){
        super();
        this.col = col;
        this.row = row;
    }

    public int getColumn(){ return this.col; }
    public int getRow(){ return this.row; }

}
