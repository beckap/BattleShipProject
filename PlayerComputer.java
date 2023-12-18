package BattleShip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CSCI 185 Fall 2023
 * Final Programming Project
 * @version 1
 * Rebeca Perez, Aidan Adame, Zarrin Islam -- Dec. 14, 2023
 */
public class PlayerComputer extends Player {
   /**
     * Available turns for computer to make
     */
    private List<Coordinate> availableTurns;
    private GridButton[][] buttons;

    /**
     * PlayerComputer constructor
     */
    public PlayerComputer(GridButton[][] buttons, boolean isPlayer) throws IOException {
        super(buttons, isPlayer);
        this.resetGame();
        this.buttons = buttons;
        this.getBoard().setShipIcons(this.buttons, isPlayer);

    }

    /**
     * Resets game and adds all coordinates of the board
     */
    public void resetGame() {
        super.resetGame();
        availableTurns = new ArrayList<>();
        for (int x = 0; x < this.getBoard().getSize(); x++) {
            for (int y = 0; y < this.getBoard().getSize(); y++) {
                availableTurns.add(new Coordinate(x, y));
            }
        }
    }

    /**
     * Computer's turn-generates a random coordinate and shots it.
     * @param otherPlayer other player
     * @throws Exception exception
     */
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
