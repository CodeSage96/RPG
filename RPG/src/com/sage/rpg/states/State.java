package com.sage.rpg.states;

import java.awt.Graphics;

import com.sage.rpg.Game;

public abstract class State {
	
	public static State currentState;
	
	public State(final Game game) {
		
		game.getComponentHandler().getComponents().clear();
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public static State getState() {
		
		return currentState;
	}
	
	public static void setState(State state) {
		
		currentState = state;
	}
}
