package com.game.battleship.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.game.battleship.service.Impl.BattleShipServiceImpl;

/**
 * 
 */

/**
 * @author gopaljaiswal
 *
 *         Software Development Engineer
 *         Jan 30, 2019
 */
public class Battleship {

	private static BattleShipServiceImpl battleShipService;
	private static BufferedReader reader;

	// main method
	public static void main(String[] args) throws IOException {
		battleShipService = new BattleShipServiceImpl();
		reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enjoy the game (battleship..............)");
		System.out.println("Starting battleship Game for you..............)\n");
		char ch = 'C'; // default
		while (true) {

			if (!isEqualIngoreCase(ch, 'C')) {
				System.out.println("Succecfully Exited...");
				System.exit(0);
			}

			// get user input
			try {
				battleShipService.getuserInput(reader);
			} catch (Exception e) {
				System.out.println("Looks like some issue in input from user");
				e.printStackTrace();
			}

			// start battle
			battleShipService.startGame();

			System.out.println("\n\nPlease type C to continue playing..or type any other character to exit()");
			ch = reader.readLine().charAt(0);

		}
	}

	// support service
	public static boolean isEqualIngoreCase(char one, char two) {
		return Character.toLowerCase(one) == Character.toLowerCase(two);
	}
}
