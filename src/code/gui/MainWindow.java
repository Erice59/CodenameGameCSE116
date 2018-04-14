package code.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class MainWindow {
	
	private static JFrame _window;

	public MainWindow() {
		
	}
	
	public static void main(String[] args) {
		windowCreation();
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
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setVisible(true);
		_window = window;
		return window;
	}
	
	public static void AddPrimaryMenu() {
		
	}
	
}
