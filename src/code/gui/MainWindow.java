package code.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import code.BoardState;
import code.Clue;
import code.GameStart;
import code.ThreeTBoardState;
import javafx.scene.layout.Border;
/**
 * Creates window for gui implementing most methods to run through turns, change turns, end turn and win states
 * @author Alex Chmielewski
 * @author Jordan Clemons
 * @author Eric Weinman
 *
 */
public class MainWindow {


	/**
	 * instance of gamestart
	 */

	private static GameStart _gs;
	/**
	 * two instances of clue, one for setup, one for current
	 */
	private static Clue _c;
	private static Clue _currentClue;
	/**
	 * instance of SpymasTurn
	 */
	private static SpymasTurn t;
	/**
	 * instance of boardstate
	 */
	private static BoardState _bs;
	private static ThreeTBoardState _tbs; //new
	/**
	 * instance of JFrame
	 */
	private static JFrame _window;
	/**
	 * multiple instance of JPanel for multiple different panels
	 */
	private static JPanel _contentPanel;
	private static JPanel _spyMasterGrid;
	private static JPanel _teamGrid;
	private static JPanel _boardPanel;

	
	private static JPanel _teamTurnIndicator;
	/**
	 * instance of JMenuBAR
	 */
	private static JMenuBar _menuBar;
	/**
	 * static string
	 */
	private static String _currentBoardDisplayed;

	private static int _redAgentRevealed;
	private static int _blueAgentRevealed;
	
	public MainWindow() {

	}

	/**
	 * void method that sets the window
	 * @param object
	 */
	public static void set_window(Object object) {
		_window =  (JFrame) object;
	}
	/**
	 * static method to return the window
	 * @return JFrame returns the window
	 */
	public static JFrame get_window() {
		return _window;
	}
	/**
	 * main method to run the methods
	 * @param args
	 */

	public static void main(String[] args) {
		windowCreation();
		addPrimaryMenu();
		initAgent();
	}
	
	public static void initAgent() {
		_redAgentRevealed = 0;
		_blueAgentRevealed = 0;
	}


	/**
	 * creates the window 
	 * @param window
	 */

