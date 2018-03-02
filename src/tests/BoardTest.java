package tests;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import code.Board;
import code.Location;

public class BoardTest {
	String file = "Data/25Words.txt";
	@Test
	public void getBoardTest() {
		Board b = new Board(5, file);
		Location[][] board = b.getBoard();
		assertFalse(board[3][2].is_revealed());
	}
}
