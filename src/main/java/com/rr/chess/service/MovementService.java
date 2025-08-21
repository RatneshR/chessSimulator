package com.rr.chess.service;

import com.rr.chess.model.PieceType;
import com.rr.chess.model.Piece;
import com.rr.chess.model.King;
import com.rr.chess.model.Queen;
import com.rr.chess.model.Pawn;
import com.rr.chess.model.Position;

import com.rr.chess.util.BoardUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * Service class for handling chess piece movements.
 * This class will contain methods to validate and execute movements for different chess pieces.
 */
public class MovementService {
    public List<Position> getValidMoves(Piece piece, Position position) {
        if(piece == null || position == null || !BoardUtils.isValidPosition(position)) {
            return Collections.emptyList();
        }

        return switch (piece.getType()) {
            case KING: yield getKingMoves(position);
            case QUEEN:
                yield getQueenMoves(position);
            case PAWN:
                yield  getPawnMoves(position);
            case BISHOP: yield getBishopMoves(position);
        };
    }

    private List<Position> getKingMoves(Position start) {
        List<Position> moves = new ArrayList<>();

        for(int df = -1; df <= 1; df++) {
            for(int dr = -1; dr <= 1; dr++) {
                if(df == 0 && dr == 0) continue; // Skip the current position

                char newFile = (char) (start.getFile() + df);

                int newRank = start.getRank() + dr;

                if(BoardUtils.isWithinBounds(newFile, newRank)) {
                    moves.add(new Position(newFile, newRank));
                }
            }
        }
        return moves;
    }

    private List<Position> getQueenMoves(Position start) {
        List<Position> moves = new ArrayList<>();

        moves.addAll(BoardUtils.generateLinearMoves(start, 1, 0)); // Right
        moves.addAll(BoardUtils.generateLinearMoves(start, -1, 0)); // Left
        moves.addAll(BoardUtils.generateLinearMoves(start, 0, 1)); // Up
        moves.addAll(BoardUtils.generateLinearMoves(start, 0, -1)); // Down
        moves.addAll(BoardUtils.generateLinearMoves(start, 1, 1)); // Up
        moves.addAll(BoardUtils.generateLinearMoves(start, -1, -1)); // Down
        moves.addAll(BoardUtils.generateLinearMoves(start, 1, -1)); // Down
        moves.addAll(BoardUtils.generateLinearMoves(start, -1, 1)); // Up
        return moves;
    }

    private List<Position> getPawnMoves(Position start) {
        List<Position> moves = new ArrayList<>();

        // Pawns can only move forward one square
        int newRank = start.getRank() + 1;

        if(BoardUtils.isWithinBounds(start.getFile(), start.getRank())){
            moves.add(new Position(start.getFile(), newRank));
        }
        return moves;
    }

    /*
    *
    * */
    private List<Position> getBishopMoves(Position start) {
        List<Position> moves = new ArrayList<>();

        moves.addAll(BoardUtils.generateLinearMoves(start, 1, 1)); // Up
        moves.addAll(BoardUtils.generateLinearMoves(start, -1, -1)); // Down
        moves.addAll(BoardUtils.generateLinearMoves(start, 1, -1)); // Down
        moves.addAll(BoardUtils.generateLinearMoves(start, -1, 1)); // Up

        return moves;
    }
}
