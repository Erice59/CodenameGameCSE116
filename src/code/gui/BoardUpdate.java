package code.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import code.Location;

/**
 * @author Eric
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
			la1.setFont(new Font("Dialog", Font.PLAIN, 30));
			la2.setFont(new Font("Dialog", Font.PLAIN, 30));
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
			JPanel p = new JPanel();
			JLabel la = new JLabel(jb.getName());
			la.setVerticalAlignment(SwingConstants.CENTER);
			la.setBackground(jb.getBackground());
			p.setLayout(new GridBagLayout());
			p.add(la);
			la.setForeground(Color.yellow);
			jb.add(p);
			la.setFont(new Font("Dialog", Font.PLAIN, 30));
			p.setBackground(jb.getBackground());
			p.setVisible(true);
			jb.revalidate();
			MainWindow.get_window().revalidate();
		}
		MainWindow.get_window().revalidate();
		jb.revalidate();
	}
}
