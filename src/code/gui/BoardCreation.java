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
	private static LButton[][] _teamButtons;
	private static JPanel _teamPanel;
	private static LButton[][] _spyButtons;
	private static JPanel _spyPanel;
	private static boolean _boardSet;

	public static JPanel teamTurnBoardCreator() {
		//if (_boardSet = true) {
		//	return _teamPanel;
		//}
		//else {
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
				b.setFont(new Font("Dialog", Font.PLAIN, 30));
				b.setBorder(new LineBorder(Color.gray));
				b.addActionListener(new bListener());

				teamTurnBoard.add(b);
			}
		}

		_teamButtons = buttons;
		_teamPanel = teamTurnBoard;
		_boardSet = true;
		return teamTurnBoard;
	}
	//}
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
				b.setFont(new Font("Dialog", Font.PLAIN, 30));
				b.setBorder(new LineBorder(Color.gray));
				
				System.out.println(_location[row][col].is_revealed());
				System.out.println(_location[row][col].get_codename());
				
				if (!_location[row][col].is_revealed()) {
					notRevealedSpyButton(b);
				}
				else if (_location[row][col].is_revealed()) {
					System.out.println("rev");
					b = revealedSpyButton(b);
				}

				b.revalidate();
				//b.addActionListener(new bListener());
				b.setText("YUM");
				spyMasterBoard.add(b);
				spyMasterBoard.revalidate();
				MainWindow.get_window().revalidate();
			}
		}

		return spyMasterBoard;
	}

	public static void boardInit(Board b) {
		_board = b;
		Location[][] l = b.getBoard();
		_location = l;
		_boardSet = false;


	}
	
	public static void notRevealedSpyButton(LButton jb) {
		Location jbl = jb.get_location();
		if (jbl.get_person().equals("Red")) {
			System.out.println("red");
			jb.setBackground(Color.red);
			jb.setForeground(Color.white);
			jb.setName("RED AGENT");

		}
		else if (jbl.get_person().equals("Blue")) {
			jb.setBackground(Color.blue);
			jb.setForeground(Color.WHITE);
			jb.setName("BLUE AGENT");
		}
		else if (jbl.get_person().equals("Bystander")) {
			jb.setBackground(Color.DARK_GRAY);
			jb.setName("INNOCENT BYSTANDER");
		}
		else if (jbl.get_person().equals("Assassin")) {
			jb.setBackground(Color.MAGENTA);
			jb.setName("ASSASSIN");
		}
		
		if (jbl.get_codename().equals(jb.getText())) {
			jb.setEnabled(false);
			JPanel p = new JPanel();
			
			//
			JPanel pgl = new JPanel(new GridLayout(0,1));
			JLabel la1 = new JLabel(jbl.get_codename());
			JLabel la2 = new JLabel(jb.getName());
			pgl.add(la1);
			pgl.add(la2);
			la1.setVerticalAlignment(SwingConstants.CENTER);
			la1.setHorizontalAlignment(SwingConstants.CENTER);
			la1.setBackground(jb.getBackground());
			la2.setVerticalAlignment(SwingConstants.CENTER);
			la2.setHorizontalAlignment(SwingConstants.CENTER);
			la2.setBackground(jb.getBackground());
			la1.setForeground(Color.yellow);
			la2.setForeground(Color.yellow);
			pgl.add(la1);
			pgl.add(la2);
			jb.add(pgl);
			la1.setFont(new Font("Dialog", Font.PLAIN, 30));
			la2.setFont(new Font("Dialog", Font.PLAIN, 30));
			pgl.setBackground(jb.getBackground());
			pgl.setVisible(true);
			jb.revalidate();
			MainWindow.get_window().revalidate();
			//
			//JLabel la = new JLabel(jb.getText());
			/*JLabel la = new JLabel(jb.getName());
			la.setVerticalAlignment(SwingConstants.CENTER);
			la.setBackground(jb.getBackground());
			p.setLayout(new GridBagLayout());
			p.add(la);
			la.setForeground(Color.yellow);
			jb.add(p);
			la.setFont(new Font("Dialog", Font.PLAIN, 30));
			p.setBackground(jb.getBackground());
			p.setVisible(true);
			jb.revalidate();*/
			MainWindow.get_window().revalidate();
		}
		MainWindow.get_window().revalidate();
		jb.revalidate();
	}

	public static LButton revealedSpyButton(LButton b) {
		System.out.println("RRReee");
		LButton jb = b;
		Location jbl = jb.get_location();
		if (jbl.get_person().equals("Red")) {
			System.out.println("red");
			jb.setBackground(Color.red);
			jb.setForeground(Color.white);
			jb.setName("RED AGENT");

		}
		else if (jbl.get_person().equals("Blue")) {
			jb.setBackground(Color.blue);
			jb.setForeground(Color.WHITE);
			jb.setName("BLUE AGENT");
		}
		else if (jbl.get_person().equals("Bystander")) {
			jb.setBackground(Color.DARK_GRAY);
			jb.setName("INNOCENT BYSTANDER");
		}
		else if (jbl.get_person().equals("Assassin")) {
			jb.setBackground(Color.MAGENTA);
			jb.setName("ASSASSIN");
		}

		if (jbl.get_codename().equals(jb.getText())) {
			jb.setEnabled(false);
			JPanel p = new JPanel();
			//JLabel la = new JLabel(jb.getText());
			JLabel la = new JLabel(jb.getName());
			la.setVerticalAlignment(SwingConstants.CENTER);
			la.setBackground(jb.getBackground());
			p.setLayout(new GridBagLayout());
			p.add(la);
			la.setForeground(Color.yellow);
			jb.add(p);
			la.setFont(new Font("Dialog", Font.PLAIN, 30));
			p.setBackground(jb.getBackground());
			p.setVisible(true);
			jb.revalidate();
			MainWindow.get_window().revalidate();
		}
		MainWindow.get_window().revalidate();
		jb.revalidate();
		return jb;
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
					jb.setName("RED AGENT");
					
				}
				else if (jbl.get_person().equals("Blue")) {
					jb.setBackground(Color.blue);
					jb.setForeground(Color.WHITE);
					jb.setName("BLUE AGENT");
				}
				else if (jbl.get_person().equals("Bystander")) {
					jb.setBackground(Color.DARK_GRAY);
					jb.setName("INNOCENT BYSTANDER");
				}
				else if (jbl.get_person().equals("Assassin")) {
					jb.setBackground(Color.MAGENTA);
					jb.setName("ASSASSIN");
				}

				if (jbl.get_codename().equals(jb.getText())) {
					jb.setEnabled(false);
					JPanel p = new JPanel();
					//JLabel la = new JLabel(jb.getText());
					JLabel la = new JLabel(jb.getName());
					la.setVerticalAlignment(SwingConstants.CENTER);
					la.setBackground(jb.getBackground());
					p.setLayout(new GridBagLayout());
					p.add(la);
					la.setForeground(Color.yellow);
					jb.add(p);
					la.setFont(new Font("Dialog", Font.PLAIN, 30));
					p.setBackground(jb.getBackground());
					p.setVisible(true);
					jb.revalidate();
					MainWindow.get_window().revalidate();

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
