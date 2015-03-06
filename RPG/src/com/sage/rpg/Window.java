package com.sage.rpg;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	private String title = "";
	private int width, height;
	private JFrame frame;
	
	public Window(Game game, String title, int width, int height) {

		this.title = title;
		this.width = width;
		this.height = height;
		construct(game);
	}
	
	private void construct(Game game) {
		
		frame = new JFrame(title);
		frame.setSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.setMaximumSize(new Dimension(width, height));
		game.setMinimumSize(new Dimension(width, height));
		game.setPreferredSize(new Dimension(width, height));
		game.requestFocus();
		
		frame.add(game);
		frame.pack();
		
	}
	
	public JFrame getFrame() {
		
		return frame;
	}

}
