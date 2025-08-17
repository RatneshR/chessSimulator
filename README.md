# chessSimulator
Service Application for Chess Simulation Moves

# ♟️ Chess Simulator

A simple console-based chess simulator built with Java and Maven. It calculates valid moves for **King**, **Queen**, and **Pawn** on an empty 8×8 chessboard.

---

## 🚀 Features

- Modular design using clean object-oriented principles
- Supports movement logic for:
    - King (1 step in all directions)
    - Queen (multi-step in all directions)
    - Pawn (1 step forward)
- Input-driven CLI interface
- Unit test coverage for movement logic

---

## 🧱 Project Structure


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
│   └── test/
│       └── java/com/example/chess/
│           └── service/
│               └── MovementServiceTest.java



---

## 🛠️ Setup Instructions

### Prerequisites
- Java 17+ (Java 24 compatible)
- Maven 4.x (or 3.6+)

### Run the App

```bash
# Clone the repo
git clone https://github.com/your-username/chess-simulator.git
cd chess-simulator

## Running through IntelliJ IDEA
# Open the project in IntelliJ IDEA
# Ensure Maven is configured correctly
# Run the main class `ChessSimulatorApplication.java`

## Running through Maven CLI
mvn clean install
mvn exec:java -Dexec.mainClass="com.example.chess.ChessSimulatorApplication"
```

# Compile and run
mvn compile
mvn exec:java -Dexec.mainClass="com.example.chess.ChessApplication"