	public void windowCreator(JFrame window) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimension maximimDimension = Toolkit.getDefaultToolkit().getScreenSize();
		//window.setMaximumSize(maximimDimension);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.pack();
	}

	/**
	 * Method to create the GUI window
	 * @return JFrame window in order to create the window for the gui
	 */

	public static JFrame windowCreation() {
		JFrame window = new JFrame("Codenames the game!");
		window.setLayout(new BorderLayout());
		//JPanel primary = new JPanel(new GridBagLayout());
		JPanel primary = new JPanel(new BorderLayout());
		JPanel boardWindow = new JPanel(new BorderLayout());
		//JPanel teamTurnIndicator = new JPanel(new BorderLayout());
		JPanel teamTurnIndicator = new JPanel(new FlowLayout(50, 250, 10));
		teamTurnIndicator.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		window.add(primary, BorderLayout.CENTER);
		primary.add((boardWindow), BorderLayout.CENTER);
		primary.add(teamTurnIndicator, BorderLayout.PAGE_START);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		_window = window;
		_contentPanel = primary;
		_boardPanel = boardWindow;
		_teamTurnIndicator = teamTurnIndicator;
		return window;
	}

	/**
	 * adds the primary menu for the GUI
	 */
	public static void addPrimaryMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(MenuCreation.fileMenuCreator());
		menuBar.add(MenuCreation.helpMenuCreator());
		_window.setJMenuBar(menuBar);
		_window.revalidate();
		_menuBar = menuBar;

	}

	/**
	 * takes the instance variables for gamestart and clue to start the game starting with spymaster then to the team
	 */
	public static void initGameBoard() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		_gs = gs;
		Clue c = new Clue(_gs);
		_c = c;
		spyMasterBoard();
		setDisplayBoardSpyMaster();
		t = new SpymasTurn(_gs, _c);
		_bs = new BoardState();
		_tbs = new ThreeTBoardState(); //new
		teamBoard();
		setDisplayBoardTeam();
		setTeamTurnDisplay();
		_window.revalidate();
	}

	/**
	 * contiues the turn with the different values
	 */
	public static void nextTurn() {

		setDisplayBoardSpyMaster();
		t = new SpymasTurn(_gs, _c);
		_bs = new BoardState();
		_tbs = new ThreeTBoardState(); // new
		setDisplayBoardTeam();
		setTeamTurnDisplay();
		_teamTurnIndicator.revalidate();
		_window.revalidate();
	}

	/**
	 * updates the count during the turn
	 */
	public static void updateInfoBar() {
		_currentClue.setCount(_currentClue.getCount()-1);
		setTeamTurnDisplay();
	}
	public static void endTurn() { //added if for three team or two team
		if(MenuCreation.isThree()) {
			if(_tbs.update(_gs)) {
				JOptionPane.showMessageDialog(null, _tbs.getWinner() + "Wins!");
			}else {
				if(_gs.getCurrentTeamMove().equals("Red")) {
					_gs.setCurrentTeamMove("Blue");
				}else if(_gs.getCurrentTeamMove().equals("Blue")) {
					_gs.setCurrentTeamMove("Green");
				}else {
					_gs.setCurrentTeamMove("Red");
				}
				nextTurn();
			}
		}
		else {
			if(_bs.update(_gs)) {
				JOptionPane.showMessageDialog(null, _bs.getWinner() + "Wins!");
			}else {
				if(_gs.getCurrentTeamMove().equals("Red")) {
					_gs.setCurrentTeamMove("Blue");
				}else {
					_gs.setCurrentTeamMove("Red");
				}
				nextTurn();
			}
		}
	}

	public static void checkCount() {
		_window.revalidate();
		if (_currentClue.getCount()-1 == -1 ) {
			endTurn();
		}
		else {
			_currentClue.setCount(_currentClue.getCount()-1);
			setTeamTurnDisplay();
		}
	}

	/**
	 * info for whose turn it is and the count and clue along with saying who wins when end turn is hit
	 */
	public static void setTeamTurnDisplay() {
		//System.out.println(javax.swing.UIManager.getDefaults().getFont("Label.font"));
		_teamTurnIndicator.removeAll();
		JLabel turn = new JLabel("Current team's turn: "  + _gs.getCurrentTeamMove() + " team");
		turn.setFont(new Font("Dialog", Font.BOLD, 15));
		_teamTurnIndicator.add(turn, FlowLayout.LEFT);
		JLabel count = new JLabel("Current Count: " + _currentClue.getCount());
		count.setFont(new Font("Dialog", Font.BOLD, 18));
		JLabel clue = new JLabel("Current Clue: " + _currentClue.getClue());
		clue.setFont(new Font("Dialog", Font.BOLD, 18));
		JButton endTurn = new JButton("End Turn");
		endTurn.setPreferredSize(new Dimension(150,60));
		endTurn.setFont(new Font("Dialog", Font.BOLD, 18));
		_teamTurnIndicator.add(count, FlowLayout.CENTER);
		_teamTurnIndicator.add(clue, FlowLayout.RIGHT);
		_teamTurnIndicator.add(endTurn, BorderLayout.PAGE_END);

		_window.revalidate();
		endTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("End TURN");
				endTurn();
			}
		});
	}

	/**
	 * displays the board just for the team so that the codenames are hidden
	 */
	public static void setDisplayBoardTeam() {
		_boardPanel.removeAll();
		_boardPanel.setVisible(false);
		_boardPanel.add(_teamGrid);
		set_currentBoardDisplayed("team");
		System.out.println("team");
		_boardPanel.setVisible(true);
		_boardPanel.revalidate();
		_contentPanel.revalidate();
		_window.revalidate();
	}

	/**
	 * shows all information just for spymaster
	 */
	public static void setDisplayBoardSpyMaster() {
		_boardPanel.removeAll();
		_boardPanel.setVisible(false);
		_spyMasterGrid = BoardCreation.spyMasterTurnBoardCreator();
		_boardPanel.add(_spyMasterGrid);
		set_currentBoardDisplayed("spy");
		System.out.println("spy");
		_boardPanel.setVisible(true);
		_boardPanel.revalidate();
		_contentPanel.revalidate();
		_window.revalidate();
	}


	/**
	 * spymaster board
	 */

	public static void spyMasterBoard() {
		BoardCreation.boardInit(_gs.getGameBoard());
		_spyMasterGrid = BoardCreation.teamTurnBoardCreator();
	}
	/**
	 * team board
	 */
	public static void teamBoard() {
		BoardCreation.boardInit(_gs.getGameBoard());
		_teamGrid = BoardCreation.teamTurnBoardCreator();
	}
	/**
	 * gets the current board being displayed
	 */
	public static String get_currentBoardDisplayed() {
		return _currentBoardDisplayed;
	}
/**
 * sets the board being displayed
 * @param _currentBoardDisplayed
 */
	public static void set_currentBoardDisplayed(String _currentBoardDisplayed) {
		MainWindow._currentBoardDisplayed = _currentBoardDisplayed;
	}
	/**
	 * gets the clue
	 * @return currentClue
	 */
	public static Clue get_clue() {
		return _currentClue;
	}

	/**
	 * sets the clue
	 * @param c
	 */
	public static void set_clue(Clue c) {
		_currentClue = c;
	}
	/**
	 * returns current team turn
	 * @return team turn
	 */
	public static JPanel get_teamTurnIndicator() {
		return _teamTurnIndicator;
	}
	
	public static GameStart get_gameStart() {
		return _gs;
	}

	/**
	 * sets team turn
	 * @param _teamTurnIndicator
	 */
	public static void set_teamTurnIndicator(JPanel _teamTurnIndicator) {
		MainWindow._teamTurnIndicator = _teamTurnIndicator;
	}

	public static int get_redAgentRevealed() {
		return _redAgentRevealed;
	}

	public static void set_redAgentRevealed(int _redAgentRevealed) {
		MainWindow._redAgentRevealed = _redAgentRevealed;
	}

	public static int get_blueAgentRevealed() {
		return _blueAgentRevealed;
	}

	public static void set_blueAgentRevealed(int _blueAgentRevealed) {
		MainWindow._blueAgentRevealed = _blueAgentRevealed;
	}

}
