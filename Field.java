package BattleShip;

public abstract class Field {
    private int x;
    private int y;
    private int length = 1;
    private boolean horizontal;

    public Field(int x, int y, int length, boolean horizontal) {
        if (length > 0) {
            this.length = length;
        }
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public abstract boolean sunken();
    public abstract void shot();
}
