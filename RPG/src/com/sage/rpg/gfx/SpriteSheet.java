package com.sage.rpg.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage spriteSheet;
	
	public SpriteSheet(String path) {
		
		spriteSheet = SpriteHandler.load(path);
	}
	
	public BufferedImage getSprite(int x, int y, int width, int height) {
		
		return spriteSheet.getSubimage(x, y, width, height);
	}

}
