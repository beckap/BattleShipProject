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
    /**
     * Player's board
     */
    private Board board = new Board();

    /**
     * Player's turns
     */
    private List<Field> turns = new ArrayList<>();
    private GridButton[][] buttons;

    /**
     * Player constructor
     */

    public Player(GridButton[][] buttons, boolean isPlayer ) throws IOException {
        this.buttons = buttons.clone();
        this.resetGame();
        this.board.setShipIcons(this.buttons, isPlayer);
    }
    
    /**
     * Resets game
     */
    public void resetGame() {
        board = new Board();
        turns = new ArrayList<>();
    }

    /**
     * Keeps track of your turns/shots
     * @param otherPlayer other player
     * @param coord coordinate
     * @throws Exception exception
     */
    public void turn(Player otherPlayer, Coordinate coord) throws Exception {
        Field field = new Field(coord);
        if (this.turns.contains(field)) {
            System.out.println("This coordinate already was used: " + coord);
            return;
        }
        field.setShot(otherPlayer.shot(coord, otherPlayer.getButtons()));
        this.turns.add(field);
    }

    /**
     * calss the shot method of the Board object
     * @param coord coordinate
     * @return true - field shot
     * @throws Exception exception
     */
    public boolean shot(Coordinate coord, GridButton[][] buttons) throws Exception {
        return this.board.shot(coord, buttons);
    }

    /**
     * Returns if all shits are sunken
     * @return true or false
     */
    public boolean areAllShipsSunken() {
        return this.board.areAllShipsSunken();
    }

    public Board getBoard() {
        return board;
    }

    public GridButton[][] getButtons(){
        return this.buttons.clone();
    }

}
