package com.moon.core;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {

		JFrame f = new JFrame("PixelTanks");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new Game());
		f.setVisible(true);
		f.setResizable(false);
		f.pack();
	}

}
