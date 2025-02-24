package models;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public static Move getWinningMove(Move move) {
        return switch (move) {
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }
}
