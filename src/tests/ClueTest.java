package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Board;
import code.Clue;
import code.GameStart;
import code.Location;

public class ClueTest {

	@Test
	public void clueLegal() {
		GameStart gs = new GameStart(5, "Data/25Words.txt");
		Clue c = new Clue(gs);
		//Board b = new Board(5, "Data/25Words.txt");
		boolean legality = c.legalityCheck("CAKE");
		assertEquals(true, legality);
		
	}
	
	@Test
	public void clueNotLegal() {
		GameStart gs = new GameStart(5, "Data/25Words.txt");
		Clue c = new Clue(gs);
		//Board b = new Board(5, "Data/25Words.txt");
		boolean legality = c.legalityCheck("CAPITAL");
		assertEquals(false, legality);
	}
	
	@Test
	public void clueRevealed() {
		GameStart gs = new GameStart(5, "Data/25Words.txt");
		Clue c = new Clue(gs);
		//Board b = new Board(5, "Data/25Words.txt");
		Location[][] l = gs.getGameBoard().getBoard();
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if(l[row][col].get_codename().equals("CAPITAL")){
					l[row][col].set_revealed(true);
				}
			}
		}
		boolean legality = c.legalityCheck("CAPITAL");
		assertEquals(true, legality);		
	}
	
	@Test
	public void setCount(){
		GameStart gs = new GameStart(5, "Data/25Words.txt");
		Clue c = new Clue(gs);
		c.setCount(7);
		assertEquals(7, c.getCount());
	}
	
}
