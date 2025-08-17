package com.rr.chess.util;

//import javax.swing.text.Position;

import com.rr.chess.model.Position;

import java.util.List;
import java.util.ArrayList;

public class BoardUtils {
    public static final int BOARD_SIZE = 8;
    public static final char[] COLUMNS = "ABCDEFGH".toCharArray();

    /**
     * Checks if a given row or column are within the board boundaries.
     */
    public static boolean isValid(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    /**
     * Converts board coordinates to algebraic notation.
     * For example, (0, 0) becomes "A1", (7, 7) becomes "H8".
     */
    public static String toCell(int row, int col) {
        return String.valueOf(COLUMNS[col]) + (BOARD_SIZE - row);
    }

    /**
     * Converts algebraic notation to board coordinates.
     * For example, "A1" becomes (0, 0), "H8" becomes (7, 7).
     */
    public static Position fromCell(String cell){
        if(cell.length() != 2) {
            throw new IllegalArgumentException("Invalid cell format: " + cell);
        }
        char colChar = Character.toUpperCase(cell.charAt(0));
        int rowNum = Character.getNumericValue(cell.charAt(1));

        int col = new String(COLUMNS).indexOf(colChar);
        int row = BOARD_SIZE - rowNum;

        if(!isValid(row, col)) {
            throw new IllegalArgumentException("Invalid cell: " + cell);
        }
        return new Position(row, col);
    }

    /**
     * Returns all 8 directions vectors for Queen and King.
     */
    public static int[][] getDirections() {
        return new int[][]{
                {-1, -1},// Up-Left
                {-1, 0}, // Up
                {-1, 1}, // Up-Right
                {0, -1}, // Left
                {0, 1},  // Right
                {1, -1}, // Down-Left
                {1, 0},  // Down
                {1, 1}   // Down-Right
        };
    }

    /**
     * Returns forward direction for Pawn (assuming white, moving up).
     */
    public static int[][] getPawnDirection() {
        return new int[][]{{-1, 0}}; // Up - White pawn moves "up" the board
    }

    /**
     * Return all valid positions from a given start and direction, for Queen.
     */
    public static List<Position> getLinearMoves(Position start, int dRow, int dCol) {
        List<Position> moves = new ArrayList<>();
        int row = start.row + dRow;
        int col = start.col + dCol;

        while(isValid(row, col)) {
            moves.add(new Position(row, col));
            row += dRow;
            col += dCol;
        }

        return moves;
    }
}
