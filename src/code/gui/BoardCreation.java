package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import code.*;
/**
 * Creates the board with codenames and codewords
 * @author Alex Chmielewski
 * @author Eric Weinman
 *
 */
public class BoardCreation {
	
	private static Board _board;
	/**
	 * static location array
	 */
	private static Location[][] _location;
	
	private static LButton[][] _teamButtons;
	
	private static JPanel _teamPanel;
	private static LButton[][] _spyButtons;
	private static JPanel _spyPanel;
	/**
	 * initializes board
	 * @param b
	 */
	public static void boardInit(Board b) {
		_board = b;
		Location[][] l = b.getBoard();
		_location = l;
	}
	/**
	 * creates the board during the team turn
	 * @return
	 */
	public static JPanel teamTurnBoardCreator() {
		JPanel teamTurnBoard = new JPanel();
		GridLayout style = new GridLayout(5, 5);
		int maxGap = 20;
		teamTurnBoard.setLayout(style);
		LButton dummy = new LButton("Button for formatting");
		Dimension buttonSize = dummy.getPreferredSize();
		teamTurnBoard.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap, (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));

		LButton[][] buttons = new LButton[5][5];

		for (int row = 0; row < _location.length; row++) {
			for (int col = 0; col < _location[row].length; col++) {
				LButton b = buttons[row][col];
				b = new LButton(_location[row][col].get_codename(), _location[row][col]);
				b.setName(_location[row][col].toString());
				b.setFont(new Font("Dialog", Font.BOLD, 25));
				b.setBorder(new LineBorder(Color.gray));
				b.addActionListener(new bListener());
				teamTurnBoard.add(b);
			}
		}
		_teamButtons = buttons;
		_teamPanel = teamTurnBoard;
		return teamTurnBoard;
	}
	/**
	 * creates board for the spymasters
	 * @return
	 */
	public static JPanel spyMasterTurnBoardCreator() {
		JPanel spyMasterBoard = new JPanel();
		GridLayout style = new GridLayout(5, 5);
		int maxGap = 20;
		spyMasterBoard.setLayout(style);
		LButton dummy = new LButton("Button for formatting");
		Dimension buttonSize = dummy.getPreferredSize();
		spyMasterBoard.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap, (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));

		LButton[][] buttons = new LButton[5][5];

		for (int row = 0; row < _location.length; row++) {
			for (int col = 0; col < _location[row].length; col++) {
				LButton b = buttons[row][col];

				b = new LButton(_location[row][col].get_codename(), _location[row][col]);
				b.setName(_location[row][col].toString());
				b.setFont(new Font("Dialog", Font.BOLD, 25));
				b.setBorder(new LineBorder(Color.gray));
				System.out.println(_location[row][col].is_revealed());
				System.out.println(_location[row][col].get_codename());

				if (!_location[row][col].is_revealed()) {
					BoardUpdate.notRevealedSpyButton(b);
				}
				else if (_location[row][col].is_revealed()) {
					System.out.println("rev");
					BoardUpdate.revealedButton(b);
				}
				b.revalidate();
				spyMasterBoard.add(b);
				spyMasterBoard.revalidate();
				MainWindow.get_window().revalidate();
			}
		}
		return spyMasterBoard;
	}
	/**
	 * action listener for every button in the array
	 * @author Eric Weinman
	 *
	 */
	private static class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LButton jb = (LButton) e.getSource();
			Location  jbl = jb.get_location();
			if (!jbl.is_revealed() && jbl.get_codename().equals(jb.getText())) {
				jbl.set_revealed(true);
				System.out.println("Old Count: " + MainWindow.get_clue().getCount());
				BoardUpdate.revealedButton(jb);
			if (jbl.get_person().equals("Red")) {
				MainWindow.set_redAgentRevealed(MainWindow.get_redAgentRevealed() + 1);
			}
			else if (jbl.get_person().equals("Blue")) {
				MainWindow.set_blueAgentRevealed(MainWindow.get_blueAgentRevealed() + 1);
			}
				MainWindow.checkCount();
				System.out.println("New Count: " + MainWindow.get_clue().getCount());
				BoardUpdate.checkPerson(jbl);
				BoardUpdate.checkAgentReveal();
				//BoardUpdate.revealedButton(jb);
			}
		}
	}
}
