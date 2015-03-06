package com.sage.rpg.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sage.rpg.Game;
import com.sage.rpg.component.Button;
import com.sage.rpg.component.Component;
import com.sage.rpg.component.TextBox;
import com.sage.rpg.gfx.Colors;
import com.sage.rpg.gfx.SpriteHandler;
import com.sage.rpg.gfx.SpriteSheet;

public class CharacterCreation {
	
	private BufferedImage background;
	public static BufferedImage[] player;
	
	private SpriteSheet attributeSprites;
	private SpriteSheet colorSprites;
	private SpriteSheet playerSprites;
	
	public static Color[] playerColor;
	
	private Component[] attribute;
	private Component[] color;
	
	private Component menu;
	private Component play;
	private Component username;
	
	private final int PLAYER_SCALE = 15;
	private final int SCALE = 3;
	
	private final int ATTRIBUTE_X = 18;
	private final int ATTRIBUTE_Y = 18;
	private final int ATTRIBUTE_WIDTH = 28 * SCALE;
	private final int ATTRIBUTE_HEIGHT = 22 * SCALE;
	private final int ATTRIBUTE_PADDING = 21;
	
	private final int COLOR_X = 129;
	private final int COLOR_Y = 30;
	private final int COLOR_WIDTH = 10 * SCALE;
	private final int COLOR_HEIGHT = 10 * SCALE;
	private final int COLOR_PADDING_V = 6;
	private final int COLOR_PADDING_H = 9;
	
	private final int PLAYER_X = 425;
	private final int PLAYER_Y = 100;
	
	@SuppressWarnings("unused")
	private Game game;
	
