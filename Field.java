package BattleShip;

public class Field {
    private Coordinate coord;
    private boolean shot;

    public Field(Coordinate coord) {
        this.coord = coord;
    }

    public Coordinate getCoord() {
        return coord;
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
}
