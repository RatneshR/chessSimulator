package com.rr.chess.service;


import com.rr.chess.model.*;
import com.rr.chess.service.MovementService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovementServiceTest {

    private final MovementService service = new MovementService();

    @Test
    void testKingMovesFromCenter() {
        King king = new King();
        Position pos = new Position('D', 4);
        List<Position> moves = service.getValidMoves(king, pos);
        assertEquals(8, moves.size());
    }

    @Test
    void testQueenMovesFromCorner() {
        Queen queen = new Queen();
        Position pos = new Position('A', 1);
        List<Position> moves = service.getValidMoves(queen, pos);
        assertFalse(moves.isEmpty());

        assertTrue(moves.contains(new Position('G', 1)));
//        , new Position('F',1), E1, D1, C1, B1, A1, H2, H3, H4, H5, H6, H7, H8, G2, F3, E4, D5, C6, B7, A8]);t
    }

    @Test
    void testPawnMoves() {
        Pawn pawn = new Pawn();
        Position pos = new Position('E', 2);
        List<Position> moves = service.getValidMoves(pawn, pos);
        assertEquals(1, moves.size());
//        assertEquals(new Position('})
    }

    @Test
    void testInvalidPosition() {
        Pawn pawn = new Pawn();
        Position pos = new Position('A', 0);
        List<Position> moves = service.getValidMoves(pawn, pos);
        assertTrue(moves.isEmpty());
    }

    @Test
    void testBishopMovesFromCorner() {
        Bishop bishop = new Bishop();
        Position pos = new Position('A', 1);
        List<Position> moves = service.getValidMoves(bishop, pos);
        assertFalse(moves.isEmpty());
    }
}