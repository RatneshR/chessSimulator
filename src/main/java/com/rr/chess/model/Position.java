package com.rr.chess.model;

import java.util.Objects;

/**
 * Represents a position on a chessboard.
 * The position is defined by a file (column) and a rank (row).
 */
// The file is represented by a character (a-h) and the rank by an integer (1-8).
// The file is case-insensitive, so 'a' and 'A' are considered the same file.
// The rank must be between 1 and 8, inclusive.
// The class provides methods to get the file and rank, convert the position to a string,
// and override the equals and hashCode methods for proper comparison and hashing.
public final class Position {
    //    It is immutable (final fields, no setters).
    private final char file;
    private final int rank;

    /**
     * Constructs a Position with the specified file and rank.
     *
     * @param file the file (column) of the position, should be a character from 'A' to 'H'
     * @param rank the rank (row) of the position, should be an integer from 1 to 8
     */
    public Position(char file, int rank) {
        this.file = Character.toUpperCase(file);
        this.rank = rank;
    }

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "" + file + rank;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(!(obj instanceof Position)) return false;

        Position position = (Position) obj;
        return file == position.file && rank == position.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
