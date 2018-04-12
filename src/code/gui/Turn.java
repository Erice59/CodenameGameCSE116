package code.gui;

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
