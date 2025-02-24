package models;

import java.util.HashMap;
import java.util.Map;

public class GameHistory {
    private final Map<Move, Integer> moveCount = new HashMap<>();
    private Move lastPlayerMove = null;

    public GameHistory() {
        for (Move move : Move.values()) {
            moveCount.put(move, 0);
        }
    }

    public void recordPlayerMove(Move move) {
        moveCount.put(move, moveCount.get(move) + 1);
        lastPlayerMove = move;
    }

    public Move getLeastUsedMove() {
        return moveCount.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Move getMostUsedMove() {
        return moveCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }

    public Move getLastPlayerMove() {
        return lastPlayerMove;
    }
}
