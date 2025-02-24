package strategies;

import models.GameHistory;
import models.Move;

public class LastUsedStrategy implements Strategy {
    @Override
    public Move determineMove(GameHistory history) {
        if (history.getLastPlayerMove() == null) {
            return Move.values()[(int) (Math.random() * 3)];
        }
        return Move.getWinningMove(history.getLastPlayerMove());
    }
}
