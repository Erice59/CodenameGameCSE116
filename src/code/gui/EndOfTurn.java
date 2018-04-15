package code.gui;

import javax.swing.JOptionPane;

import code.BoardState;
import code.GameStart;
import code.WinningState;
/**
 * Ends the turn of whichever team just went, sends the winning message if the game has been won otherwise
 * goes to the next team to start their turn.
 * @author Alex Chmielewski
 *
 */
public class EndOfTurn {
	
	private GameStart gs;
	private JOptionPane o;
	private BoardState b;
	private boolean win;
	
	public void EndTurn() {
	
		if(b.update(gs)) {
			setWinMessage(new JOptionPane(b.getWinner() + "Wins!"));
		}else {
			if(gs.getCurrentTeamMove() == "Red") {
				gs.setCurrentTeamMove("Blue");
			}else {
				gs.setCurrentTeamMove("Red");
			}
		}
	}

	public JOptionPane getWinMessage() {
		return o;
	}

	public void setWinMessage(JOptionPane o) {
		this.o = o;
	}

	public boolean getWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	
}
