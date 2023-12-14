package BattleShip;

import java.util.ArrayList;
import java.util.List;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Player {
    private Board board = new Board();
    private List<Field> turns = new ArrayList<>();

    public Player() {
    }

    public void turn(Player otherPlayer, Coordinate coord) throws Exception {
        Field field = new Field(coord);
        if (this.turns.contains(field)) {
            System.out.println("This coordinate already was used: " + coord);
            return;
        }
        field.setShot(otherPlayer.shot(coord));
        this.turns.add(field);
    }
    
    public boolean shot(Coordinate coord) throws Exception {
        return this.board.shot(coord);
    }

    public boolean areAllShipsSunken() {
        return this.board.areAllShipsSunken();
    }

}
