package com.rr.chess.model;

import java.util.Objects;

public final class Position {
    private final char file;
    private final int rank;

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
