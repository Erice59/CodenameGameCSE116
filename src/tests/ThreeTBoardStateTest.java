package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.Board;
import code.ThreeTBoardState;
import code.gui.MainWindow;
import code.gui.MenuCreation;
import code.GameStart;
import code.Location;
import code.Teams;

public class ThreeTBoardStateTest {
	
	public final Teams GREEN = Teams.Green;
	public final Teams BLUE = Teams.Blue;
	public final Teams RED = Teams.Red;
	public final Teams NONE = Teams.None;
	
	@Before
	public void setThree() {
		MenuCreation.setThree(true);
	}
	
	@Test
	public void boardInWinningState() {
		
	}
	
	@Test
	public void winCaseAssassinRevealedTrue() {
		MenuCreation.setThree(true);
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Assassin")) {
					l.set_revealed(true);
				}
			}

		}
		ThreeTBoardState state = new ThreeTBoardState();
		
		GameStart.setEliminatedTeam(GREEN);
		
		game.setCurrentTeamMove(RED);
		assertEquals(true, state.assassinsRevealed(game));
		assertEquals(BLUE, state.getWinnerT());

		game.setCurrentTeamMove(BLUE);
		assertEquals(true, state.assassinsRevealed(game));
		assertEquals(RED, state.getWinnerT());
		
		GameStart.setEliminatedTeam(BLUE);
		
		game.setCurrentTeamMove(GREEN);
		assertEquals(true, state.assassinsRevealed(game));
		assertEquals(RED, state.getWinnerT());

		game.setCurrentTeamMove(RED);
		assertEquals(true, state.assassinsRevealed(game));
		assertEquals(GREEN, state.getWinnerT());
		
		GameStart.setEliminatedTeam(RED);
		
		game.setCurrentTeamMove(GREEN);
		assertEquals(true, state.assassinsRevealed(game));
		assertEquals(BLUE, state.getWinnerT());

		game.setCurrentTeamMove(BLUE);
		assertEquals(true, state.assassinsRevealed(game));
		assertEquals(GREEN, state.getWinnerT());
	}
	
	@Test
	public void winCaseAssassinRevealedFalse() {
		MenuCreation.setThree(true);
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();
		int i = 0;
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Assassin") && i == 0) {
					l.set_revealed(true);
					i++;
				}
			}

		}
		ThreeTBoardState state = new ThreeTBoardState();
		
		GameStart.setEliminatedTeam(GREEN);
		
		game.setCurrentTeamMove(RED);
		assertEquals(false, state.assassinsRevealed(game));
		assertEquals(NONE, state.getWinnerT());

		game.setCurrentTeamMove(BLUE);
		assertEquals(false, state.assassinsRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		
		GameStart.setEliminatedTeam(BLUE);
		
		game.setCurrentTeamMove(GREEN);
		assertEquals(false, state.assassinsRevealed(game));
		assertEquals(NONE, state.getWinnerT());

		game.setCurrentTeamMove(RED);
		assertEquals(false, state.assassinsRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		
		GameStart.setEliminatedTeam(RED);
		
		game.setCurrentTeamMove(GREEN);
		assertEquals(false, state.assassinsRevealed(game));
		assertEquals(NONE, state.getWinnerT());

		game.setCurrentTeamMove(BLUE);
		assertEquals(false, state.assassinsRevealed(game));
		assertEquals(NONE, state.getWinnerT());
	}
	
	@Test
	public void winCaseRedRevealedTrue() {
		
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Red")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(true, state.redRevealed(game));
		assertEquals(RED, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.redRevealed(game));
		assertEquals(RED, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(true, state.redRevealed(game));
		assertEquals(RED, state.getWinnerT());
	}
	
	@Test
	public void winCaseRedRevealedTrueEliminated() {
		
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Red")) {
					l.set_revealed(true);
				}
			}
		}
		GameStart.setEliminatedTeam(RED);
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
	}

	@Test
	public void winCaseRedRevealedFalseNone() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");

		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());	
	}

	@Test
	public void winCaseRedRevealedFalseFive() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();
		int count = 0;
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Red") ) {
					count++;
					if (count < 6) {
						l.set_revealed(true);
					}
				}
			}

		}
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());		
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());	
	}

	
	
	@Test
	public void winCaseBlueRevealedTrue() {
		
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Blue")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(true, state.blueRevealed(game));
		assertEquals(BLUE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.blueRevealed(game));
		assertEquals(BLUE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(true, state.blueRevealed(game));
		assertEquals(BLUE, state.getWinnerT());
	}
	
	@Test
	public void winCaseBlueRevealedTrueEliminated() {
		
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Blue")) {
					l.set_revealed(true);
				}
			}
		}
		GameStart.setEliminatedTeam(BLUE);
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
	}

	@Test
	public void winCaseBlueRevealedFalseNone() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");

		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());	
	}

	@Test
	public void winCaseBlueRevealedFalseFour() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();
		int count = 0;
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Blue") ) {
					count++;
					if (count < 5) {
						l.set_revealed(true);
					}
				}
			}

		}
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());		
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());	
	}
	
	
	
	
	
	
	
	@Test
	public void winCaseGreenRevealedTrue() {
		
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Green")) {
					l.set_revealed(true);
				}
			}

		}
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(true, state.greenRevealed(game));
		assertEquals(GREEN, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.greenRevealed(game));
		assertEquals(GREEN, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(true, state.greenRevealed(game));
		assertEquals(GREEN, state.getWinnerT());
	}
	
	@Test
	public void winCaseGreenRevealedTrueEliminated() {
		
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();

		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Green")) {
					l.set_revealed(true);
				}
			}
		}
		GameStart.setEliminatedTeam(GREEN);
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
	}

	@Test
	public void winCaseGreenRevealedFalseNone() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");

		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());	
	}

	@Test
	public void winCaseGreenRevealedFalseFour() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		Board b = game.getGameBoard();
		int count = 0;
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Green") ) {
					count++;
					if (count < 5) {
						l.set_revealed(true);
					}
				}
			}

		}
		game.setCurrentTeamMove("Red");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());		
		game.setCurrentTeamMove("Green");
		assertEquals(false, state.redRevealed(game));
		assertEquals(NONE, state.getWinnerT());	
	}
	

	@Test
	public void testGetAndSet() {
		ThreeTBoardState b = new ThreeTBoardState();
		assertEquals(false, b.isWinState());
		b.setWinState(true);
		assertEquals(true, b.isWinState());
		assertEquals("None", b.getWinType());
		b.setWinType("Assassin Revealed");
		assertEquals("Assassin Revealed", b.getWinType());
	}

	@Test
	public void testUpdateFalse() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		ThreeTBoardState state = new ThreeTBoardState();
		assertEquals(false, state.isWinState());
		assertEquals(NONE, state.getWinnerT());
		assertEquals("None", state.getWinType());
		assertEquals(false, state.update(game));
	}

	@Test
	public void testUpdateAssassin() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		ThreeTBoardState state = new ThreeTBoardState();
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Assassin")) {
					l.set_revealed(true);
				}
			}

		}
		GameStart.setEliminatedTeam(GREEN);
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(RED, state.getWinnerT());
		assertEquals("Assassins Revealed", state.getWinType());
		
		GameStart.setEliminatedTeam(BLUE);
		game.setCurrentTeamMove("Red");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(GREEN, state.getWinnerT());
		assertEquals("Assassins Revealed", state.getWinType());
		
		GameStart.setEliminatedTeam(RED);
		game.setCurrentTeamMove("Green");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(BLUE, state.getWinnerT());
		assertEquals("Assassins Revealed", state.getWinType());
	}

	@Test
	public void testUpdateRed() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		ThreeTBoardState state = new ThreeTBoardState();
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
		assertEquals(RED, state.getWinnerT());
		assertEquals("Red Revealed", state.getWinType());		
		game.setCurrentTeamMove("Green");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(RED, state.getWinnerT());
		assertEquals("Red Revealed", state.getWinType());
		GameStart.setEliminatedTeam(RED);
		game.setCurrentTeamMove("Blue");
		assertEquals(false, state.update(game));
		assertEquals(false, state.isWinState());
		assertEquals(NONE, state.getWinnerT());
		assertEquals("None", state.getWinType());	
		
	}

	@Test
	public void testUpdateBlue() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		ThreeTBoardState state = new ThreeTBoardState();
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
		assertEquals(BLUE, state.getWinnerT());
		assertEquals("Blue Revealed", state.getWinType());		
		game.setCurrentTeamMove("Green");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(BLUE, state.getWinnerT());
		assertEquals("Blue Revealed", state.getWinType());
		GameStart.setEliminatedTeam(BLUE);
		game.setCurrentTeamMove("Red");
		assertEquals(false, state.update(game));
		assertEquals(false, state.isWinState());
		assertEquals(NONE, state.getWinnerT());
		assertEquals("None", state.getWinType());	
	}
	
	@Test
	public void testUpdateGreen() {
		GameStart game = new GameStart(5, "Data/GameWords.txt");
		ThreeTBoardState state = new ThreeTBoardState();
		Board b = game.getGameBoard();
		for (Location[] la : b.getBoard()) {
			for (Location l : la) {
				if(l.get_person().equals("Green")) {
					l.set_revealed(true);
				}
			}	
		}
		game.setCurrentTeamMove("Blue");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(GREEN, state.getWinnerT());
		assertEquals("Green Revealed", state.getWinType());		
		game.setCurrentTeamMove("Red");
		assertEquals(true, state.update(game));
		assertEquals(true, state.isWinState());
		assertEquals(GREEN, state.getWinnerT());
		assertEquals("Green Revealed", state.getWinType());
		GameStart.setEliminatedTeam(GREEN);
		game.setCurrentTeamMove("Red");
		assertEquals(false, state.update(game));
		assertEquals(false, state.isWinState());
		assertEquals(NONE, state.getWinnerT());
		assertEquals("None", state.getWinType());	
	}
}
