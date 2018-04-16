package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * Creates the menu bar
 * @author Alex Chmielewski
 * @author Eric Weinman
 * @author Jordan Clemons
 *
 */
public class MenuCreation {
	/**
	 * creates file containing list of what is in the file of the game
	 * @return JMenu with file
	 */
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
	/**
	 * help option
	 * @return JMenu for help
	 */
	public static JMenu helpMenuCreator() {
		JMenu helpMenu = new JMenu("Help");

		JMenuItem about = new JMenuItem("About");
		about.setName("about");
		about.addActionListener(new menuItemListener());
		helpMenu.add(about);

		JMenuItem debug = new JMenuItem("Change Board View");
		debug.setName("boardView");
		debug.addActionListener(new menuItemListener());
		helpMenu.add(debug);
		//MainWindow.get_window().revalidate();
		//MainWindow.get_window().setVisible(false);
		//MainWindow.get_window().setVisible(true);

		JMenuItem teamView = new JMenuItem("Team Board View");
		teamView.setName("teamView");
		teamView.addActionListener(new menuItemListener());
		helpMenu.add(teamView);
		
		JMenuItem spyView = new JMenuItem("Spymaster Board View");
		teamView.setName("spyView");
		spyView.addActionListener(new menuItemListener());
		helpMenu.add(spyView);


		JMenuItem cheatView = new JMenuItem("Board Cheat View");
		cheatView.setName("cheatView");
		cheatView.addActionListener(new menuItemListener());
		helpMenu.add(cheatView);
		//MainWindow.get_window().revalidate();
		//MainWindow.get_window().setVisible(false);
		//MainWindow.get_window().setVisible(true);

		return helpMenu;
	}

	/**
	 * action listener for menu items
	 * @author Eric Weinman
	 *
	 */
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
				About.aboutTeam();
			}
			else if (jmi.getName().equals("guide")) {
				
			}
			else if (jmi.getName().equals("teamView")) {
				MainWindow.setDisplayBoardTeam();
				JOptionPane.showMessageDialog(null, "SpyMaster Board View");
			}
			else if (jmi.getName().equals("spyView")) {
				MainWindow.setDisplayBoardSpyMaster();
				JOptionPane.showMessageDialog(null, "Team Turn Board View");
			}
			else if (jmi.getName().equals("cheatView")) {
				//MainWindow.setDisplayCheatView;
			}
			else if (jmi.getName().equals("boardView")) {
				if (MainWindow.get_currentBoardDisplayed().equals("team")) {
					MainWindow.setDisplayBoardSpyMaster();
					JOptionPane.showMessageDialog(null, "Team Turn Board View");
				}
				else if (MainWindow.get_currentBoardDisplayed().equals("spy")) {
					MainWindow.setDisplayBoardTeam();
					JOptionPane.showMessageDialog(null, "SpyMaster Board View");
				}
			}
			MainWindow.get_window().revalidate();
			//MainWindow.get_window().setVisible(false);
			//MainWindow.get_window().setVisible(true);
		}

	}
}
