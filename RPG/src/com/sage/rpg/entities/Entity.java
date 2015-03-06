package com.sage.rpg.entities;

import java.awt.Graphics;

public abstract class Entity {
	
	protected int x, y;
	protected int velX, velY;
	
	public Entity(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
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
	
	public int getVelX() {
		
		return velX;
	}
	
	public void setVelX(int velX) {
		
		this.velX = velX;
	}
	
	public int getVelY() {
		
		return velY;
	}
	
	public void setVelY(int velY) {
		
		this.velY = velY;
	}

}
