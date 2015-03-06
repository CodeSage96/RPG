package com.sage.rpg.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sage.rpg.Saving;
import com.sage.rpg.gfx.Colors;
import com.sage.rpg.gfx.SpriteHandler;
import com.sage.rpg.gfx.SpriteSheet;

public class Player extends Entity {
	
	public BufferedImage[] playerSprites;
	public BufferedImage player;
	public SpriteSheet playerSheet;
	
	private final int SCALE = 3;

	public Player(int x, int y) {
		super(x, y);
		
		playerSprites = new BufferedImage[5];
		playerSheet = new SpriteSheet("/player.png");
		
		playerSprites[0] = playerSheet.getSprite(0, 0, 16, 16); // hair
		playerSprites[1] = playerSheet.getSprite(16, 0, 16, 16); // eyes
		playerSprites[2] = playerSheet.getSprite(16 * 2, 0, 16, 16); // shirt
		playerSprites[3] = playerSheet.getSprite(16 * 3, 0, 16, 16); // pants
		playerSprites[4] = playerSheet.getSprite(16 * 4, 0, 16, 16); // skin
		
		playerSprites[0] = SpriteHandler.changeColor(playerSprites[0], Colors.DARK_BROWN, new Color(
				Integer.parseInt(Saving.loadKey(Saving.currentSave, "hair_color"))));
		playerSprites[1] = SpriteHandler.changeColor(playerSprites[1], Colors.WHITE, new Color(
				Integer.parseInt(Saving.loadKey(Saving.currentSave, "eyes_color"))));
		playerSprites[2] = SpriteHandler.changeColor(playerSprites[2], Colors.RED, new Color(
				Integer.parseInt(Saving.loadKey(Saving.currentSave, "shirt_color"))));
		playerSprites[3] = SpriteHandler.changeColor(playerSprites[3], Colors.BLUE, new Color(
				Integer.parseInt(Saving.loadKey(Saving.currentSave, "pants_color"))));
		playerSprites[4] = SpriteHandler.changeColor(playerSprites[4], Colors.LIGHT_ORANGE, new Color(
				Integer.parseInt(Saving.loadKey(Saving.currentSave, "skin_color"))));
		
		player = SpriteHandler.combineSprites(playerSprites);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(player, x, y, 16 * SCALE, 16 * SCALE, null);
	}
}
