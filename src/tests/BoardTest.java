package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
	
	@Test
	public void checkBoard25Instances() {
		Board test = new Board();
		Location[][] board = test.getBoard();
		assertEquals(5, board.length);
		assertEquals(5, board[0].length);
		assertEquals(board.length, board[0].length);
		assertEquals(25, board.length*board[0].length);
	}

	@Test
	public void boardTest() {
		Board test = new Board(5, "Data/GameWords1.txt");
		//test.out();
		Location[][] board = test.getBoard();
		int redExpected = 9;
		int blueExpected = 8;
		int bystanderExpected = 7;
		int assassinExpected = 1;
		int redActual = 0;
		int blueActual = 0;
		int bystanderActual = 0;
		int assassinActual = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col].get_person().equals("Red")) {
					redActual++;
				}
				else if (board[row][col].get_person().equals("Blue")) {
					blueActual++;
				}
				else if (board[row][col].get_person().equals("Bystander")) {
					bystanderActual++;
				}
				else if (board[row][col].get_person().equals("Assassin")) {
					assassinActual++;
				}
			}
		}
		assertEquals(redExpected, redActual);
		assertEquals(blueExpected, blueActual);
		assertEquals(bystanderExpected, bystanderActual);
		assertEquals(assassinExpected, assassinActual);
	}

	@Test
	public void boardTest25List() {
		Board test = new Board(5, "Data/25Words.txt");
		List<String> twentyFiveWords = new ArrayList<String>(Arrays.asList("AZTEK", "BILL", "CAPITAL", "DAY", "EYE", "FORK", "GAME", "HOTEL", "ICE", "JET", "KEY", "LAB", "MAIL", "NUT", "OIL", "PALM", "QUEEN", "RABBIT", "SWITCH", "TIE", "UNIVERSITY", "VACUUM", "WASHINGTON", "XYLOPHONE", "YARD"));
		Location[][] board = test.getBoard();
		List<String> fromBoard = new ArrayList<String>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				fromBoard.add(board[row][col].get_codename());
			}
		}
		Collections.sort(twentyFiveWords);
		Collections.sort(fromBoard);
		assertEquals(twentyFiveWords, fromBoard);
	}

	@Test
	public void boardAllFalse() {
		Board test = new Board(5, "Data/GameWords1.txt");
		Location[][] board = test.getBoard();
		boolean state = false;
		int revealed = 0;
		board[2][2].set_revealed(true);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (!board[row][col].is_revealed()) {
					revealed += 0;
					//state = true;
				}
				else {
					revealed++;
					state = false;
				}
			}

		}
		assertEquals(false, state);
		assertEquals(1, revealed);
	}
	
	@Test
	public void boardOut() {
		Board test = new Board(5, "Data/GameWords1.txt");
		test.out();
		assertEquals(5, test.getBoard().length);
		assertEquals(5, test.getBoard()[0].length);
	}
	
	@Test
	public void boardSet() {
		Board test = new Board(5, "Data/GameWords1.txt");
		Board test2 = new Board(5, "Data/GameWords1.txt");
		test2.getBoard()[0][0].set_revealed(true);
		assertEquals(true, test2.getBoard()[0][0].is_revealed());
		assertEquals(false, test.getBoard()[0][0].is_revealed());
		test.setBoard(test2.getBoard());
		assertEquals(true, test.getBoard()[0][0].is_revealed());
	}
}
