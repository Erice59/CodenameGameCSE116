package code.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.player.Player;

public class About {

	public static void aboutTeam() {
		System.out.println("WOO");
		Font f = new Font("Dialog", Font.BOLD, 25);
		Font f1 = new Font("Dialog", Font.BOLD, 18);
		JPanel frameTeam = new JPanel(new GridLayout(5,0));
		JLabel a = new JLabel("CSE 116 Codenames game made by:");
		JLabel b = new JLabel("Eric Weinman");
		JLabel c = new JLabel("Alex Chmielewski");
		JLabel d = new JLabel("Jordan Clemons");
		a.setFont(f);
		b.setFont(f1);
		c.setFont(f1);
		d.setFont(f1);
		frameTeam.add(a);
		frameTeam.add(b);
		frameTeam.add(c);
		frameTeam.add(d);

		int ret = JOptionPane.showConfirmDialog(null,  frameTeam, "Team", JOptionPane.OK_CANCEL_OPTION);
		if (ret == JOptionPane.OK_OPTION) {
			ee();
		}
		else if (ret == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "You might be missing out");
		}

		JFrame frame = new JFrame("Easter EGG!");
	}
	public static void ee() {	
		JFrame frame = new JFrame("Easter EGG!");
		JPanel pa = new JPanel(new GridLayout(2, 0));
		BufferedImage myPicture;
		JLabel la = new JLabel("Lord and Savior Hertz");
		la.setFont(new Font("Dialog", Font.BOLD, 30));
		pa.add(la);
		try {
			myPicture = ImageIO.read(new File("Data/MatthewPhoto.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			pa.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.add(pa);
		frame.pack();
		frame.setVisible(true);

		new Thread() {

			@Override
			public void run() {
				int i = 0;
				do {
					if (i == 0) {
						try(FileInputStream fis = new FileInputStream("Data/ee1.mp3")){
							new Player(fis).play();
							i = 1;
						}
						catch(Exception e){
							System.out.println(e);
						}
					}
					if (i == 1) {
						try(FileInputStream fis = new FileInputStream("Data/ee.mp3")){
							new Player(fis).play();
							i = 2;
						}
						catch(Exception e){
							System.out.println(e);
						}
					}
					if (i == 2) {
						try(FileInputStream fis = new FileInputStream("Data/ee2.mp3")){
							new Player(fis).play();
							i = 3;
						}
						catch(Exception e){
							System.out.println(e);
						}
					}
					if (i ==3) {
						i = 0;
					}
					/*try(FileInputStream fis = new FileInputStream("Data/ee.mp3")){
					new Player(fis).play();
				}catch(Exception e){System.out.println(e);}*/
				}while(true);
			}
		}.start();
	} 
}