	public CharacterCreation(final Game game) {
		
		this.game = game;
		
		background = SpriteHandler.load("/gui/background.png");
		
		attributeSprites = new SpriteSheet("/gui/partButtonSheet.png");
		colorSprites = new SpriteSheet("/gui/colorButtonSheet.png");
		playerSprites = new SpriteSheet("/player.png");
		
		attribute = new Component[5];
		color = new Component[29];
		player = new BufferedImage[5];
		playerColor = new Color[5];
		
		player[0] = playerSprites.getSprite(0, 0, 16, 16);
		player[1] = playerSprites.getSprite(16, 0, 16, 16);
		player[2] = playerSprites.getSprite(16 * 2, 0, 16, 16);
		player[3] = playerSprites.getSprite(16 * 3, 0, 16, 16);
		player[4] = playerSprites.getSprite(16 * 4, 0, 16, 16);
		
		playerColor[0] = Colors.DARK_BROWN;
		playerColor[1] = Colors.WHITE;
		playerColor[2] = Colors.RED;
		playerColor[3] = Colors.BLUE;
		playerColor[4] = Colors.LIGHT_ORANGE;
		
		attribute[0] = new Button(game, 0, ATTRIBUTE_X, ATTRIBUTE_Y, ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE, playerColor[0]); // hair
		attribute[1] = new Button(game, 1, ATTRIBUTE_X, calcPoint(1, ATTRIBUTE_PADDING, ATTRIBUTE_Y, ATTRIBUTE_HEIGHT), // eyes
				ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE, playerColor[1]);
		attribute[2] = new Button(game, 2, ATTRIBUTE_X, calcPoint(2, ATTRIBUTE_PADDING, ATTRIBUTE_Y, ATTRIBUTE_HEIGHT), // shirt
				ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE, playerColor[2]);
		attribute[3] = new Button(game, 3, ATTRIBUTE_X, calcPoint(3, ATTRIBUTE_PADDING, ATTRIBUTE_Y, ATTRIBUTE_HEIGHT), // pants
				ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE, playerColor[3]);
		attribute[4] = new Button(game, 4, ATTRIBUTE_X, calcPoint(4, ATTRIBUTE_PADDING, ATTRIBUTE_Y, ATTRIBUTE_HEIGHT), // skin
				ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE, playerColor[4]);
		
		attribute[0].setSelected(true);
		
		for (int i = 0; i < attribute.length; i++) {
			
			game.getComponentHandler().addExiledComponent(attribute[i]);
			
			((Button) attribute[i]).setSprite(0, attributeSprites.getSprite(i * ATTRIBUTE_WIDTH / SCALE, 0, ATTRIBUTE_WIDTH / SCALE,
					ATTRIBUTE_HEIGHT / SCALE));
			((Button) attribute[i]).setSprite(1, attributeSprites.getSprite(i * ATTRIBUTE_WIDTH / SCALE, ATTRIBUTE_HEIGHT / SCALE,
					ATTRIBUTE_WIDTH / SCALE, ATTRIBUTE_HEIGHT / SCALE));
			((Button) attribute[i]).setSprite(2, attributeSprites.getSprite(i * 34, (ATTRIBUTE_HEIGHT / SCALE) * 2, 34, ATTRIBUTE_HEIGHT / SCALE));
		}
		
		// DARK_COLORS
		color[0] = new Button(game, 5, COLOR_X, COLOR_Y, COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.DARK_RED);
		color[1] = new Button(game, 6, COLOR_X, calcPoint(1, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_GREEN);
		color[2] = new Button(game, 7, COLOR_X, calcPoint(2, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_BLUE);
		color[3] = new Button(game, 8, COLOR_X, calcPoint(3, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_YELLOW);
		color[4] = new Button(game, 9, COLOR_X, calcPoint(4, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_ORANGE);
		color[5] = new Button(game, 10, COLOR_X, calcPoint(5, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_BROWN);
		color[6] = new Button(game, 11, COLOR_X, calcPoint(6, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_PINK);
		color[7] = new Button(game, 12, COLOR_X, calcPoint(7, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_PURPLE);
		color[8] = new Button(game, 13, COLOR_X, calcPoint(8, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.DARK_GRAY);
		
		// REGULAR_COLORS
		color[9] = new Button(game, 14, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH), COLOR_Y, COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.RED);
		color[10] = new Button(game, 15, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(1, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.GREEN);
		color[11] = new Button(game, 16, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(2, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.BLUE);
		color[12] = new Button(game, 17, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(3, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.YELLOW);
		color[13] = new Button(game, 18, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(4, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.ORANGE);
		color[14] = new Button(game, 19, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(5, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.BROWN);
		color[15] = new Button(game, 20, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(6, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.PINK);
		color[16] = new Button(game, 21, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(7, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.PURPLE);
		color[17] = new Button(game, 22, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(8, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.GRAY);
		color[18] = new Button(game, 23, calcPoint(1, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(9, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.BLACK);
		
		// LIGHT_COLORS
		color[19] = new Button(game, 24, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH), COLOR_Y, COLOR_WIDTH, COLOR_HEIGHT,
				SCALE, Colors.LIGHT_RED);
		color[20] = new Button(game, 25, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(1, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_GREEN);
		color[21] = new Button(game, 26, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(2, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_BLUE);
		color[22] = new Button(game, 27, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(3, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_YELLOW);
		color[23] = new Button(game, 28, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(4, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_ORANGE);
		color[24] = new Button(game, 29, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(5, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_BROWN);
		color[25] = new Button(game, 30, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(6, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_PINK);
		color[26] = new Button(game, 31, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(7, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_PURPLE);
		color[27] = new Button(game, 32, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(8, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.LIGHT_GRAY);
		color[28] = new Button(game, 33, calcPoint(2, COLOR_PADDING_H, COLOR_X, COLOR_WIDTH),
				calcPoint(9, COLOR_PADDING_V, COLOR_Y, COLOR_HEIGHT), COLOR_WIDTH, COLOR_HEIGHT, SCALE, Colors.WHITE);
		
		for (int i = 0; i < color.length; i++) {
			
			game.getComponentHandler().addExiledComponent(color[i]);
			color[i].setResizeable(false);
			
			((Button) color[i]).setSprite(0, colorSprites.getSprite(i * COLOR_WIDTH / SCALE, 0,
					COLOR_WIDTH / SCALE, COLOR_HEIGHT / SCALE));
			((Button) color[i]).setSprite(1, colorSprites.getSprite(i * 12, 12, 12, 12));
			((Button) color[i]).setSprite(2, colorSprites.getSprite(i * 12, 12, 12, 12));
			
			if (((Button)color[i]).getColor() == ((Button)attribute[0]).getColor())
				color[i].setSelected(true);
		}
		
		menu = new Button(game, 34, 282, 366, ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE);
		((Button) menu).setSprite(0, attributeSprites.getSprite(5 * 28, 0, 28, 22));
		((Button) menu).setSprite(1, attributeSprites.getSprite(5 * 28, 22, 28, 22));
		((Button) menu).setText("Menu");
		
		play = new Button(game, 35, 699, 366, ATTRIBUTE_WIDTH, ATTRIBUTE_HEIGHT, SCALE);
		((Button) play).setSprite(0, attributeSprites.getSprite(5 * 28, 0, 28, 22));
		((Button) play).setSprite(1, attributeSprites.getSprite(5 * 28, 22, 28, 22));
		((Button) play).setText("Play");
		
		username = new TextBox(game, SpriteHandler.load("/gui/nameBox.png"), SpriteHandler.load("/gui/caret.png"), 36,
				game.getWidth() / 2, 385, 250, 30);
	}
	
	public void render(Graphics g) {
		
		g.drawImage(background, 0, 0, background.getWidth() * SCALE, background.getHeight() * SCALE, null);
		
		g.drawImage(player[0], PLAYER_X, PLAYER_Y, 16 * PLAYER_SCALE, 16 * PLAYER_SCALE, null);
		g.drawImage(player[1], PLAYER_X, PLAYER_Y, 16 * PLAYER_SCALE, 16 * PLAYER_SCALE, null);
		g.drawImage(player[2], PLAYER_X, PLAYER_Y, 16 * PLAYER_SCALE, 16 * PLAYER_SCALE, null);
		g.drawImage(player[3], PLAYER_X, PLAYER_Y, 16 * PLAYER_SCALE, 16 * PLAYER_SCALE, null);
		g.drawImage(player[4], PLAYER_X, PLAYER_Y, 16 * PLAYER_SCALE, 16 * PLAYER_SCALE, null);
		
		for (int i = 0; i < attribute.length; i++)
			attribute[i].render(g);
		
		for (int i = 0; i < color.length; i++)
			color[i].render(g);
		
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		g.setColor(Color.BLACK);
		
		menu.render(g);
		play.render(g);
		
		if (username.isSelected()) {
			
			g.setColor(Colors.DARK_GREEN);
			g.drawRect(username.getX() - 1, username.getY() - 1, username.getWidth() + 1, username.getHeight() + 1);
			g.setColor(Colors.BLACK);
		}
		
		username.render(g);
	}
	
	public int calcPoint(int position, int padding, int coord, int size) {
		
		coord = coord + (size * position) + (padding * position);
		
		return coord;
	}
}
