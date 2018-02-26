package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Person;
import code.WinningState;

public class WinningStateTest {
	
	
	@Test
	public void assasinRevealedTest(){
		Person p = new Person("Assasin");
		WinningState test = new WinningState();
		p.setRevealed(true);
		assertEquals(true, test.assasinRevealed(p));
			
	}
	
	@Test
	public void notAssasinRevealedTest(){
		Person p = new Person("Agent");
		WinningState test = new WinningState();
		p.setRevealed(true);
		assertEquals(false, test.assasinRevealed(p));
			
	}
	
	@Test
	public void assasinNotRevealedTest(){
		Person p = new Person("Assasin");
		WinningState test = new WinningState();
		p.setRevealed(false);
		assertEquals(false, test.assasinRevealed(p));
	}
	
	@Test
	public void notAssasinNotRevealedTest(){
		Person p = new Person("Agent");
		WinningState test = new WinningState();
		p.setRevealed(false);
		assertEquals(false, test.assasinRevealed(p));
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
