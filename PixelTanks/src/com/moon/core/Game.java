package com.moon.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.moon.objects.ArrayObjects;

public class Game extends JPanel implements Runnable {

	public static final int WIDTH = 3200 * 2;
	public static final int HEIGHT = 240 * 2;

	private ArrayObjects objects = new ArrayObjects();

	private Thread thread;

	{
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void paint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		objects.draw(g);
	}

	private void update() {
		objects.update();
	}

	@Override
	public void run() {

		while (true)
			try {
				Thread.sleep(30);
				update();
				repaint();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
