package BattleShip;

import java.util.Objects;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Field {
    
    /**
     * Coordinate of the field
     */
    private Coordinate coord;

    /**
     * If the field has been shot or not
     */
    private boolean shot;

    /**
     * Class constructor of the object, accepts coordinate
     * @param coord coordinate in grid
     */
    public Field(Coordinate coord) {
        this.coord = coord;
    }

    /**
     * Returns coordinate
     * @return coordinate
     */
    public Coordinate getCoord() {
        return coord;
    }

    /**
     * Sets if the field has been shot
     * @param shot
     */
    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public void shot() {
        this.shot = true;
    }

    /**
     * Returns if the field is shot or not
     * @return shot
     */
    public boolean isShot() {
        return shot;
    }

    /**
     * Compares two fields with each other
     * @param other other field
     * @return true or false
     */
    public boolean isEquals(Field other) {
        return this.coord.getX() == other.getCoord().getX() && this.coord.getY() == other.getCoord().getY();
    }

    /**
     * Compares if two fields are equal to each other
     * @param o other object field
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;
        Field field = (Field) o;
        return Objects.equals(getCoord(), field.getCoord());
    }

    public String toString(){ return String.valueOf(getCoord()); }
}
