package strategies;

import models.GameHistory;
import models.Move;

import java.util.Random;

public class CheatStrategy implements Strategy {
    private final Random random = new Random();

    @Override
    public Move determineMove(GameHistory history) {
        if (random.nextDouble() < 0.1 && history.getLastPlayerMove() != null) {
            return Move.getWinningMove(history.getLastPlayerMove());
        }
        return Move.values()[random.nextInt(3)];
    }
}
