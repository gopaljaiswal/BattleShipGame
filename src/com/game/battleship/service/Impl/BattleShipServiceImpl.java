/**
 * 
 */
package com.game.battleship.service.Impl;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gopaljaiswal
 *
 *         Software Development Engineer
 *         Jan 30, 2019
 */
public class BattleShipServiceImpl {

	private static AtomicInteger noOfBattleshipA = new AtomicInteger(0);
	private static AtomicInteger noOfBattleshipB = new AtomicInteger(0);

	private static ConcurrentHashMap<String, Integer> locBattleshipA = new ConcurrentHashMap<String, Integer>();
	private static ConcurrentHashMap<String, Integer> locBattleshipB = new ConcurrentHashMap<String, Integer>();

	private static List<String> destroyAList = new LinkedList<String>();
	private static List<String> destroyBList = new LinkedList<String>();

	// take user's input
	public void getuserInput(BufferedReader reader) throws Exception {
		System.out.println("Enter area boundaries: ");
		String[] ground = reader.readLine().split(" ");
		int groundWidth = Integer.parseInt(ground[0]);
		int groundHieght = getIntPos(ground[1].charAt(0));

		// battleship 1 for A,B
		System.out.println("Type for battleship 1: ");
		char battleshipType1 = reader.readLine().charAt(0);

		System.out.println("Dimension for battleship 1: ");
		String[] battle1 = reader.readLine().split(" ");
		int battleship1Width = Integer.parseInt(battle1[0]);
		int battleship1Hieght = Integer.parseInt(battle1[1]);

		// battleship 1 for A
		System.out.println("Location of battleship 1 for player A: ");
		String locBattleship1AInput = reader.readLine();
		int loc1AHY = getIntPos(locBattleship1AInput.charAt(0));
		int loc1AWX = Integer.parseInt(locBattleship1AInput.charAt(1) + "");

		for (int x = 0; x < battleship1Width; x++) {
			if (loc1AWX + x > groundWidth) {
				break;
			}
			for (int y = 0; y < battleship1Hieght; y++) {

				if (loc1AHY + y > groundHieght) {
					break;
				}
				String key = ((loc1AHY + y) + "" + (loc1AWX + x));

				noOfBattleshipA.getAndAdd(battleshipType1 == 'Q' ? 2 : 1);
				locBattleshipA.put(key, battleshipType1 == 'Q' ? 2 : 1);
			}
		}

		// battleship 1 for B
		System.out.println("Location of battleship 1 for player B: ");
		String locBattleshipBInput = reader.readLine();
		int loc1BHY = getIntPos(locBattleshipBInput.charAt(0));
		int loc1BWX = Integer.parseInt(locBattleshipBInput.charAt(1) + "");

		for (int x = 0; x < battleship1Width; x++) {
			if (loc1BWX + x > groundWidth) {
				break;
			}
			for (int y = 0; y < battleship1Hieght; y++) {

				if (loc1BHY + y > groundHieght) {
					break;
				}
				String key = ((loc1BHY + y) + "" + (loc1BWX + x));

				noOfBattleshipB.getAndAdd(battleshipType1 == 'Q' ? 2 : 1);
				locBattleshipB.put(key, battleshipType1 == 'Q' ? 2 : 1);
			}
		}

		// Type for battleship 2 for A,B
		System.out.println("Type for battleship 2: ");
		char battleshipType2 = reader.readLine().charAt(0);

		System.out.println("Dimension for battleship 2: ");
		String[] battle2 = reader.readLine().split(" ");
		int battleship2Width = Integer.parseInt(battle2[0]);
		int battleship2Hieght = Integer.parseInt(battle2[1]);

		// battleship 2 for A
		System.out.println("Location of battleship 2 for player A: ");
		String locBattleship2AInput = reader.readLine();
		int loc2AHY = getIntPos(locBattleship2AInput.charAt(0));
		int loc2AWX = Integer.parseInt(locBattleship2AInput.charAt(1) + "");

		for (int x = 0; x < battleship2Width; x++) {
			if (loc2AWX + x > groundWidth) {
				break;
			}
			for (int y = 0; y < battleship2Hieght; y++) {

				if (loc2AHY + y > groundHieght) {
					break;
				}
				String key = ((loc2AHY + y) + "" + (loc2AWX + x));

				noOfBattleshipA.getAndAdd(battleshipType2 == 'Q' ? 2 : 1);
				locBattleshipA.put(key, battleshipType2 == 'Q' ? 2 : 1);
			}
		}

		// battleship 2 for B
		System.out.println("Location of battleship 2 for player B: ");
		String locBattleship2BInput = reader.readLine();
		int loc2BHY = getIntPos(locBattleship2BInput.charAt(0));
		int loc2BWX = Integer.parseInt(locBattleship2BInput.charAt(1) + "");

		for (int x = 0; x < battleship2Width; x++) {
			if (loc2BWX + x > groundWidth) {
				break;
			}
			for (int y = 0; y < battleship2Hieght; y++) {

				if (loc2BHY + y > groundHieght) {
					break;
				}
				String key = ((loc2BHY + y) + "" + (loc2BWX + x));

				noOfBattleshipB.getAndAdd(battleshipType2 == 'Q' ? 2 : 1);
				locBattleshipB.put(key, battleshipType2 == 'Q' ? 2 : 1);
			}
		}

		System.out.println(locBattleshipA);
		System.out.println(locBattleshipB);

		System.out.println("Missile targets for player A: ");
		String[] destroyAttack = reader.readLine().split(" ");
		for (int i = 0; i < destroyAttack.length; i++) {

			destroyAList.add(getIntPos(destroyAttack[i].charAt(0)) + "" + destroyAttack[i].charAt(1));
		}

		System.out.println("Missile targets for player B: ");
		String[] destroyBttack = reader.readLine().split(" ");
		for (int i = 0; i < destroyBttack.length; i++) {

			destroyBList.add(getIntPos(destroyBttack[i].charAt(0)) + "" + destroyBttack[i].charAt(1));
		}
	}

