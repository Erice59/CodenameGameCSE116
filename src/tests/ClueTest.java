package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import code.Board;
import code.Clue;
import code.Location;

public class ClueTest {

	@Test
	public void clueLegal() {
		Clue c = new Clue();
		Board b = new Board(5, "Data/25Words.txt");
		boolean legality = c.legalityCheck(b, "CAKE");
		assertEquals(true, legality);
		
	}
	
	@Test
	public void clueNotLegal() {
		Clue c = new Clue();
		Board b = new Board(5, "Data/25Words.txt");
		boolean legality = c.legalityCheck(b, "CAPITAL");
		assertEquals(false, legality);
	}
	
	@Test
	public void clueRevealed() {
		Clue c = new Clue();
		Board b = new Board(5, "Data/25Words.txt");
		Location[][] l = b.getBoard();
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				if(l[row][col].get_codename().equals("CAPITAL")){
					l[row][col].set_revealed(true);
				}
			}
		}
		boolean legality = c.legalityCheck(b, "CAPITAL");
		assertEquals(true, legality);		
	}
	
	@Test
	public void setCount(){
		Clue c = new Clue();
		c.setCount(7);
		assertEquals(7, c.getCount());
	}
	
}
