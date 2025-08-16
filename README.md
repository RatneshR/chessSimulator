# chessSimulator
Service Application for Chess Simulation Moves
chess-simulator/
├── src/
│   ├── main/
│   │   └── java/com/example/chess/
│   │       ├── ChessSimulatorApplication.java       # Entry point
│   │       ├── model/                               # Domain models
│   │       │   ├── Position.java
│   │       │   ├── Piece.java                       # Abstract base class
│   │       │   ├── King.java
│   │       │   ├── Queen.java
│   │       │   └── Pawn.java
│   │       ├── service/                             # Business logic
│   │       │   └── MovementService.java             # Dispatcher for move logic
│   │       ├── util/                                # Helpers
│   │       │   └── BoardUtils.java                  # Board bounds, conversions
│   │       └── cli/                                 # Console interface (optional)
│   │           └── ChessCLI.java                    # Reads input, prints output
│   └── test/
│       └── java/com/example/chess/
│           ├── model/
│           │   ├── KingTest.java
│           │   ├── QueenTest.java
│           │   └── PawnTest.java
│           └── service/
│               └── MovementServiceTest.java