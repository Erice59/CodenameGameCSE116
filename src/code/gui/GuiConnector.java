package code.gui;

import javax.swing.JFrame;

import code.GameStart;

public class GuiConnector {
	
	private int num;
	private GameStart _game;
	
	public static void main(String[] args) {
		GuiConnector testing = new GuiConnector();
		testing.tester();
	}
	
	public void tester() {
		GameStart gs = new GameStart(5, "Data/GameWords.txt");
		set_game(gs);
		JFrame window = new JFrame("Codenames!");
		Menu test = new Menu();
		test.menuBarCreate(window, _game);
		test.buttonInit(window, gs.getGameBoard());
		window.setVisible(true);
		//num++;
		//System.out.println(num);
		//
	}

	public GameStart get_game() {
		return _game;
	}

	public void set_game(GameStart _game) {
		this._game = _game;
	}
}
