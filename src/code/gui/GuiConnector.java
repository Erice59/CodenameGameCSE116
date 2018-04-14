package code.gui;

import javax.swing.JFrame;

import code.Board;
import code.GameStart;

public class GuiConnector {
	
	private int num;
	private GameStart _game;
	private Board _b;
	
	public static void main(String[] args) {
		GuiConnector testing = new GuiConnector();
		testing.tester();
	}
	
	public void tester() {
		GameStart gs = new GameStart("Data/GameWords.txt");
		set_game(gs);
		_b = _game.getGameBoard();
		JFrame window = new JFrame("Codenames!");
		TestGUI test = new TestGUI();
		//Menu test = new Menu();
		test.menuBarCreate(window, _game);
		test.buttonInit(window, _b);
		//test.buttonInit(window, gs.getGameBoard());
		window.setVisible(true);
		//num++;
		//System.out.println(num);
	}

	public GameStart get_game() {
		return _game;
	}

	public void set_game(GameStart _game) {
		this._game = _game;
	}
}
