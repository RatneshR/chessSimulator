package com.rr.chess;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * ChessSimulatorApplication is the entry point for the Chess Simulator application.
 * It initializes the Spring Boot application and provides a command-line interface
 * for user input to simulate chess piece movements.
 *
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

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter input(eg. King E5): ");
		String input = scanner.nextLine().trim();

		try {
			String[] parts = input.split("\\s+");
			if (parts.length != 2) {
				throw new IllegalArgumentException("Input must be in the format 'Piece Position' (e.g., 'King E5').");
			}
			String pieceType = parts[0];
			String position = parts[1];

			// Here you can add logic to handle the piece type and position - Create a Movement Service

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

}
