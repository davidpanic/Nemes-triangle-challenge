package me.psrcek.triangleChallenge;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setTitle("Triangle for Nemes :O");
		
		Point p1 = new Point(100, 100, new Color(255, 0, 0).getRGB());
		Point p2 = new Point(100, 500, new Color(0, 255, 0).getRGB());
		Point p3 = new Point(500, 500, new Color(0, 0, 255).getRGB());
		
		ImageIcon image = new ImageIcon(new Triangle(p1, p2, p3).getImage());
		JLabel imageLabel = new JLabel(image);
		
		frame.add(imageLabel);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
