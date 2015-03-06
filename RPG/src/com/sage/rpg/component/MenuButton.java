package com.sage.rpg.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.sage.rpg.Game;

public class MenuButton extends Component {
	
	private Interface parent;
	private int x, y;
	private int width, height;
	
	private String text;
	
	private int confirmId;
	
	public MenuButton(final Game game, int id, Interface parent, String text, int x, int y, int width, int height) {
		
		super(game, id, x + parent.getX(), y + parent.getY(), width, height);
		
		this.parent = parent;
		
		this.text = text;
		this.x = x + parent.getX();
		this.y = y + parent.getY();
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		if (getHovered())
			g.setColor(Color.LIGHT_GRAY);
		else if (isDisabled()) {
			g.setColor(Color.RED);
			text = "Disabled";
		} else
			g.setColor(parent.getBackgroundColor());
		
		g.fillRect(x, y, width, height);
		
		g2d.setStroke(new BasicStroke(parent.getOutlineThickness()));
		g.setColor(parent.getOutlineColor());
		g.drawRect(x, y, width, height);
		
		if (text != null) {
			
			if (parent.getFont() != null)
				g.setFont(parent.getFont());
			
			FontMetrics fm = g2d.getFontMetrics();
			Rectangle2D r = fm.getStringBounds(text, g2d);
			int textX = x + (width - (int) r.getWidth()) / 2;
			int textY = y + (height - (int) r.getHeight()) / 2 + fm.getAscent();
			
			g.drawString(text, textX, textY);
		}
	}
	
	public int getConfirmId() {
		
		return confirmId;
	}
	
	public void setConfirmId(int confirmId) {
		
		this.confirmId = confirmId;
	}
}
