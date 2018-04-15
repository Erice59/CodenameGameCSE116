package code.gui;

import code.Clue;
import code.GameStart;

/**
 * The entire turn is called here through method calls of other classes
 * @author Alex Chmielewski
 *
 */
public class Turn extends GuiConnector{
	private TeamTurn team;
	private GuiConnector gc;
	private GameStart g;
	private Clue c;
	
	public void wholeTurn(SpymasTurn spy) {
		spy = new SpymasTurn(g, c);
		spy.run();
//		spy.clueEnter();
//		spy.countEnter();
//		spy.turnPopup();
	}
}