	// process game options
	public void startGame() {

		Boolean AhasNoMissiles = false;
		Boolean BhasNoMissiles = false;

		int i = 0, j = 0;
		while (true) {

			if (AhasNoMissiles && BhasNoMissiles) {
				System.out.println("the players declare peace....");
				break;
			}

			if (noOfBattleshipA.get() == 0) {
				System.out.println("Player-2 won the battle");
				break;
			}
			if (noOfBattleshipB.get() == 0) {
				System.out.println("Player-1 won the battle");
				break;
			}

			if (i == destroyAList.size()) {
				AhasNoMissiles = true;
				System.out.println("Player-1 has no more missiles left");
			}

			while (i < destroyAList.size()) {
				String key = destroyAList.get(i);
				char alphaChar = (char) (key.charAt(0) + 16);

				if (locBattleshipB.containsKey(key)) {
					System.out.println(
							"Player-1 fires a missile with target " + (alphaChar + "" + key.charAt(1)) + " which hit");
					noOfBattleshipB.getAndDecrement();
					if (locBattleshipB.get(key) - 1 != 0) {
						locBattleshipB.put(key, locBattleshipB.get(key) - 1);
					} else {
						locBattleshipB.remove(key);
					}
				} else {
					System.out.println("Player-1 fires a missile with target " + (alphaChar + "" + key.charAt(1))
							+ " which missed");
					i++;
					break;
				}
				i++;
			}

			if (j == destroyBList.size()) {
				BhasNoMissiles = true;
				System.out.println("Player-2 has no more missiles left");
			}

			while (j < destroyBList.size()) {
				String key = destroyBList.get(j);
				char alphaChar = (char) (key.charAt(0) + 16);

				if (locBattleshipA.containsKey(key)) {
					System.out.println(
							"Player-2 fires a missile with target " + (alphaChar + "" + key.charAt(1)) + " which hit");
					noOfBattleshipA.getAndDecrement();
					if (locBattleshipA.get(key) - 1 != 0) {
						locBattleshipA.put(key, locBattleshipA.get(key) - 1);
					} else {
						locBattleshipA.remove(key);
					}
				} else {
					System.out.println("Player-2 fires a missile with target " + (alphaChar + "" + key.charAt(1))
							+ " which missed");
					j++;
					break;
				}
				j++;
			}
		}
	}

	// char to int convertion
	public int getIntPos(char ch) {
		return (int) ch - 64;
	}
}
