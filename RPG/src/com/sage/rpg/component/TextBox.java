package com.sage.rpg.component;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import com.sage.rpg.Game;

public class TextBox extends Component {

	private String text;
	private BufferedImage sprite;
	private BufferedImage caretSprite;
	private final int BLINK_TIME_MS = 500;
	private FontMetrics fm;
	private int caretX, caretY;
	
	public TextBox(Game game, int id, int x, int y, int width, int height) {
		super(game, id, x, y, width, height);
	}
	
	public TextBox(final Game game, BufferedImage sprite, BufferedImage caretSprite, int id, int x, int y, int width, int height) {
		super(game, id, x, y, width, height);
		
		this.sprite = sprite;
		this.caretSprite = caretSprite;
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.drawImage(sprite, getX(), getY(), getWidth(), getHeight(), null);
		
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		fm = g2d.getFontMetrics();
		
		if (text != null) {
			
			Rectangle2D r = fm.getStringBounds(text, g2d);
			
			int textX =  getX() + (sprite.getWidth() - (int) r.getWidth()) / 2;
			int textY =  getY() + (sprite.getHeight() - (int) r.getHeight()) / 2 + fm.getAscent();
			
			g.drawString(text, textX, textY);
		}
		
		if (isSelected()) {
			
			boolean isVisible = System.currentTimeMillis() % (2 * BLINK_TIME_MS) < BLINK_TIME_MS;
			
			if (isVisible)
				g.drawImage(caretSprite, getX() + (((sprite.getWidth() - caretSprite.getWidth()) / 2) + (caretX / 2)),
						getY() + (caretY + 5), null);
		}
		
	}
	
	public int getCaretX() {
		
		return caretX;
	}
	
	public void setCaretX(int caretX) {
		
		this.caretX = caretX;
	}
	
	public int getCaretY() {
		
		return caretY;
	}
	
	public void setCaretY(int caretY) {
		
		this.caretY = caretY;
	}
	
	public FontMetrics getFM() {
		
		return fm;
	}
	
	public String getText() {
		
		return text;
	}
	
	public void setText(String text) {
		
		this.text = text;
	}
	
	public BufferedImage getSprite() {
		
		return sprite;
	}
	
	public void setSprite(BufferedImage sprite) {
		
		this.sprite = sprite;
	}
	
	public BufferedImage getCaretSprite() {
		
		return caretSprite;
	}
	
	public void setCaretSprite(BufferedImage caretSprite) {
		
		this.caretSprite = caretSprite;
	}
}