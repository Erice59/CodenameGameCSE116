package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.GameStart;
import code.Teams;
import code.ThreeTurnLogic;
import code.gui.MenuCreation;

public class ThreeTurnLogicTest {

	public final Teams GREEN = Teams.Green;
	public final Teams BLUE = Teams.Blue;
	public final Teams RED = Teams.Red;
	public final Teams NONE = Teams.None;
	
	@Before
	public void set() {
		MenuCreation.setThree(true);
	}
	
	@Test
	public void nextHandle() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		ThreeTurnLogic ttl = new ThreeTurnLogic();
		assertEquals(NONE, GameStart.getEliminatedTeam());
		assertEquals(RED, gs.getCurrentTeamMoveT());
		assertEquals(BLUE, ttl.nextTeam(gs));
		assertEquals(BLUE, gs.getCurrentTeamMoveT());
		assertEquals(GREEN, ttl.nextTeam(gs));
		assertEquals(GREEN, gs.getCurrentTeamMoveT());
		assertEquals(RED, ttl.nextTeam(gs));
		assertEquals(RED, gs.getCurrentTeamMoveT());
		assertEquals(BLUE, ttl.nextTeam(gs));
		assertEquals(BLUE, gs.getCurrentTeamMoveT());
	}
	
	@Test
	public void redEliminate() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		ThreeTurnLogic ttl = new ThreeTurnLogic();
		gs.setCurrentTeamMove(GREEN);
		assertEquals(RED, ttl.nextTeam(gs));
		gs.setCurrentTeamMove(GREEN);
		GameStart.setEliminatedTeam(RED);
		assertEquals(BLUE, ttl.nextTeam(gs));
		assertEquals(BLUE, gs.getCurrentTeamMoveT());
		
	}
	
	@Test
	public void greenEliminate() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		ThreeTurnLogic ttl = new ThreeTurnLogic();
		gs.setCurrentTeamMove(BLUE);
		assertEquals(GREEN, ttl.nextTeam(gs));
		gs.setCurrentTeamMove(BLUE);
		GameStart.setEliminatedTeam(GREEN);
		assertEquals(RED, ttl.nextTeam(gs));
		assertEquals(RED, gs.getCurrentTeamMoveT());
	}
	
	@Test
	public void blueEliminate() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		ThreeTurnLogic ttl = new ThreeTurnLogic();
		gs.setCurrentTeamMove(RED);
		assertEquals(BLUE, ttl.nextTeam(gs));
		gs.setCurrentTeamMove(RED);
		GameStart.setEliminatedTeam(BLUE);
		assertEquals(GREEN, ttl.nextTeam(gs));
		assertEquals(GREEN, gs.getCurrentTeamMoveT());
	}
	
	
	
}
