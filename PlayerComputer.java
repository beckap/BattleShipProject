package BattleShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerComputer extends Player {
    private List<Coordinate> availableTurns;

    public PlayerComputer(GridButton[][] buttons, boolean isPlayer) throws IOException {
        super(buttons, isPlayer);
        this.resetGame();
    }

    public void resetGame() {
        super.resetGame();
        availableTurns = new ArrayList<>();
        for (int x = 0; x < this.getBoard().getSize(); x++) {
            for (int y = 0; y < this.getBoard().getSize(); y++) {
                availableTurns.add(new Coordinate(x, y));
            }
        }
    }

    public void turn(Player otherPlayer) throws Exception {
        if (this.availableTurns.isEmpty()) {
            throw new Exception("No more turns");
        }
        int chosenRandowIndex = (new Random()).nextInt(this.availableTurns.size());
        Coordinate coord = availableTurns.get(chosenRandowIndex);
        super.turn(otherPlayer, coord);
        this.availableTurns.remove(coord);
    }
}
