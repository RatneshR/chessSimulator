package com.rr.chess;

import com.rr.chess.model.*;
import com.rr.chess.service.MovementService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

/**
 * ChessSimulatorApplication is the entry point for the Chess Simulator application.
 * It initializes the Spring Boot application and provides a command-line interface
 * for user input to simulate chess piece movements.
 * Key Features:
 * - Uses CommandLineRunner to accept console input.
- Parses input like "King D5" and delegates to MovementService.
- Prints all valid moves or error messages
*/

@SpringBootApplication
public class ChessSimulatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChessSimulatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// This method can be used to execute code after the application has started
		System.out.println("Chess Simulator Application has started successfully!");

		MovementService movementService = new MovementService();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter piece and position (eg. King E5): ");
		String input = scanner.nextLine().trim();

		String[] parts = input.split(" ");
		if (parts.length != 2) {
			System.out.println("Invalid input format. Please use 'Piece Position' (e.g., 'King D5').");
			scanner.close();
			return;
		}

		String pieceName = parts[0].trim().toUpperCase();
		String positionStr = parts[1].trim().toUpperCase();

		Piece piece = switch (pieceName) {
			case "KING" -> new King();
			case "QUEEN" -> new Queen();
			case "PAWN" -> new Pawn();
			case "BISHOP" -> new Bishop();
			default -> null;
		};

		if(piece == null || positionStr.length() != 2) {
			System.out.println("Invalid piece type or position format. Please use 'King D5' format.");
			scanner.close();
			return;
		}

//		try {
//
//		}

		char file = positionStr.charAt(0);
		int rank = Character.getNumericValue(positionStr.charAt(1));

		Position position = new Position(file, rank);

		List<Position> validMoves = movementService.getValidMoves(piece, position);
		System.out.println("Valid moves: " + validMoves);
	}

}
