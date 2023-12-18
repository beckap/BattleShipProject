package BattleShip;

import java.util.Objects;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Coordinate {
    /**
     * Horizontal Coordinate
     */
    private int x;
    /**
     * Vertical Coordinate
     */
    private int y;

    /**
     * Class constructor that accepts both coordinates
     * @param x horizontal coordinate
     * @param y vertical coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x coordinate
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y coordinate
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Compares two coordinates and returns if they are the same or not
     * @param other other coordinate
     * @return true or false
     */
    public boolean isEquals(Coordinate other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }

    /**
     * Compares coordinates to see if they are equal
     * @param o other object
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() && getY() == that.getY();
    }
}
