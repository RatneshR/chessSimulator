package com.rr.chess.util;

import com.rr.chess.model.Position;

import java.util.List;
import java.util.ArrayList;

public final class BoardUtils {
    private BoardUtils() {}

    public static boolean isValidPosition(Position position) {
        return position != null &&
                position.file() >= 'A' && position.file() <= 'H' &&
                position.rank() >= 1 && position.rank() <= 8;
    }

    public static boolean isWithinBounds(char file, int rank) {
        return file >= 'A' && file <= 'H' && rank >= 1 && rank <= 8;
    }

    public static List<Position> generateLinearMoves(Position start, int fileStep, int rankStep) {
        List<Position> moves = new ArrayList<>();
        char file = start.file();
        int rank = start.rank();

        while(true) {
            file += fileStep;
            rank += rankStep;
            if(!isWithinBounds(file, rank)) break;
            moves.add(new Position(file, rank));
        }

        return moves;
    }
}