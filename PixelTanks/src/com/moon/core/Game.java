package com.moon.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.moon.maps.TanksMap;

public class Game extends JPanel implements Runnable {

	public static final int WIDTH = 320 * 2;
	public static final int HEIGHT = 240 * 2;

	private Thread thread;

	private TanksMap map;

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

	private void init() {
		map = new TanksMap();
	}

	public void paint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		map.draw(g);
	}

	private void update() {
		map.update();
	}

	@Override
	public void run() {

		init();

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
