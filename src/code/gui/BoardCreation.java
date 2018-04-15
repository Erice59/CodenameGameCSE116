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

public class BoardCreation {

	private static Board _board;
	private static Location[][] _location;

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
				b.setFont(new Font("Dialog", Font.PLAIN, 20));
				b.setBorder(new LineBorder(Color.gray));
				b.addActionListener(new bListener());

				teamTurnBoard.add(b);
			}
		}

		return teamTurnBoard;
	}

	public static JPanel spyMasterTurnBoardCreator() {
		JPanel spyMasterBoard = new JPanel();
		return spyMasterBoard;
	}

	public static void boardInit(Board b) {
		_board = b;
		Location[][] l = b.getBoard();
		_location = l;


	}

	private static class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LButton jb = (LButton) e.getSource();
			Location  jbl = jb.get_location();

			if (!jbl.is_revealed() && jbl.get_codename().equals(jb.getText())) {
				System.out.println("weee");
				jbl.set_revealed(true);
				if (jbl.get_person().equals("Red")) {
					jb.setBackground(Color.red);
					jb.setForeground(Color.white);
				}
				else if (jbl.get_person().equals("Blue")) {
					jb.setBackground(Color.blue);
					jb.setForeground(Color.WHITE);
				}
				else if (jbl.get_person().equals("Bystander")) {
					jb.setBackground(Color.DARK_GRAY);
				}
				else if (jbl.get_person().equals("Assassin")) {
					jb.setBackground(Color.MAGENTA);
				}

				if (jbl.get_codename().equals(jb.getText())) {
					jb.setEnabled(false);
					JPanel p = new JPanel();
					JLabel la = new JLabel(jb.getText());
					la.setVerticalAlignment(SwingConstants.CENTER);
					la.setBackground(jb.getBackground());
					p.setLayout(new GridBagLayout());
					p.add(la);
					la.setForeground(Color.yellow);
					jb.add(p);
					la.setFont(new Font("Dialog", Font.PLAIN, 20));
					p.setBackground(jb.getBackground());
					p.setVisible(true);
					jb.revalidate();

				}

			}

		}
	}

	private static class LButton extends JButton {

		public LButton() {
			super();
		}

		public LButton(Location l) {
			super();
			set_location(l);
		}

		public LButton(String s, Location l) {
			super(s);
			set_location(l);
		}

		public LButton(String s) {
			super(s);
		}

		private static final long serialVersionUID = 1L;
		private Location _location;
		private String ID;
		/**
		 * @return the _location
		 */
		public Location get_location() {
			return _location;
		}
		/**
		 * @param _location the _location to set
		 */
		public void set_location(Location _location) {
			this._location = _location;
		}
		/**
		 * @return the iD
		 */
		public String getID() {
			return ID;
		}
		/**
		 * @param iD the iD to set
		 */
		public void setID(String iD) {
			ID = iD;
		}		
	}
}
