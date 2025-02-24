package models;

import strategies.*;

import java.util.Random;

public class ComputerPlayer {
    private final GameHistory history;
    private final Random random = new Random();
    private final Strategy[] strategies = {
            new LeastUsedStrategy(),
            new MostUsedStrategy(),
            new LastUsedStrategy(),
            new RandomStrategy(),
            new CheatStrategy()
    };

    public ComputerPlayer(GameHistory history) {
        this.history = history;
    }

    public Move makeMove() {
        Strategy strategy = strategies[random.nextInt(strategies.length)];
        return strategy.determineMove(history);
    }
}
