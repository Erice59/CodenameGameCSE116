package code.gui;

import javax.swing.*;

import code.Board;
import code.Location;

import java.awt.*;
import java.awt.event.*;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;

public class Menu /*extends JFrame*/ implements ActionListener {

	private ActionListener listener;
	
	public /*static*/ void menuBarCreate(JFrame window) {
		
	//JFrame window = new JFrame("Codenames!");
	JPanel panel = new JPanel();
	panel.add(new JLabel("Test"));
	window.getContentPane().add(panel);
	JMenu fileMenu = new JMenu("File");
	
	JMenuItem start = new JMenuItem("Start New Game");
	fileMenu.add(start);
	start.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Hue");
		}
	});
	
	JMenuItem exit = new JMenuItem("Quit Application");
	fileMenu.add(exit);
	exit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			window.setVisible(false);
			window.dispose();
		}
	});
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.add(fileMenu);
	
	window.setJMenuBar(menuBar);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension maximimDimesnion = Toolkit.getDefaultToolkit().getScreenSize();
	window.setMaximumSize(maximimDimesnion);
	window.setExtendedState(JFrame.MAXIMIZED_BOTH);
	//window.pack();
	
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Codenames!");
		Menu test = new Menu();
		test.menuBarCreate(window);
		test.buttonInit(window, null);
		
	}

	public void buttonInit(JFrame window, Board b) {
		Location[][] l = b.getBoard();
		
		JPanel buttonsPanel = new JPanel();
		GridLayout style = new GridLayout(5,5);
		int maxGap = 20;
		buttonsPanel.setLayout(style);
		JButton dummy = new JButton("Button for formatting");
		Dimension buttonSize = dummy.getPreferredSize();
		buttonsPanel.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap, (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
		
		JButton[][] buttons = new JButton[5][5];
		for (int row = 0; row < l.length; row++) {
			for (int col = 0; col < l[row].length; col++ ) {
				buttons[row][col] = new JButton(l[row][col].get_codename());
				//buttons[row][col] = new JButton("Button " + row + col);
				buttonsPanel.add(buttons[row][col]);
			}
		}
		window.add(buttonsPanel);
	}
}
