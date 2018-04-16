package code.gui;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

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
		SpinnerModel spin = new SpinnerNumberModel(0, 0, 100, 1);
		JSpinner count = new JSpinner(spin);
		count.setBounds(100, 100, 50, 30);

		JPanel cluePanel = new JPanel();
		cluePanel.add(new JLabel("Clue:"));
		cluePanel.add(clueInput);
		cluePanel.add(Box.createHorizontalStrut(15));
		cluePanel.add(new JLabel("Count: "));
		cluePanel.add(count);

		JOptionPane.showMessageDialog(null, "Spymaster please enter the clue and count!");

		while(validClue == false || validCount == false) {
			int result = JOptionPane.showConfirmDialog(null, cluePanel, "Spymaster please enter the clue and count!", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				System.out.println("Clue: " + clueInput.getText());
				System.out.println("Count: " + count.getValue());
			}
			if ((int) count.getValue() <= 0 && !c.legalityCheck(clueInput.getText().toUpperCase())) {
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");
				JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
			}
			else if ((int) count.getValue() <= 0) {
				JOptionPane.showMessageDialog(null, "Please Try Again. Enter a positive count.");

			}
			else if (!c.legalityCheck(clueInput.getText().toUpperCase())) {
				JOptionPane.showMessageDialog(null, "Please Try Again. You may not enter the Codename of an unrevealed location!");
			}
			if (c.legalityCheck(clueInput.getText().toUpperCase())) {
				c.setClue(clueInput.getText());
				validClue = true;
			}
			if ((int) count.getValue() > 0) {
				c.setCount((int) count.getValue());
				validCount = true;
			}
		}
	}

}