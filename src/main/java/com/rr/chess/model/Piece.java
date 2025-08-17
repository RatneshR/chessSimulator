package com.rr.chess.model;

public abstract class Piece {
    private final PieceType type;

    protected Piece(PieceType type) {
        this.type = type;
    }

    public PieceType getType() {
        return type;
    }
}
