package com.sage.rpg.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Interface {
	
	private int x, y;
	private int width, height;
	private int outlineThickness;
	
	private Color backgroundColor;
	private Color outlineColor;
	
	private Font font;
	
	private List<Component> buttons;
	
	private String text;
	private boolean enabled = false;
	
	public Interface(String text, int x, int y, int width, int height, Color backgroundColor, Color outlineColor) {
		
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.backgroundColor = backgroundColor;
		this.outlineColor = outlineColor;
		
		buttons = new ArrayList<Component>();
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(backgroundColor);
		g.fillRect(x, y, width, height);
		
		g2d.setStroke(new BasicStroke(outlineThickness));
		g.setColor(outlineColor);
		g.drawRect(x, y, width, height);
		
		if (text != null) {
			
			int textAmount = wrapText(text).length;
			
			if (font != null)
				g.setFont(font);
			
			FontMetrics fm = g2d.getFontMetrics();
			Rectangle2D[] r = new Rectangle2D[textAmount];
			int[] textX = new int[textAmount];
			int[] textY = new int[textAmount];
			
			for (int i = 0; i < textAmount; i++) {
				
				r[i] = fm.getStringBounds(wrapText(text)[i], g2d);
				textX[i] = x + (width - (int) r[i].getWidth()) / 2;
				textY[i] = y + (i * 15) + 20;
				
				g.drawString(wrapText(text)[i], textX[i], textY[i]);
			}
		}
		
		for (Component c : buttons)
			c.render(g);
	}
	
	public void addButton(Component component) {
		
		buttons.add(component);
	}
	
	public String[] wrapText(String text) {
		
		return text.split("\n");
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public void setX(int x) {
		
		this.x = x;
	}
	
	public void setY(int y) {
		
		this.y = y;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public boolean isEnabled() {
		
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		
		this.enabled = enabled;
	}
	
	public int getOutlineThickness() {
		
		return outlineThickness;
	}
	
	public void setOutlineThickness(int outlineThickness) {
		
		this.outlineThickness = outlineThickness;
	}
	
	public Font getFont() {
		
		return font;
	}
	
	public void setFont(Font font) {
		
		this.font = font;
	}
	
	public Color getBackgroundColor() {
		
		return backgroundColor;
	}
	
	public Color getOutlineColor() {
		
		return outlineColor;
	}
	
	public String getText() {
		
		return text;
	}
	
	public void setText(String text) {
		
		this.text = text;
	}
}
