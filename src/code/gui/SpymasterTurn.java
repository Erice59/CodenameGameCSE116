package code.gui;
import javax.swing.JOptionPane;

import code.GameStart;

public class SpymasterTurn {
	
	private static GameStart gs;
	
	public SpymasterTurn(GameStart gs){
		this.gs = gs;
	}
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "It's" + gs.getCurrentTeamMove() + "ok");
		countEnter();
		clueEnter();
	}
	
	
	
	//still make sure the counts legal
	public static void countEnter(){
		int count = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the count!"));
		
		
	}
	
	//still make sure clue is legal
	public static void clueEnter(){
		String clue = JOptionPane.showInputDialog(null,"Enter the clue!");
	}

}
