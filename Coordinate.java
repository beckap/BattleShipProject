package BattleShip;

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
}
