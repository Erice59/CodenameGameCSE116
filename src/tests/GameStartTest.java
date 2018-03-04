package tests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import code.Board;
import code.Clue;
import code.GameStart;
import code.Location;

public class GameStartTest {

	@Test
	public void testDefaultConstructorTeamMove() {
		GameStart test = new GameStart();
		assertEquals("Red", test.getCurrentTeamMove());
	}
	
	@Test
	public void testFullConstructor() {
		GameStart test = new GameStart(5, "Data/25Words.txt");
		Board testBoard = new Board(5, "Data/25Words.txt");
		Location[][] fromBoard = testBoard.getBoard();
		Location[][] fromGame = test.getGameBoard().getBoard();
		List<String> boardCodenames = new ArrayList<String>();
		List<String> gameCodenames = new ArrayList<String>();
		List<String> boardPersons = new ArrayList<String>();
		List<String> gamePersons = new ArrayList<String>();
		for (int row = 0; row < fromBoard.length; row++) {
			for (int col = 0; col < fromBoard[row].length; col++) {
				boardCodenames.add(fromBoard[row][col].get_codename());
				boardPersons.add(fromBoard[row][col].get_person());
			}
		}
		for (int row = 0; row < fromGame.length; row++) {
			for (int col = 0; col < fromGame[row].length; col++) {
				gameCodenames.add(fromGame[row][col].get_codename());
				gamePersons.add(fromGame[row][col].get_person());
			}
		}
		Collections.sort(boardCodenames);
		Collections.sort(boardPersons);
		Collections.sort(gameCodenames);
		Collections.sort(gamePersons);
		assertEquals(boardCodenames, gameCodenames);
		assertEquals(boardPersons, boardPersons);
		assertEquals("Red", test.getCurrentTeamMove());
	}
	
	@Test
	public void isSelectedRedTest(){
		Location l = new Location("Red","Red","Red");
		GameStart test = new GameStart();
		test.setCurrentTeamMove("Red");
		assertEquals("You revealed a red agent", test.isSelected(l));
	}
	
	@Test
	public void isSelectedBlueTest(){
		Location l = new Location("Blue","Blue","Blue");
		GameStart test = new GameStart();
		test.setCurrentTeamMove("Blue");
		assertEquals("You revealed a blue agent", test.isSelected(l));
	}
	
	@Test
	public void isSelectedFalseTest(){
		Location l = new Location("Blue","Blue","Blue");
		GameStart test = new GameStart();
		test.setCurrentTeamMove("Red");
		assertEquals(null, test.isSelected(l));
	}
}
