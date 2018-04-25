package code.gui;
import java.awt.Dimension;

import javax.swing.Box;
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
				break;
			}
			validIn = legalCheck(count.getValue(), clueInput.getText());
			System.out.println(validIn);
		}
		/*while(validClue == false || validCount == false) {
			//legalCheck(count, clueInput.getText());
			boolean pass = true;
			int result = JOptionPane.showConfirmDialog(null, cluePanel, "Spymaster please enter the clue and count!", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.out.println("Clue: " + clueInput.getText());
				System.out.println("Count: " + count.getValue());
			}
			if (result == JOptionPane.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(null, "You have canceled entering a clue and count, please start a new game to enter a clue and count.");
				break;
			}
			if ((int) count.getValue() <= 0 && !c.legalityCheck(clueInput.getText().toUpperCase())) {
				pass = false;
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
				JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
			}
			else if (Math.floor((double) count.getValue()) == (int) count.getValue() /*&& Double.isFinite((int) count.getValue())) {
				pass = false;
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter a whole number count.");
			}
			else if ((int) count.getValue() <= 0) {
				pass = false;
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
			}
			else if (!c.legalityCheck(clueInput.getText().toUpperCase())) {
				pass = false;
				JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
			}
			else if ((int) count.getValue() >= 31) {
				pass = false;
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter an actual count of less than 30.");
			}
			if (c.legalityCheck(clueInput.getText().toUpperCase())) {
				c.setClue(clueInput.getText());
				if (pass == true) {
					validClue = true;
				}
			}
			if ((int) count.getValue() > 0) {
				c.setCount((int) count.getValue());
				if (pass == true) {
					validCount = true;
				}
			}
		}*/
	}
	public boolean legalCheck(Object countC, String clueC) {
		boolean countIsLegal = false;
		boolean clueIsLegal = false;
		int curCount = (int) countC;
		/*try {
			if (Math.floor((double) countC) != curCount && Double.isFinite((int) count.getValue())) {
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter a whole number count.");
			}
			else {
				countIsLegal = true;
			}
		}
		catch (ClassCastException e) {
			countIsLegal = false;
		}*/
		if (curCount <= 0 && !c.legalityCheck(clueC.toUpperCase())) {
			JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
			JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
		}
		else if (curCount <= 0) {
			JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
		}
		else if (curCount >= 31) {
			JOptionPane.showMessageDialog(null, "Please Try Again. Enter an actual count of less than 30.");
		}
		else if (countC instanceof Double) {
			JOptionPane.showMessageDialog(null, "Please Try Again. Enter a whole number not decimal count.");
		}
		else if (curCount > 0) {
			c.setCount(curCount);
				countIsLegal = true;
		}
		if (!c.legalityCheck(clueC.toUpperCase())) {
			JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
		}
		else if (c.legalityCheck(clueC.toUpperCase())) {
			c.setClue(clueC);
				clueIsLegal = true;
		}


		/*try {
			if (Math.floor((double) countC) == ((int) countC)) {
				return true;
			}
		}
		catch (ClassCastException e) {
			return false;
		}*/
		if ( countIsLegal && clueIsLegal) {
			return true;
		}
		else {
			return false;
		}
	}
}