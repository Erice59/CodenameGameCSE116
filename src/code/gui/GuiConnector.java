package code.gui;

import javax.swing.JFrame;

import code.GameStart;

public class GuiConnector {

	public static void main(String[] args) {
		GuiConnector testing = new GuiConnector();
		testing.tester();
	}
	
	public void tester() {
		GameStart gs = new GameStart(5, "Data/GameWords2.txt");
		JFrame window = new JFrame("Codenames!");
		Menu test = new Menu();
		test.menuBarCreate(window);
		test.buttonInit(window, gs.getGameBoard());
		window.setVisible(true);
	}
}
