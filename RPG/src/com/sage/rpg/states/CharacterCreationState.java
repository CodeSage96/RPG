package com.sage.rpg.states;

import java.awt.Graphics;

import com.sage.rpg.Game;
import com.sage.rpg.interfaces.CharacterCreation;

public class CharacterCreationState extends State {
	
	private CharacterCreation characterCreation;
	
	public CharacterCreationState(Game game) {
		super(game);
		
		characterCreation = new CharacterCreation(game);
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		characterCreation.render(g);
	}
}
