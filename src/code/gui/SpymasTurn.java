package code.gui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import code.Clue;
import code.GameStart;

/**
 * Method complete's spymaster's turn
 * @author Jordan
 *
 */

public class SpymasTurn {
	
	private GameStart gs;
	private Clue c;
	

	/**
	 * constructor that takes in a gamestart as well as a clue
	 * @param gs
	 * @param c
	 */
	public SpymasTurn(GameStart gs, Clue c){
		this.gs = gs;
		this.c = c;
		run();
	}
	
	/**
	 * runs all three methods
	 */
	public void run(){
		turnPopup();
//		countEnter();
//		clueEnter();
		ccEnter();
	}
	
	/**
	 * shows the current team's move
	 */
	public void turnPopup(){
		String teamTurn = gs.getCurrentTeamMove();
		JOptionPane.showMessageDialog(null, "It's" + teamTurn + " turn!");
		
	}
	
	/**
	 * enter a legal count
	 */
	public void countEnter(){
		boolean inputCorrect = false;
		while(!inputCorrect){
			try{
				int count = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the count!"));
				if(count <= 0){
					throw new NumberFormatException();
				}
				else{
				c.setCount(count);
				System.out.print(count);
				inputCorrect = true;
				}
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Try Again. Enter a positive number");
			}
		
		}
		
	}
	
	/**
	 * enter a legal clue
	 */
	public void clueEnter(){
		String clue = JOptionPane.showInputDialog(null,"Enter the clue!");
		if(c.legalityCheck(clue)){
			c.setClue(clue);
			//move on to rest of teams turn
		}
		else{
			//end turn
		}
	}
	
	public void ccEnter(){
		boolean countCorrect = false;
		boolean clueCorrect = false;
		int count = 0;
		String clue = "";
		JFrame frame = new JFrame("Enter the count and clue, Spymaster!");
		while(!countCorrect){
		try{
			count = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter the count!"));
			if(count <= 0){
				throw new NumberFormatException();
			}
			else{
			c.setCount(count);
			System.out.print(count);
			countCorrect = true;
			}
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(frame, "Try Again. Enter a positive number");
		}
		}
		while(!clueCorrect){
			clue = JOptionPane.showInputDialog(frame,"Enter the clue!");
			if(c.legalityCheck(clue.toUpperCase())){
				c.setClue(clue);
				clueCorrect = true;
				//move on to rest of teams turn
			}
			else{
				JOptionPane.showMessageDialog(frame, "Try Again, you can't enter a clue of a codename that's already been revealed!");
				//end turn
			}
		}
		
	}

}