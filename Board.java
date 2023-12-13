package BattleShip;

import java.util.Random;

public class Board {
    private static int[] LENGTH_OF_SHIPS = {2,3,3,4,5};
    private int size = 10;
    private Ship[] ships;
    private Field[][] fields;

    public Board(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid Board size.");
        }
        this.size = size;
        this.fields = new Field[size][size];
        this.ships = new Ship[LENGTH_OF_SHIPS.length];
        populateShipsRandomly();
    }

    private void populateShipsRandomly() {
        for (int i = 0; i < LENGTH_OF_SHIPS.length; i++) {
            Ship ship;
            do {
                boolean isHorizontal = (new Random().nextBoolean());
                Field originField = this.getRandomField(LENGTH_OF_SHIPS[i],isHorizontal);
                ship = new Ship(LENGTH_OF_SHIPS[i], isHorizontal, originField.getCoord());
            } while (!isValidShip(i, ship));
            this.ships[i] = ship;
        }
    }

    private Field getRandomField(int length, boolean isHorizontal) {
        int pos1 = (new Random().nextInt(this.size));
        int pos2 = (new Random().nextInt(this.size - length));
        Field f;
        if(isHorizontal) {
            f = new Field(new Coordinate(pos2, pos1));
        } else {
            f = new Field(new Coordinate(pos1, pos2));
        }
        return f;
    }

    private boolean isValidShip(int indexOfCurrentShip, Ship ship) {
        for (int i = 0; i < indexOfCurrentShip; i++) {
            if (this.ships[i].intersectsShip(ship)) {
                return false;
            }
        }
        return true;
    }

}
