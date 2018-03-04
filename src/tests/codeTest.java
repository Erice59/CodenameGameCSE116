package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Board;
import code.Card;
import code.Clue;
import code.GameStart;
import code.PersonHelper;
import code.Team;
import code.code;

public class codeTest {

	code C = new code();
	
	@Test
	public void test01() {
		Clue clue = new Clue("test00");
		clue.setCardRevealed(true);
		assertTrue(C.legalClue(clue));
	}
	@Test
	public void test02() {
		Clue clue = new Clue("test01");
		clue.setCardRevealed(false);
		C.codeName = "test01";
		assertFalse(C.legalClue(clue));
		
	}
	@Test
	public void test03() {
		Team t1 = new Team();
		Team t2 = new Team();
		assertEquals(C.winningTeam(t1, t2),null);
	}
	@Test
	public void test04() {
		Team t1 = new Team();
		Team t2 = new Team();	
		t1.touchCard(new Card("Assassin"));
		assertEquals(C.winningTeam(t1, t2),t2);
		
	}
	@Test
	public void test05() {
		Team t1 = new Team();
		Team t2 = new Team();	
		t2.touchCard(new Card("Assassin"));
		assertEquals(C.winningTeam(t1, t2),t1);
		
		
	}
	@Test
	public void test06() {
		Card c = new Card("test05");
		assertTrue(c.getType()=="test05");
	}
	@Test
	public void test07() {
		Clue clue = new Clue("test01");
		clue.setCardRevealed(true);
		C.codeName = "test01";
		assertTrue(C.legalClue(clue));
	}
	@Test
	public void test08() {
		Clue clue = new Clue("test00");
		clue.setCardRevealed(false);
		assertTrue(C.legalClue(clue));
	}
	
	@Test
	public void setCountTest(){
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Clue c = new Clue("Red");
		assertEquals(0,c.getCount());
		c.setCount(game.getGameBoard());
		assertEquals(9,c.getCount());
	}
	
	@Test
	public void decrementCountTest(){
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Clue c = new Clue("Red");
		c.setCount(game.getGameBoard());
		c.decrementCount();
		assertEquals(8,c.getCount());
	}
	
	@Test 
	public void addCountTest(){
		GameStart game = new GameStart(5, "Data/GameWords1.txt");
		Clue c = new Clue("Red");
		c.setCount(game.getGameBoard());
		c.addCount();
		assertEquals(10,c.getCount());
	}
	

}
