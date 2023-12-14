package BattleShip;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class Ship {

    private Field[] fields;
    private boolean isHorizontal;
    private Coordinate origin;
    private int intactFields;

    public Ship(int length, boolean isHorizontal, Coordinate origin) {
        this.fields = new Field[length];
        this.isHorizontal = isHorizontal;
        this.origin = origin;
        this.intactFields = length;
        this.createFields();
    }

    public Field[] getFields() {
        return fields;
    }

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

    public boolean isSunken() {
        return this.intactFields == 0;
    }

    public boolean isInShip(Coordinate coord) {
        for (Field f: this.fields) {
            if (f.getCoord().isEquals(coord)) {
                return true;
            }
        }
        return false;
    }

    public Field getField(Coordinate coord) {
        for (Field f : this.fields) {
            if (f.getCoord().isEquals(coord)) {
                return f;
            }
        }
        return null;
    }

    public boolean shot(Coordinate coord) {
        if (isInShip(coord)) {
            Field field = getField(coord);
            field.shot();
            this.intactFields--;
            return true;
        }
        return false;
    }

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
