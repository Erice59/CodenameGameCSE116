package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuCreation {

	public static JMenu fileMenuCreator() {
		JMenu fileMenu = new JMenu("File");
		JMenuItem start = new JMenuItem("Start New Game");
		start.setName("start");
		start.addActionListener(new menuItemListener());
		fileMenu.add(start);
		
		JMenuItem exit = new JMenuItem("Quit Application");
		exit.setName("exit");
		exit.addActionListener(new menuItemListener());
		fileMenu.add(exit);
		return fileMenu;
	}
	
	public static JMenu helpMenuCreator() {
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem about = new JMenuItem("About");
		about.setName("about");
		about.addActionListener(new menuItemListener());
		helpMenu.add(about);
		
		return helpMenu;
	}
	
	
	private static class menuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem jmi = (JMenuItem) arg0.getSource();
			if (jmi.getName().equals("start")) {
				System.out.println("start");
				MainWindow.initGameBoard();
			}
			
			else if (jmi.getName().equals("exit")) {
				System.out.println("exit");
				MainWindow.get_window().setVisible(false);
				MainWindow.get_window().dispose();
			}
			
			else if (jmi.getName().equals("about")) {
				System.out.println("about");
				JOptionPane.showMessageDialog(null, "Easter EGG TBD");
			}
			
			else if (jmi.getName().equals("guide")) {
				
			}
			
		}
		
	}
}
