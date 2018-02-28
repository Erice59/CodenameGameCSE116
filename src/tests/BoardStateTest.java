package tests;

import code.Board;
import code.Location;
import code.GameStart;
import code.BoardState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.*;

import org.junit.Test;

public class BoardStateTest {

	@Test
	public void winCaseAssassinRevealedTrue() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Assassin")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Red");

		BoardState state = new BoardState();
		assertEquals(true, state.assassinRevealed(game));
		assertEquals("Blue", state.getWinner());

		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.assassinRevealed(game));
		assertEquals("Red", state.getWinner());
	}

	@Test
	public void winCaseAssassinRevealedFalse() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		game.setCurrentTeamMove("Red");

		BoardState state = new BoardState();
		assertEquals(false, state.assassinRevealed(game));
		assertEquals("None", state.getWinner());		
	}

	@Test
	public void winCaseRedRevealedTrue() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Red")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Red");
		BoardState state = new BoardState();
		assertEquals(true, state.redRevealed(game));
		assertEquals("Red", state.getWinner());
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.redRevealed(game));
		assertEquals("Red", state.getWinner());
	}

	@Test
	public void winCaseRedRevealedFalseNone() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");

		game.setCurrentTeamMove("Red");
		BoardState state = new BoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals("None", state.getWinner());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals("None", state.getWinner());				
	}

	@Test
	public void winCaseRedRevealedFalseEight() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Board b = game.getGameBoard();
		int count = 0;
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Red") ) {
					count++;
					if (count < 9) {
						l.set_revealed(true);
					}
				}
			}

		}
		game.setCurrentTeamMove("Red");
		BoardState state = new BoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals("None", state.getWinner());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals("None", state.getWinner());		
	}

	@Test
	public void winCaseBlueRevealedTrue() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Blue")) {
					l.set_revealed(true);
				}
			}	
		}
		game.setCurrentTeamMove("Red");
		BoardState state = new BoardState();
		assertEquals(true, state.blueRevealed(game));
		assertEquals("Blue", state.getWinner());
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.blueRevealed(game));
		assertEquals("Blue", state.getWinner());		
	}

	@Test
	public void winCaseBlueRevealedFalse() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");

		game.setCurrentTeamMove("Red");
		BoardState state = new BoardState();
		assertEquals(false, state.blueRevealed(game));
		assertEquals("None", state.getWinner());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.blueRevealed(game));
		assertEquals("None", state.getWinner());				
	}

	@Test
	public void winCaseBlueRevealedFalseEight() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Board b = game.getGameBoard();
		int count = 0;
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Blue") ) {
					count++;
					if (count < 8) {
						l.set_revealed(true);
					}
				}
			}

		}
		game.setCurrentTeamMove("Red");
		BoardState state = new BoardState();
		assertEquals(false, state.blueRevealed(game));
		assertEquals("None", state.getWinner());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.blueRevealed(game));
		assertEquals("None", state.getWinner());		
	}

	@Test
	public void testGetAndSet() {
		BoardState b = new BoardState();
		assertEquals(false, b.isWinState());
		b.setWinState(true);
		assertEquals(true, b.isWinState());
		assertEquals("None", b.getWinType());
		b.setWinType("Assassin Revealed");
		assertEquals("Assassin Revealed", b.getWinType());
	}

	@Test
	public void testUpdateFalse() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		BoardState state = new BoardState();
		assertEquals(false, state.isWinState());
		assertEquals("None", state.getWinner());
		assertEquals("None", state.getWinType());
		assertEquals(false, state.update(game));
	}

	@Test
	public void testUpdateAssassin() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		BoardState state = new BoardState();
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Assassin")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals("Red", state.getWinner());
		assertEquals("Assassin Revealed", state.getWinType());
	}

	@Test
	public void testUpdateRed() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		BoardState state = new BoardState();
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Red")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals("Red", state.getWinner());
		assertEquals("Red Revealed", state.getWinType());		
	}

	@Test
	public void testUpdateBlue() {
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		BoardState state = new BoardState();
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Blue")) {
					l.set_revealed(true);
				}
			}	
		}
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals("Blue", state.getWinner());
		assertEquals("Blue Revealed", state.getWinType());				
	}
}
