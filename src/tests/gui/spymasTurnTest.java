package tests.gui;

import org.junit.Test;

import code.Clue;
import code.GameStart;
import code.gui.SpymasTurn;

public class spymasTurnTest {

	@Test
	public void runTest(){
		GameStart test = new GameStart(5, "Data/25Words.txt");
		Clue h = new Clue(test);
		SpymasTurn t = new SpymasTurn(test,h);
	}
	
}
