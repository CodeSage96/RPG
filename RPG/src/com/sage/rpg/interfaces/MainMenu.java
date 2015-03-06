package com.sage.rpg.interfaces;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sage.rpg.Game;
import com.sage.rpg.component.Button;
import com.sage.rpg.component.Component;
import com.sage.rpg.gfx.Colors;
import com.sage.rpg.gfx.SpriteHandler;
import com.sage.rpg.gfx.SpriteSheet;

public class MainMenu {
	
	private BufferedImage background;
	
	private SpriteSheet buttonSprites;
	
	private Component[] button;
	
	private Game game;
	
	public MainMenu(final Game game) {
		
		this.game = game;
		
		background = SpriteHandler.load("/gui/menuBackground.png");
		
		buttonSprites = new SpriteSheet("/gui/menuButtons.png");
		
		button = new Component[9];
		
		// stage 1
		button[0] = new Button(game, 37, (game.getWidth() - 250) / 2, ((game.getHeight() - 50) / 2) - 60, 250, 50); // New Game
		((Button)button[0]).setSprite(0, buttonSprites.getSprite(0, 0, 250, 50));
		((Button)button[0]).setSprite(1, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[0]).setSprite(3, buttonSprites.getSprite(0, 100, 250, 50));
		((Button)button[0]).setText("New Game");
		
		button[1] = new Button(game, 38, (game.getWidth() - 250) / 2, (game.getHeight() - 50) / 2, 250, 50); // Continue
		((Button)button[1]).setSprite(0, buttonSprites.getSprite(0, 0, 250, 50));
		((Button)button[1]).setSprite(1, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[1]).setSprite(3, buttonSprites.getSprite(0, 100, 250, 50));
		((Button)button[1]).setText("Continue");
		
		button[2] = new Button(game, 39, (game.getWidth() - 250) / 2, ((game.getHeight() - 50) / 2) + 60, 250, 50); // Quit
		((Button)button[2]).setSprite(0, buttonSprites.getSprite(0, 0, 250, 50));
		((Button)button[2]).setSprite(1, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[2]).setSprite(3, buttonSprites.getSprite(0, 100, 250, 50));
		((Button)button[2]).setText("Quit");
		
		// stage 2
		button[3] = new Button(game, 40, (game.getWidth() - 250) / 2, ((game.getHeight() - 50) / 2) - 60, 250, 50); // Save 0
		((Button)button[3]).setSprite(0, buttonSprites.getSprite(0, 0, 250, 50));
		((Button)button[3]).setSprite(1, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[3]).setSprite(2, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[3]).setSprite(3, buttonSprites.getSprite(0, 100, 250, 50));
		((Button)button[3]).setText("Empty");
		game.getComponentHandler().addExiledComponent(button[3]);
		button[3].setDisabled(true);
				
		button[4] = new Button(game, 41, (game.getWidth() - 250) / 2, (game.getHeight() - 50) / 2, 250, 50); // Save 1
		((Button)button[4]).setSprite(0, buttonSprites.getSprite(0, 0, 250, 50));
		((Button)button[4]).setSprite(1, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[4]).setSprite(2, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[4]).setSprite(3, buttonSprites.getSprite(0, 100, 250, 50));
		((Button)button[4]).setText("Empty");
		game.getComponentHandler().addExiledComponent(button[4]);
		button[4].setDisabled(true);
				
		button[5] = new Button(game, 42, (game.getWidth() - 250) / 2, ((game.getHeight() - 50) / 2) + 60, 250, 50); // Save 2
		((Button)button[5]).setSprite(0, buttonSprites.getSprite(0, 0, 250, 50));
		((Button)button[5]).setSprite(1, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[5]).setSprite(2, buttonSprites.getSprite(0, 50, 250, 50));
		((Button)button[5]).setSprite(3, buttonSprites.getSprite(0, 100, 250, 50));
		((Button)button[5]).setText("Empty");
		game.getComponentHandler().addExiledComponent(button[5]);
		button[5].setDisabled(true);
		
		button[6] = new Button(game, 43, 20, 385, 100, 50); // Menu
		((Button)button[6]).setSprite(0, buttonSprites.getSprite(0, 150, 100, 50));
		((Button)button[6]).setSprite(1, buttonSprites.getSprite(0, 200, 100, 50));
		((Button)button[6]).setSprite(3, buttonSprites.getSprite(0, 250, 100, 50));
		((Button)button[6]).setText("Menu");
		
		button[7] = new Button(game, 44, 500, 385, 100, 50); // Play
		((Button)button[7]).setSprite(0, buttonSprites.getSprite(0, 150, 100, 50));
		((Button)button[7]).setSprite(1, buttonSprites.getSprite(0, 200, 100, 50));
		((Button)button[7]).setSprite(3, buttonSprites.getSprite(0, 250, 100, 50));
		((Button)button[7]).setText("Play");
		button[7].setDisabled(true);
		
		button[8] = new Button(game, 45, 650, 385, 100, 50); // Delete
		((Button)button[8]).setSprite(0, buttonSprites.getSprite(0, 150, 100, 50));
		((Button)button[8]).setSprite(1, buttonSprites.getSprite(0, 200, 100, 50));
		((Button)button[8]).setSprite(3, buttonSprites.getSprite(0, 250, 100, 50));
		((Button)button[8]).setText("Delete");
		button[8].setDisabled(true);
		
		game.getComponentHandler().setStage(0);
	}
	
	public void render(Graphics g) {
		
		g.drawImage(background, 0, 0, null);
		g.setColor(Colors.BLACK);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		
		if (game.getComponentHandler().getStage() == 0) {
			
			button[0].render(g);
			button[1].render(g);
			button[2].render(g);
		} else if (game.getComponentHandler().getStage() == 1) {
			
			for (int i = 3; i <= 5; i++) {
				
				if (button[i].isSelected()) {
					g.setColor(Colors.DARK_GREEN);
					g.drawRect(button[i].getX() - 1, button[i].getY() - 1, button[i].getWidth() + 1, button[i].getHeight() + 1);
				}
				
				button[i].render(g);
				g.setColor(Colors.BLACK);
			}
			
			button[6].render(g);
			button[7].render(g);
			button[8].render(g);
		}
	}
}
