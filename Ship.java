package BattleShip;

public class Ship extends Field {
    public boolean sunken = false;
    public int intactParts;

    public Ship(int x, int y, int length, boolean horizontal) {
        super(x, y, length, horizontal);
        intactParts = this.getLength();
    }

    public boolean sunken() {
        if (intactParts == 0) {
            sunken = true;
            return true;
        }
        return false;
    }

    public void shot() {
        intactParts--;
    }
}
