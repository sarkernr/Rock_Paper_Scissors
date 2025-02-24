package strategies;

import models.GameHistory;
import models.Move;

public interface Strategy {
    Move determineMove(GameHistory history);
}

