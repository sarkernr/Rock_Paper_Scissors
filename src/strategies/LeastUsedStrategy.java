package strategies;

import models.GameHistory;
import models.Move;

public class LeastUsedStrategy implements Strategy {
    @Override
    public Move determineMove(GameHistory history) {
        return Move.getWinningMove(history.getLeastUsedMove());
    }
}
