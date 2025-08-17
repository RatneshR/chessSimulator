package com.rr.chess.model;

import com.rr.chess.util.BoardUtils;

import java.util.Objects;

public class Position {
    public final int row;
    public final int col;

    public Position(int row, int col) {
        if(!BoardUtils.isValid(row, col)) {
            throw new IllegalArgumentException("Invalid position: (" + row + ", " + col + ")");
        }
        this.row = row;
        this.col = col;
    }

    /**
     * Returns algebraic notation like "E2".
     */
    public String toCell() {
        return BoardUtils.toCell(row, col);
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ") - " + toCell();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Position)) return false;
        Position other = (Position) o;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
