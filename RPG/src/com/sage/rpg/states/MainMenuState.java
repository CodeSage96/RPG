package com.sage.rpg.states;

import java.awt.Graphics;

import com.sage.rpg.Game;
import com.sage.rpg.Saving;
import com.sage.rpg.interfaces.MainMenu;

public class MainMenuState extends State {
	
	private MainMenu menu;
	
	public MainMenuState(Game game) {
		super(game);
		
		menu = new MainMenu(game);
		
		if (!Saving.available(Saving.SAVE_0) && !Saving.available(Saving.SAVE_1) &&
				!Saving.available(Saving.SAVE_2))
			game.getComponentHandler().getComponentById(37).setDisabled(true);
			
		if (Saving.available(Saving.SAVE_0) && Saving.available(Saving.SAVE_1) &&
				Saving.available(Saving.SAVE_2))
			game.getComponentHandler().getComponentById(38).setDisabled(true);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		menu.render(g);
	}
}
