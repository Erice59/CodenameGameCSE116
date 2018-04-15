package code.gui;

import code.GameStart;

/**
 * The entire turn is called here through method calls of other classes
 * @author Alex Chmielewski
 *
 */
public class Turn extends GuiConnector{
	private SpymasTurn spy;
	private TeamTurn team;
	private GuiConnector gc;
	
	public void wholeTurn() {
		GameStart g = gc.get_game();
		spy = new SpymasTurn(g);
		spy.run();
		spy.clueEnter();
		spy.countEnter();
		spy.turnPopup();
	}
}
