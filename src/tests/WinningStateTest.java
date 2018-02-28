package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Location;
import code.Person;
import code.WinningState;

public class WinningStateTest {
	
	
	@Test
	public void assasinRevealedTest(){
		Location l = new Location("Assasin", "codename", "id");
		WinningState test = new WinningState();
		l.set_revealed(true);
		assertEquals(true, test.assasinRevealed(l));
			
	}
	
	@Test
	public void notAssasinRevealedTest(){
		Location l = new Location("Agent", "codename", "id");
		WinningState test = new WinningState();
		l.set_revealed(true);
		assertEquals(false, test.assasinRevealed(l));
			
	}
	
	@Test
	public void assasinNotRevealedTest(){
		Location l = new Location("Assasin", "codename", "id");
		WinningState test = new WinningState();
		l.set_revealed(false);
		assertEquals(false, test.assasinRevealed(l));
	}
	
	@Test
	public void notAssasinNotRevealedTest(){
		Location l = new Location("Agent", "codename", "id");
		WinningState test = new WinningState();
		l.set_revealed(false);
		assertEquals(false, test.assasinRevealed(l));
	}
	
	
	@Test
	public void redAgentRevealed(){
		WinningState test = new WinningState();
		assertEquals(true, test.redAgentRevealed(9));
	}
	
	@Test
	public void redAgentRevealedWrongNumber(){
		WinningState test = new WinningState();
		assertEquals(false, test.redAgentRevealed(8));
	}
	
	
	@Test
	public void blueAgentRevealed(){
		WinningState test = new WinningState();
		assertEquals(true, test.blueAgentRevealed(8));
	}
	
	@Test
	public void blueAgentRevealedWrongNumber(){
		WinningState test = new WinningState();
		assertEquals(false, test.blueAgentRevealed(9));
	}
	
	

}
