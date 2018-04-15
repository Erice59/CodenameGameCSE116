package code.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.*;

import javafx.scene.layout.Border;

public class MainWindow {
	
	private static JFrame _window;
	private static JPanel _contentPanel;
	private static JPanel _spyMasterGrid;
	private static JPanel _teamGrid;
	
	private static JMenuBar _menuBar;
	
	private static JPanel _teamTurnIndicator;

	public MainWindow() {
		
	}
	
	public static void main(String[] args) {
		windowCreation();
		addPrimaryMenu();
	}
	
	public void windowCreator(JFrame window) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension maximimDimension = Toolkit.getDefaultToolkit().getScreenSize();
		//window.setMaximumSize(maximimDimension);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.pack();
	}
	
	public static JFrame windowCreation() {
		JFrame window = new JFrame("Codenames the game!");
		window.setLayout(new BorderLayout());
		//JPanel primary = new JPanel(new GridBagLayout());

		JPanel primary = new JPanel(new BorderLayout());
		window.add(primary, BorderLayout.CENTER);
		//window.add(primary);
		//_window.setContentPane(primary);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		_window = window;
		_contentPanel = primary;
		return window;
	}
	
	public static void addPrimaryMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(MenuCreation.fileMenuCreator());
		_window.setJMenuBar(menuBar);
		_window.revalidate();
		_menuBar = menuBar;
		
	}
	
	public static void addTeamTurnDisplay() {
		
	}
	
	public static void spyMasterBoard() {
		
	}
	
	public static void teamBoard() {
		
	}
}
