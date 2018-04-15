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
	
	private GuiConnector gc; //not how we do this just a placeholder
	private JOptionPane o;
	
	public void EndTurn(BoardState b) {
		GameStart gameStart = gc.get_game();
		if(b.update(gameStart)) {
			setWinMessage(new JOptionPane(b.getWinner() + "Wins!"));
		}else {
			if(gameStart.getCurrentTeamMove() == "Red") {
				gameStart.setCurrentTeamMove("Blue");
			}else {
				gameStart.setCurrentTeamMove("Red");
			}
		}
	}

	public JOptionPane getWinMessage() {
		return o;
	}

	public void setWinMessage(JOptionPane o) {
		this.o = o;
	}
	
	
}
