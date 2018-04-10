package code.gui;
import javax.swing.JOptionPane;

import code.GameStart;

public class SpymasTurn {
	
	private GameStart gs;
	

	
	public SpymasTurn(GameStart gs){
		this.gs = gs;
	}
	
	
	public void run(){
		turnPopup();
		countEnter();
		clueEnter();
	}
	
	
	public void turnPopup(){
		String teamTurn = gs.getCurrentTeamMove();
		JOptionPane.showMessageDialog(null, "It's" + teamTurn + "turn");
		
	}
	
	//still make sure the counts legal
	public void countEnter(){
		boolean inputCorrect = false;
		while(!inputCorrect){
			try{
				int count = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the count!"));
				if(count <= 0){
					throw new NumberFormatException();
				}
				inputCorrect = true;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Try Again. Enter a positive number");
			}
		
		}
		
	}
	
	//still make sure clue is legal
	public void clueEnter(){
		String clue = JOptionPane.showInputDialog(null,"Enter the clue!");
	}

}