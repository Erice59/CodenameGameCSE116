package code.gui;
/**
 * The entire turn is called here through method calls of other classes
 * @author Alex Chmielewski
 *
 */
public class Turn {
	private SpymasTurn spy;
	private TeamTurn team;
	
	public void wholeTurn() {
		spy.run();
		spy.clueEnter();
		spy.countEnter();
		spy.turnPopup();
	}
}
