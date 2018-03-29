package code.gui;

import javax.swing.*;

import code.*;

public class Core {
	
	private GameStart _Game;
	
	public static void main(String[] args) {
		Core c = new Core();
		c.startGame();
		
		JOptionPane.showMessageDialog(null, "Yum");
	}
	
	public void startGame() {
		_Game = new GameStart(5, "Data/GameWords.txt");
	}
	
	public void 
}
