package BattleShip;

import java.util.Objects;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Invalid coordinate.");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean isEquals(Coordinate other) {
        return this.getX() == other.getX() && this.getY() == other.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() && getY() == that.getY();
    }
}
