package code.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import code.GameStart;
import code.Location;
import code.Teams;
import code.ThreeTBoardState;
import code.ThreeTurnLogic;

/**
 * @author Eric Weinman
 *
 */
public class BoardUpdate {

	/**
	 * @param jb
	 */
	public static void notRevealedSpyButton(LButton jb) {
		Location jbl = jb.get_location();
		if (jbl.get_person().equals("Red")) {
			System.out.println("red");
			jb.setBackground(Color.red);
			jb.setForeground(Color.white);
			jb.setName("RED AGENT");

		}
		else if (jbl.get_person().equals("Blue")) {
			jb.setBackground(Color.blue);
			jb.setForeground(Color.WHITE);
			jb.setName("BLUE AGENT");
		}
		else if (jbl.get_person().equals("Green")) {
			jb.setBackground(Color.green);
			jb.setForeground(Color.WHITE);
			jb.setName("GREEN AGENT");
		}
		else if (jbl.get_person().equals("Bystander")) {
			jb.setBackground(Color.DARK_GRAY);
			jb.setName("INNOCENT BYSTANDER");
		}
		else if (jbl.get_person().equals("Assassin")) {
			jb.setBackground(Color.MAGENTA);
			jb.setName("ASSASSIN");
		}

		if (jbl.get_codename().equals(jb.getText())) {
			jb.setEnabled(false);

			JPanel pgl = new JPanel(new GridLayout(0,1));
			JLabel la1 = new JLabel(jbl.get_codename());
			JLabel la2 = new JLabel(jb.getName());
			pgl.add(la1);
			pgl.add(la2);
			la1.setVerticalAlignment(SwingConstants.CENTER);
			la1.setHorizontalAlignment(SwingConstants.CENTER);
			la1.setBackground(jb.getBackground());
			la2.setVerticalAlignment(SwingConstants.CENTER);
			la2.setHorizontalAlignment(SwingConstants.CENTER);
			la2.setBackground(jb.getBackground());
			la1.setForeground(Color.yellow);
			la2.setForeground(Color.yellow);
			pgl.add(la1);
			pgl.add(la2);
			jb.add(pgl);
			la1.setFont(new Font("Dialog", Font.BOLD, 25));
			la2.setFont(new Font("Dialog", Font.BOLD, 25));
			pgl.setBackground(jb.getBackground());
			pgl.setVisible(true);
			jb.revalidate();
			MainWindow.get_window().revalidate();
		}
		MainWindow.get_window().revalidate();
		jb.revalidate();
	}

	/**
	 * @param b
	 */
	public static void revealedButton(LButton b) {
		LButton jb = b;
		Location jbl = jb.get_location();
		if (jbl.get_person().equals("Red")) {
			System.out.println("red");
			jb.setBackground(Color.red);
			jb.setForeground(Color.white);
			jb.setName("RED AGENT");
		}
		else if (jbl.get_person().equals("Blue")) {
			jb.setBackground(Color.blue);
			jb.setForeground(Color.WHITE);
			jb.setName("BLUE AGENT");
		}
		else if (jbl.get_person().equals("Green")) {
			jb.setBackground(Color.green);
			jb.setForeground(Color.WHITE);
			jb.setName("GREEN AGENT");
		}
		else if (jbl.get_person().equals("Bystander")) {
			jb.setBackground(Color.DARK_GRAY);
			jb.setName("INNOCENT BYSTANDER");
		}
		else if (jbl.get_person().equals("Assassin")) {
			jb.setBackground(Color.MAGENTA);
			jb.setName("ASSASSIN");
			if (MenuCreation.isThree()) {
				if (GameStart.getEliminatedTeam() == Teams.None) {
					GameStart.setEliminatedTeam(MainWindow.get_gameStart().getCurrentTeamMoveT());
					ThreeTBoardState.setJustChange(true);
				}
			}
		}
		if (jbl.get_codename().equals(jb.getText())) {
			jb.setEnabled(false);
			JPanel p = new JPanel();
			JLabel la = new JLabel(jb.getName());
			la.setVerticalAlignment(SwingConstants.CENTER);
			la.setBackground(jb.getBackground());
			p.setLayout(new GridBagLayout());
			p.add(la);
			la.setForeground(Color.yellow);
			jb.add(p);
			la.setFont(new Font("Dialog", Font.BOLD, 25));
			p.setBackground(jb.getBackground());
			p.setVisible(true);
			jb.revalidate();
			MainWindow.get_window().revalidate();
		}
		MainWindow.get_window().revalidate();
		jb.revalidate();
	}

	public static void checkPerson(Location jbl) {
		if (jbl.get_person().equals("Assassin") || jbl.get_person().equals("Bystander") ) {
			MainWindow.endTurn();
		}

		else {

			if (MenuCreation.isThree()) {
				if (MainWindow.get_gameStart().getCurrentTeamMove().equals("Green")) {
					if (!jbl.get_person().equals("Green")) {
						MainWindow.endTurn();
					}
				}
				else if (MainWindow.get_gameStart().getCurrentTeamMove().equals("Blue")) {
					if (!jbl.get_person().equals("Blue")) {
						MainWindow.endTurn();
					}
				}
				else if (MainWindow.get_gameStart().getCurrentTeamMove().equals("Red")) {
					if (!jbl.get_person().equals("Red")) {
						MainWindow.endTurn();
					}
				}
			}
			else if (MenuCreation.isThree() == false) {
				if (MainWindow.get_gameStart().getCurrentTeamMove().equals("Red")) {
					if (jbl.get_person().equals("Blue")) {
						MainWindow.endTurn();
					}
				}
				else if (MainWindow.get_gameStart().getCurrentTeamMove().equals("Blue")) {
					if (jbl.get_person().equals("Red")) {
						MainWindow.endTurn();
					}
				}
			}

		}
	}

	public static void checkAgentReveal() {
		if(!MenuCreation.isThree()) {

			if (MainWindow.get_blueAgentRevealed() == 8 || MainWindow.get_redAgentRevealed() == 9) {
				MainWindow.endTurn();
			}
		}
		else if (MenuCreation.isThree()) {
			if (MainWindow.get_blueAgentRevealed() == 5 || MainWindow.get_redAgentRevealed() == 6 || MainWindow.get_greenAgentRevealed() == 5) {
				MainWindow.endTurn();
			}
		}
	}
}
