package com.sage.rpg.component;

import java.awt.Graphics;

import com.sage.rpg.Game;

public class Component {
	
	private int id;
	private int x, y;
	private int width, height;
	private int scale = 1;
	
	private boolean selected;
	private boolean hovered;
	private boolean resizeable = true;
	private boolean disabled = false;
	
	public Component(final Game game, int id, int x, int y, int width, int height) {
		
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		game.getComponentHandler().addComponent(this);
	}
	
	public void render(Graphics g) {
		
	}
	
	public int getX() {
		
		return x;
	}
	
	public void setX(int x) {
		
		this.x = x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public void setY(int y) {
		
		this.y = y;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public void setWidth(int width) {
		
		this.width = width;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public void setHeight(int height) {
		
		this.height = height;
	}
	
	public int getId() {
		
		return id;
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public int getScale() {
		
		return scale;
	}
	
	public void setScale(int scale) {
		
		this.scale = scale;
	}
	
	public boolean isSelected() {
		
		return selected;
	}
	
	public void setSelected(boolean selected) {
		
		this.selected = selected;
	}
	
	public boolean isDisabled() {
		
		return disabled;
	}
	
	public void setDisabled(boolean disabled) {
		
		this.disabled = disabled;
	}
	
	public boolean getHovered() {
		
		return hovered;
	}
	
	public void setHovered(boolean hovered) {
		
		this.hovered = hovered;
	}
	
	public boolean isResizeable() {
		
		return resizeable;
	}
	
	public void setResizeable(boolean resizeable) {
		
		this.resizeable = resizeable;
	}
	
	public boolean contains(int x, int y) {
		
		if (x > this.x && x < this.x + width && y > this.y && y < this.y + height)
			return true;
		
		return false;
	}	
}