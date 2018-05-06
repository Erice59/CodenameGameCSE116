package code.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class About {

	public static void aboutTeam() {
		System.out.println("WOO");
		Media amazing = new Media(new File("Data/ee.mp3").toURI().toString());
		MediaPlayer mP = new MediaPlayer(amazing);
		mP.play();
		JFrame frameTeam = new JFrame("Team");
		
		
		JFrame frame = new JFrame("Easter EGG!");
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("Data/MatthewPhoto.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			frame.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.pack();
		frame.setVisible(true);
		
	}
	
}
