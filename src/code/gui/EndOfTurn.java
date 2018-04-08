package code.gui;

import javax.swing.JOptionPane;

import code.BoardState;
import code.GameStart;
import code.WinningState;

public class EndOfTurn {
	
	private GuiConnector gc; //not how we do this just a placeholder
	private JOptionPane o;
	
	public void EndTurn(BoardState b) {
		GameStart gameStart = gc.get_game();
		if(b.update(gameStart)) {
			setWinMessage(new JOptionPane(b.getWinner() + "Wins!"));
		}else {
			//go to next teams turn
		}
	}

	public JOptionPane getWinMessage() {
		return o;
	}

	public void setWinMessage(JOptionPane o) {
		this.o = o;
	}
	
	
}
