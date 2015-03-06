package com.sage.rpg.gfx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteHandler {
	
	private static BufferedImage sprite;
	
	public static BufferedImage load(String path) {
		
		try {
			sprite = ImageIO.read(SpriteHandler.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sprite;
	}
	
	public static BufferedImage changeColor(BufferedImage sprite, Color color1, Color color2) {
		
		int width = sprite.getWidth();
		int height = sprite.getHeight();
		int[] colors = new int[width * height];
		
		BufferedImage tempSprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		sprite.getRGB(0, 0, width, height, colors, 0, width);
		tempSprite.setRGB(0, 0, width, height, colors, 0, width);
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				if (tempSprite.getRGB(x, y) == color1.getRGB())
					tempSprite.setRGB(x, y, color2.getRGB());
			}
		}
		
		return tempSprite;
	}
	
	public static BufferedImage combineSprites(BufferedImage[] sprite) {
		
		int width = 0;
		int height = 0;
		
		for (int i = 0; i < sprite.length; i++) {
			
			width = sprite[i].getWidth();
			height = sprite[i].getHeight();
			
			if (sprite[i].getWidth() > width)
				width = sprite[i].getWidth();
			
			if (sprite[i].getHeight() > height)
				height = sprite[i].getHeight();
		}
		
		BufferedImage newSprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics g = newSprite.getGraphics();
		
		for (int i = 0; i < sprite.length; i++)
			g.drawImage(sprite[i], 0, 0, null);
		
		g.dispose();
		
		return newSprite;
	}
}
