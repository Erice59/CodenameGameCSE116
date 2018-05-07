package code.gui;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;

import code.Clue;
import code.GameStart;

/**
 * Method complete's spymaster's turn
 * @author Jordan Clemons
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
		spyMasterInput();
		MainWindow.set_clue(c);
	}

	/**
	 * shows the current team's move
	 */
	public void turnPopup(){
		String teamTurn = gs.getCurrentTeamMove();
		JOptionPane.showMessageDialog(null, "It's " + teamTurn + " turn!");

	}
	/**
	 * Input for the clue and the count, also checks legality through the clue class methods
	 */
	public void spyMasterInput() {
		boolean validCount = false;
		boolean validClue = false;
		JTextField clueInput = new JTextField(15);
		SpinnerModel spin = new SpinnerNumberModel(0, 0, 30, 1);
		JSpinner count = new JSpinner(spin);
		count.setEditor(new DefaultEditor(count));
		count.setBounds(100, 100, 50, 30);
		Dimension d = new Dimension(count.getWidth(), count.getHeight());
		System.out.println(count.getWidth());
		count.setPreferredSize(d);
		count.setMinimumSize(d);

		JPanel cluePanel = new JPanel();
		cluePanel.add(new JLabel("Clue:"));
		cluePanel.add(clueInput);
		cluePanel.add(Box.createHorizontalStrut(20));
		cluePanel.add(new JLabel("Count: "));
		cluePanel.add(count);

		JOptionPane.showMessageDialog(null, "Spymaster please enter the clue and count!");

		boolean validIn = false;
		while (!validIn) {
			int result = JOptionPane.showConfirmDialog(null, cluePanel, "Spymaster please enter the clue and count!", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.out.println("Clue: " + clueInput.getText());
				System.out.println("Count: " + count.getValue());
			}
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "You have canceled entering a clue and count, please start a new game to enter a clue and count.");
				//break;
			}
			validIn = legalCheck(count.getValue(), clueInput.getText());
			System.out.println(validIn);
		}
	}
	public boolean legalCheck(Object countC, String clueC) {
		
		
		
		boolean countIsLegal = false;
		boolean clueIsLegal = false;
		int curCount = (int) countC;
		
		Object[] options = {"Try Again", "End Turn"};
		if (curCount <= 0 && !c.legalityCheck(clueC.toUpperCase())) {
			int result = JOptionPane.showOptionDialog(null, "Please Try Again or end turn. Enter a positive count. You may not enter the Codename of an unrevealed location!", "Oops", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if(result == JOptionPane.YES_OPTION){
				return false;
			}
			else{
				return true;
			}
//			JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
//			JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
		}
		else if (curCount <= 0) {
			int result = JOptionPane.showOptionDialog(null, "Please Try Again or end turn. Enter a positive count." , "Oops", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if(result == JOptionPane.YES_OPTION){
				return false;
			}
			else{
				return true;
			}
//			JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
		}
		else if (curCount >= 31) {
			int result = JOptionPane.showOptionDialog(null, "Please Try Again or end turn. Enter an actual count of less than 30.", "Oops", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if(result == JOptionPane.YES_OPTION){
				return false;
			}
			else{
				return true;
			}
//			JOptionPane.showMessageDialog(null, "Please Try Again. Enter an actual count of less than 30.");
		}
		else if (countC instanceof Double) {
			int result = JOptionPane.showOptionDialog(null, "Please Try Again or end turn. Enter a whole number not decimal count.", "Oops", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if(result == JOptionPane.YES_OPTION){
				return false;
			}
			else{
				return true;
			}
//			JOptionPane.showMessageDialog(null, "Please Try Again. Enter a whole number not decimal count.");
		}
		else if (curCount > 0) {
			c.setCount(curCount);
				countIsLegal = true;
		}
		if (!c.legalityCheck(clueC.toUpperCase())) {
			int result = JOptionPane.showOptionDialog(null, "Please Try Again or end turn. You may not enter the Codename of an unrevealed location!", "Oops", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if(result == JOptionPane.YES_OPTION){
				return false;
			}
			else{
				return true;
			}
//			JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
		}
		else if (c.legalityCheck(clueC.toUpperCase())) {
			c.setClue(clueC);
				clueIsLegal = true;
		}
		if ( countIsLegal && clueIsLegal) {
			return true;
		}
		else {
			return false;
		}
	}
}