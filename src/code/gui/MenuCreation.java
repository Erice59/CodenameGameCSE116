package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		return helpMenu;
	}
	
	
	private static class menuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JMenuItem jmi = (JMenuItem) arg0.getSource();
			if (jmi.getName().equals("start")) {
				System.out.println("start");
			}
			
			else if (jmi.getName().equals("exit")) {
				System.out.println("exit");
			}
			
			else if (jmi.getName().equals("about")) {
				
			}
			
			else if (jmi.getName().equals("guide")) {
				
			}
			
		}
		
	}
}
