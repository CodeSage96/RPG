package com.sage.rpg.component;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import com.sage.rpg.Game;

public class Button extends Component {
	
	private BufferedImage[] sprite;
	
	private String text;
	private Color color;
	
	public Button(final Game game, int id, int x, int y, int width, int height) {
		
		super(game, id, x, y, width, height);
		
		sprite  = new BufferedImage[4];
	}
	
	public Button(final Game game, int id, int x, int y, int width, int height, int scale) {
		
		super(game, id, x, y, width, height);
		
		sprite = new BufferedImage[4];
		
		setScale(scale);
	}
	
	public Button(final Game game, int id, int x, int y, int width, int height, int scale, Color color) {
		
		super(game, id, x, y, width, height);
		
		sprite  = new BufferedImage[4];
		this.color = color;
		setScale(scale);
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		if (isDisabled() && sprite[3] != null) {
			
			if (isResizeable()) {
				
				setWidth(sprite[3].getWidth() * getScale());
				setHeight(sprite[3].getHeight() * getScale());
			}
			
			g.drawImage(sprite[3], getX(), getY(), getWidth(), getHeight(), null);
		} else if (isSelected() && sprite[2] != null) {
			
			if (isResizeable()) {
				
				setWidth(sprite[2].getWidth() * getScale());
				setHeight(sprite[2].getHeight() * getScale());
			}
			
			g.drawImage(sprite[2], getX(), getY(), getWidth(), getHeight(), null);
		} else if (getHovered() && sprite[1] != null) {
			
			if (isResizeable()) {
				setWidth(sprite[1].getWidth() * getScale());
				setHeight(sprite[1].getHeight() * getScale());
			}
			
			g.drawImage(sprite[1], getX(), getY(), getWidth(), getHeight(), null);
		} else {
			
			if (isResizeable()) {
				setWidth(sprite[0].getWidth() * getScale());
				setHeight(sprite[0].getHeight() * getScale());
			}
			
			g.drawImage(sprite[0], getX(), getY(), getWidth(), getHeight(), null);
		}
		
		if (text != null) {
			
			FontMetrics fm = g2d.getFontMetrics();
			Rectangle2D r = fm.getStringBounds(text, g2d);
			
			int textX =  getX() + ((sprite[0].getWidth() * getScale()) - (int) r.getWidth()) / 2;
			int textY =  getY() + ((sprite[0].getHeight() * getScale()) - (int) r.getHeight()) / 2 + fm.getAscent();
			g.drawString(text, textX, textY);
		}
	}
	
	public BufferedImage getSprite(int index) {
		
		return sprite[index];
	}
	
	public void setSprite(int index, BufferedImage sprite) {
		
		this.sprite[index] = sprite;
	}
	
	public String getText() {
		
		return text;
	}
	
	public void setText(String text) {
		
		this.text = text;
	}
	
	public Color getColor() {
		
		return color;
	}
	
	public void setColor(Color color) {
		
		this.color = color;
	}
}
