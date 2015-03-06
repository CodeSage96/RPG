package com.sage.rpg.states;

import java.awt.Graphics;

import com.sage.rpg.Game;
import com.sage.rpg.entities.Player;
import com.sage.rpg.gfx.Colors;

public class GameState extends State {
	
	private final Game game;
	private Player player;
	
	public GameState(final Game game) {
		super(game);
		
		this.game = game;
		
		player = new Player(0, 0);
		player.setVelX(2);
		player.setVelY(2);
	}
	
	public void tick() {
		
		if (game.getKeyHandler().up)
			player.setY(player.getY() - player.getVelY());
		else if (game.getKeyHandler().down)
			player.setY(player.getY() + player.getVelY());
		
		if (game.getKeyHandler().left)
			player.setX(player.getX() - player.getVelX());
		else if (game.getKeyHandler().right)
			player.setX(player.getX() + player.getVelX());
	}
	
	public void render(Graphics g) {
		
		g.setColor(Colors.GRAY);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		
		player.render(g);
	}
}
