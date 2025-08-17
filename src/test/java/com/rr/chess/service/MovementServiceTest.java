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
        assertTrue(moves.size() > 0);
    }

    @Test
    void testPawnMoves() {
        Pawn pawn = new Pawn();
        Position pos = new Position('E', 2);
        List<Position> moves = service.getValidMoves(pawn, pos);
        assertEquals(1, moves.size());
//        assertEquals(new Position('})
    }
}