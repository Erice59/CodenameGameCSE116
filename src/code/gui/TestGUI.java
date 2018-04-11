package code.gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import code.Board;
import code.GameStart;
import code.Location;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
import java.io.File;
import java.io.IOException;

public class TestGUI {

	private ActionListener listener;
	private LButton[][] _buttons;
	private int _modCount;
	private GameStart _gs;
	private Location[][] lc;
	private Board _b;

	public TestGUI() {
		_modCount = 0;
	}

	public void menuBarCreate(JFrame window, GameStart gs) {

		_gs = gs;
		JPanel panel = new JPanel();
		panel.add(new JLabel("Test"));
		window.getContentPane().add(panel);
		JMenu fileMenu = new JMenu("File");
		JMenuItem start = new JMenuItem("Start New Game");
		fileMenu.add(start);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//GuiConnector testtest = new GuiConnector();
				GameStart gs = new GameStart(5, "Data/GameWords.txt");
				System.out.println(gs.getGameBoard().getBoard()[1][1].get_codename());
				//buttonInit(window, gs.getGameBoard());
				_modCount++;
				//testtest.tester();
				//window.setVisible(false);
				//window.dispose();
				//window.setVisible(true);
				window.revalidate();
				System.out.println("Hue");
				System.out.println(_modCount);
				buttonInit(window, gs.getGameBoard());
				window.setVisible(true);
				window.revalidate();
			}
		});

		JMenuItem exit = new JMenuItem("Quit Application");
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				window.dispose();
				if (_modCount > 5) {
					JFrame fun = new JFrame("Easter Egg!");
					JPanel woosh = new JPanel();
					try {
						BufferedImage hertz = ImageIO.read(new File("Data/MatthewPhoto.jpg"));
						JLabel hertzPic = new JLabel(new ImageIcon(hertz));
						woosh.add(hertzPic);
						fun.add(woosh);
						window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Dimension maximimDimension = Toolkit.getDefaultToolkit().getScreenSize();
						window.setMaximumSize(maximimDimension);
						window.setExtendedState(JFrame.MAXIMIZED_BOTH);
						//window.pack();
						woosh.setVisible(true);
						fun.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);

		JPanel teamPanel = new JPanel();
		JLabel teamTurn = new JLabel("Current Team: " + _gs.getCurrentTeamMove());
		teamTurn.setFont(start.getFont());
		teamTurn.setForeground(start.getForeground());
		teamPanel.add(teamTurn);
		menuBar.add(teamPanel);

		window.setJMenuBar(menuBar);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension maximimDimension = Toolkit.getDefaultToolkit().getScreenSize();
		window.setMaximumSize(maximimDimension);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//window.pack();

	}

	public void buttonInit(JFrame window, Board b) {
		Location[][] l = b.getBoard();

		lc = l;
		_b = b;
		if (_modCount > 0) {
			window.getContentPane().remove(1);
		}
		JPanel buttonsPanel = new JPanel();
		GridLayout style = new GridLayout(5,5);
		int maxGap = 20;
		buttonsPanel.setLayout(style);
		LButton dummy = new LButton("Button for formatting");
		Dimension buttonSize = dummy.getPreferredSize();
		buttonsPanel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap, (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));

		LButton[][] buttons = new LButton[5][5];

		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++ ) {
				buttons[row][col] = new LButton(l[row][col].get_codename(), l[row][col]);
				buttons[row][col].setName(l[row][col].toString());

				buttons[row][col].addActionListener(new bListener());

				buttonsPanel.add(buttons[row][col]);
			}
		}

		window.add(buttonsPanel);
		_buttons = buttons;
		System.out.println(_modCount);
	}

	private class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			LButton jb = (LButton) e.getSource();
			Location jbl = jb.get_location();
			// TODO Auto-generated method stub
			//((JButton) e.getSource()).setBackground(Color.blue);


			((LButton) e.getSource()).setName("a");
			int x = (((LButton) e.getSource()).getX())/512;
			int y = (((LButton) e.getSource()).getY())/512;
			System.out.println("x: " + x);
			System.out.println("y: " + y);
			//System.out.println((((LButton) e.getSource()).getX())/512 + "," + (((JButton) e.getSource()).getY())/512);
			System.out.println("loc: " + jbl.get_codename());
			System.out.println("but: " + jb.getText());
			if (!jbl.is_revealed() && jbl.get_codename().equals(jb.getText())) {
				System.out.println("weee");
				if (jbl.get_person().equals("Red")) {
					jb.setBackground(Color.red);
					jb.setForeground(Color.white);
				}
				else if (jbl.get_person().equals("Blue")) {
					jb.setBackground(Color.blue);
					jb.setForeground(Color.WHITE);
				}
				else if (jbl.get_person().equals("Bystander")) {
					jb.setBackground(Color.gray);
				}
				else if (jbl.get_person().equals("Assassin")) {
					jb.setBackground(Color.GREEN);
				}
			}

			if (jbl.get_codename().equals(jb.getText())) {
				jbl.set_revealed(true);
			}
		}

	}
	private class LButton extends JButton {

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