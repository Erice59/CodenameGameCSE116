package code.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.*;

import code.GameStart;
import javafx.scene.layout.Border;

public class MainWindow {
	
	private static GameStart _gs;
	private static JFrame _window;
	private static JPanel _contentPanel;
	private static JPanel _spyMasterGrid;
	private static JPanel _teamGrid;
	
	private static JMenuBar _menuBar;
	
	private static JPanel _teamTurnIndicator;

	public MainWindow() {
		
	}
	
	public static void set_window(Object object) {
		_window =  (JFrame) object;
	}
	
	public static JFrame get_window() {
		return _window;
	}
	
	public static void main(String[] args) {
		windowCreation();
		addPrimaryMenu();
		initGameBoard();
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
		menuBar.add(MenuCreation.helpMenuCreator());
		_window.setJMenuBar(menuBar);
		_window.revalidate();
		_menuBar = menuBar;
		
	}
	
	public static void initGameBoard() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		_gs = gs;
		teamBoard();
		spyMasterBoard();
		setDisplayBoardTeam();
		_window.revalidate();
	}
	
	public static void addTeamTurnDisplay() {
		
	}
	
	public static void setDisplayBoardTeam() {
		_contentPanel.removeAll();
		_contentPanel.add(_teamGrid);
		_window.revalidate();
	}
	
	public static void setDisplayBoardSpyMaster() {
		_contentPanel.removeAll();
		_contentPanel.add(_spyMasterGrid);
		_window.revalidate();
	}
	
	public static void spyMasterBoard() {
		BoardCreation.boardInit(_gs.getGameBoard());
		_spyMasterGrid = BoardCreation.teamTurnBoardCreator();
	}
	
	public static void teamBoard() {
		BoardCreation.boardInit(_gs.getGameBoard());
		_teamGrid = BoardCreation.teamTurnBoardCreator();
	}

}
