package strategies;

import models.GameHistory;
import models.Move;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private final Random random = new Random();

    @Override
    public Move determineMove(GameHistory history) {
        return Move.values()[random.nextInt(3)];
    }
}
