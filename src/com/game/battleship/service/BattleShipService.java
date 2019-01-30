/**
 * 
 */
package com.game.battleship.service;

import java.io.BufferedReader;

/**
 * @author gopaljaiswal
 *
 *         Software Development Engineer
 *         Jan 30, 2019
 */
public interface BattleShipService {

	public void getuserInput(BufferedReader reader) throws Exception;

	public void startGame();

	public int getIntPos(char ch);
}
