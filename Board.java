package BattleShip;

import javax.swing.*;
import javax.xml.transform.Source;
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
public class Board {

    /**
     * length of all 5 ships
     */
    private static int[] LENGTH_OF_SHIPS = {2,3,3,4,5};
    /**
     * Max size of board
     */
    private static int SIZE = 11;

    /**
     * Characteristics of the board
     */
    private Ship[] ships;
    private int size;

    /**
     * Opponent's shots to board
     */
    private List<Field> shots = new ArrayList<>();

    /**
     * Board constructor
     */
    public Board() {
        this.size = SIZE;
        this.ships = new Ship[LENGTH_OF_SHIPS.length];
        populateShipsRandomly();
    }

    /**
     * Returns the size of board
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Randomly sets the location of the ships on the board
     */
    private void populateShipsRandomly() {
        for (int i = 0; i < LENGTH_OF_SHIPS.length; i++) {
            Ship ship;
            do {
                boolean isHorizontal = (new Random().nextBoolean());
                Field originField = this.getRandomField(LENGTH_OF_SHIPS[i], isHorizontal);
                ship = new Ship(LENGTH_OF_SHIPS[i], isHorizontal, originField.getCoord());
            } while (!isValidShip(i, ship));
            this.ships[i] = ship;
        }
    }

    /**
     * Gets a random Field origin for the ships
     * @param length length of ship
     * @param isHorizontal horizontal or vertical
     * @return field
     */
    private Field getRandomField(int length, boolean isHorizontal) {
        int pos1 = (new Random().nextInt(this.size)) + 1;
        int pos2 = (new Random().nextInt(this.size - length)) + 1;
        Field f;
        if(isHorizontal) {
            f = new Field(new Coordinate(pos2, pos1));
        } else {
            f = new Field(new Coordinate(pos1, pos2));
        }
        return f;
    }

    /**
     * Checks if the ship does not intersect another or if the position is good
     * @param indexOfCurrentShip current ship size
     * @param ship ship to check
     * @return true or false
     */
    private boolean isValidShip(int indexOfCurrentShip, Ship ship) {
        for (int i = 0; i < indexOfCurrentShip; i++) {
            if (this.ships[i].intersectsShip(ship)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Keeps track of the opponent's shots on your board, the fields it has shot and the ships.
     * @param coord chosen coordinate to send shot
     * @return true - field shot
     * @throws Exception exception
     */
    public boolean shot(Coordinate coord, GridButton[][] ButtonArray) throws Exception {
        Field field = new Field(coord);
        if (this.shots.contains(field)) {
            throw new Exception("This coordinate was already used");
        }
        this.shots.add(field);
        for (Ship ship : this.ships) {
            field.setShot(ship.shot(coord, ButtonArray));
        }
        return field.isShot();
    }

    /**
     * Checks if all ships are sunken to determine if opponent has won
     * @return boolean
     */
    public boolean areAllShipsSunken() {
        for (Ship ship : this.ships) {
            if (!ship.isSunken()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Prints a board with random ships located
     */
    public void printShips() {
        String[][] board = new String[this.size][this.size];
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                board[x][y] = " - ";
            }
        }
        for (Ship ship : this.ships) {
            for(Field field : ship.getFields()) {
                Coordinate coord = field.getCoord();
                board[coord.getX()][coord.getY()] = " " + ship.getFields().length + " ";
            }
        }
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                System.out.print(board[x][y]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.printShips();
    }
    public void setShipIcons( GridButton[][] board, boolean isPlayer ) throws IOException {
        for (Ship ship : this.ships) {
            for(int i = 0; i < ship.getFields().length; i++){
                int orienter = 1;
                Coordinate coord = ship.getFields()[i].getCoord();
                board[coord.getY()][coord.getX()].makeShip(isPlayer, orienter);
            }
        }
    }
}