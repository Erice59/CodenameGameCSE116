package code.gui;

import java.util.*;

import javax.swing.*;

import code.*;

public class GuiCore {
	
	private JFrame _window;
	private GameStart _game;
	private JButton[][] _buttons;
	private Location[][] _locationBoard;
	private Board _board;
	private List<String> _codenames;
	private List<String> _personList;
	private BoardState _boardState;
	private String _teamTurn;
	
	
	
	public GuiCore() {
		
	}
	
	public GuiCore(GameStart gs, JFrame window) {
		_window = window;
		_game = gs;
		_board = _game.getGameBoard();
		_locationBoard = _board.getBoard();
		_codenames = _board.get_codenames();
		_personList = _board.get_personList();
		_boardState = new BoardState();
		
	}
	
	public void menuBarBuilder() {
		
	}
	
	
	
}
