package BattleShip;

import java.util.Objects;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Field {
    private Coordinate coord;
    private boolean shot;

    public Field(Coordinate coord) {
        this.coord = coord;
    }

    public Coordinate getCoord() {
        return coord;
    }
    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public void shot() {
        this.shot = true;
    }
    public boolean isShot() {
        return shot;
    }

    public boolean isEquals(Field other) {
        return this.coord.getX() == other.getCoord().getX() && this.coord.getY() == other.getCoord().getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field)) return false;
        Field field = (Field) o;
        return Objects.equals(getCoord(), field.getCoord());
    }

}
