package BattleShip;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Player {
    private Board board = new Board();
    private List<Field> turns = new ArrayList<>();

    public Player(GridButton[][] buttons, boolean isPlayer ) throws IOException {
        this.board.setShipIcons(buttons, isPlayer);
        this.resetGame();
    }

    public void resetGame() {
        board = new Board();
        turns = new ArrayList<>();
    }

    public void turn(Player otherPlayer, Coordinate coord) throws Exception {
        Field field = new Field(coord);
        if (this.turns.contains(field)) {
            JOptionPane.showMessageDialog(null, "This coordinate was already used! " + coord);
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

    public Board getBoard() {
        return board;
    }

}
