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

public class Menu /*extends JFrame*/ /*implements ActionListener*/ {

	private ActionListener listener;
	private JButton[][] _buttons;
	private int _modCount;
	private GameStart _gs;
	private Location[][] lc;
	private Board _b;

	public Menu() {
		_modCount = 0;
	}

	public /*static*/ void menuBarCreate(JFrame window, GameStart gs) {

		//JFrame window = new JFrame("Codenames!");
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
				GameStart gs = new GameStart("Data/GameWords.txt");
				System.out.println(gs.getGameBoard().getBoard()[1][1].get_codename());

				//buttonInit(window, gs.getGameBoard());
				_modCount++;
				//testtest.tester();
				//window.setVisible(false);
				//window.dispose();
				//window.setVisible(true);
				window.revalidate();
				//
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

	/*public static void main(String[] args) {
		JFrame window = new JFrame("Codenames!");
		Menu test = new Menu();
		test.menuBarCreate(window);
		test.buttonInit(window, null);

	}*/

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
		JButton dummy = new JButton("Button for formatting");
		Dimension buttonSize = dummy.getPreferredSize();
		buttonsPanel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap, (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));

		JButton[][] buttons = new JButton[5][5];
		/*System.out.println("init");
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++) {
				System.out.print(l[row][col].get_codename() + " | ");
			}
			System.out.println();
		}
		System.out.println("end");*/

		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++ ) {
				buttons[row][col] = new JButton(l[row][col].get_codename());
				//System.out.println(l[row][col].get_codename());
				buttons[row][col].setName(l[row][col].toString());
				//System.out.println(l[row][col].get_codename());
				//System.out.println(lc[row][col].get_codename());
				//System.out.println(_b.getBoard()[row][col].get_codename());
				//System.out.println(row + "," + col);
				//System.out.println("___");

				buttons[row][col].addActionListener(new bListener());
				
				/*buttons[row][col].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub
						//((JButton) e.getSource()).setBackground(Color.blue);
						((JButton) e.getSource()).setName("a");
						Location[][] lc = _b.getBoard();
						int x = (((JButton) e.getSource()).getX())/512;
						int y = (((JButton) e.getSource()).getY())/512;
						System.out.println("x: " + x);
						System.out.println("y: " + y);
						//System.out.println((((JButton) e.getSource()).getX())/512 + "," + (((JButton) e.getSource()).getY())/512);
						System.out.println("loc: " + lc[x][y].get_codename());
						System.out.println("but: " + ((JButton) e.getSource()).getText());
						//System.out.println(((JButton) e.getSource()).getName());
						if (lc[y][x].get_codename().equals(((JButton) e.getSource()).getText())) {
							System.out.println("weee");
							if (lc[y][x].get_person().equals("Red")) {
								((JButton) e.getSource()).setBackground(Color.red);
							}
							else if (lc[y][x].get_person().equals("Blue")) {
								((JButton) e.getSource()).setBackground(Color.blue);
							}
							else if (lc[y][x].get_person().equals("Bystander")) {
								((JButton) e.getSource()).setBackground(Color.gray);
							}
							else if (lc[y][x].get_person().equals("Assassin")) {
								((JButton) e.getSource()).setBackground(Color.GREEN);
							}
						}
						/*System.out.println("from button");
						for (int row = 0; row < l.length; row++) {
							for (int col = 0; col < l[row].length; col++) {
								System.out.print(l[row][col].get_codename() + " | ");
							}
							System.out.println();
						}*/
						/*if (_gs.getGameBoard().getBoard()[x][y].get_person().equals("Red")) {
							((JButton) e.getSource()).setBackground(Color.red);
						}*/

					//}
				//});

				//JTextArea d = new JTextArea();
				//d.setText("Test");
				//buttons[row][col].add(d, "hi");
				//buttons[row][col] = new JButton("Button " + row + col);
				buttonsPanel.add(buttons[row][col]);
			}
		}
		/*for (int row = 0; row < buttons.length; row++) {
			for (int col = 0; col < buttons[row].length; col++) {
				System.out.print(buttons[row][col].getText() + " | ");
			}
			System.out.println();
		}*/
		//if (window.get)
		window.add(buttonsPanel);
		_buttons = buttons;
		//_modCount++;
		System.out.println(_modCount);
	}


	private class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int _row = 0;
			int _col = 0;
			JButton jb = (JButton) e.getSource();
			// TODO Auto-generated method stub
			//((JButton) e.getSource()).setBackground(Color.blue);
			for (int row = 0; row < _buttons.length; row++) {
				for (int col = 0; col < _buttons[row].length; col++) {
					if (_buttons[row][col] == ((JButton) e.getSource())) {
						System.out.println("booya");
						_row = row;
						_col = col;
					}
				}
			}
			Location lt = lc[_row][_col];

			((JButton) e.getSource()).setName("a");
			Location[][] lc = _b.getBoard();
			int x = (((JButton) e.getSource()).getX())/512;
			int y = (((JButton) e.getSource()).getY())/512;
			System.out.println("x: " + x);
			System.out.println("y: " + y);
			//System.out.println((((JButton) e.getSource()).getX())/512 + "," + (((JButton) e.getSource()).getY())/512);
			System.out.println("loc: " + lc[x][y].get_codename());
			System.out.println("but: " + ((JButton) e.getSource()).getText());
			//System.out.println(((JButton) e.getSource()).getName());
			if (!lt.is_revealed() && lc[_row][_col].get_codename().equals(((JButton) e.getSource()).getText())) {
				System.out.println("weee");
				if (lc[_row][_col].get_person().equals("Red")) {
					((JButton) e.getSource()).setBackground(Color.red);
					jb.setForeground(Color.white);
				}
				else if (lc[_row][_col].get_person().equals("Blue")) {
					((JButton) e.getSource()).setBackground(Color.blue);
					jb.setForeground(Color.WHITE);
				}
				else if (lc[_row][_col].get_person().equals("Bystander")) {
					((JButton) e.getSource()).setBackground(Color.gray);
				}
				else if (lc[_row][_col].get_person().equals("Assassin")) {
					((JButton) e.getSource()).setBackground(Color.GREEN);
				}
			}
			if (lt.get_codename().equals(jb.getText())) {
				lt.set_revealed(true);
			}
			/*System.out.println("from button");
			for (int row = 0; row < l.length; row++) {
				for (int col = 0; col < l[row].length; col++) {
					System.out.print(l[row][col].get_codename() + " | ");
				}
				System.out.println();
			}*/
			/*if (_gs.getGameBoard().getBoard()[x][y].get_person().equals("Red")) {
				((JButton) e.getSource()).setBackground(Color.red);
			}*/

		

		}

	}
}