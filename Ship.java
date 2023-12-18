package BattleShip;

import java.io.IOException;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Ship {

    /**
     * Characteristics of a Ship
     */
    private Field[] fields;
    private boolean isHorizontal;
    private Coordinate origin;
    private int intactFields;

    /**
     * Ship constructor that accepts it's leangth, horizontal/vertical, and origin on grid
     * @param length length of ship
     * @param isHorizontal horizontal or vertical
     * @param origin origin
     */
    public Ship(int length, boolean isHorizontal, Coordinate origin) {
        this.fields = new Field[length];
        this.isHorizontal = isHorizontal;
        this.origin = origin;
        this.intactFields = length;
        this.createFields();
    }

    /**
     * Returns the fields of the ship
     * @return fields
     */
    public Field[] getFields() {
        return fields;
    }

    /**
     * Creates the location fields of the ship based on origin and direction
     */
    private void createFields() {
        this.fields[0] = new Field(this.origin);
        for (int i = 1; i < this.fields.length; i++) {
            if (isHorizontal) {
                this.fields[i] = new Field(new Coordinate( this.origin.getX() + i, this.origin.getY()));
            } else {
                this.fields[i] = new Field(new Coordinate( this.origin.getX(), this.origin.getY() + i));
            }
        }
    }

    /**
     * Returns if the ship is sunked
     * @return true or false
     */
    public boolean isSunken() {
        return this.intactFields == 0;
    }

    /**
     * Checks if the coordinate is part of a ship
     * @param coord coordinate
     * @return true or false
     */
    public boolean isInShip(Coordinate coord) {
        for (Field f: this.fields) {
            if (f.getCoord().isEquals(coord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the coordinate is part of the ship and returns its field
     * @param coord coordinate
     * @return field or null if not
     */
    public Field getField(Coordinate coord) {
        for (Field f : this.fields) {
            if (f.getCoord().isEquals(coord)) {
                return f;
            }
        }
        return null;
    }

    /**
     * If coordinate is in ship, the field is shot and removes an intact part of the ship because it has been
     * shot there
     * @param coord coordinate
     * @return true or false
     */
    public boolean shot(Coordinate coord, GridButton[][] ButtonArray) throws IOException {
        if (isInShip(coord)) {
            System.out.println("SHOTTTT");
            ButtonArray[coord.getY()][coord.getX()].hitShip();
            Field field = getField(coord);
            field.shot();
            this.intactFields--;
            return true;
        }
        else { ButtonArray[coord.getY()][coord.getX()].miss(); }
        return false;
    }

    /**
     * Checks if the new ship intersects another ship when it is being positioned on grid
     * @param other other ship
     * @return true if it does, false if it doesn't
     */
    public boolean intersectsShip(Ship other) {
        for(Field f: this.fields) {
            for (Field fOther : other.fields) {
                if (f.getCoord().isEquals(fOther.getCoord())) {
                    return true;
                }
            }
        }
        return false;
    }
}
