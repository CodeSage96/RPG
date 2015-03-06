package com.sage.rpg;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.sage.rpg.component.ComponentHandler;
import com.sage.rpg.input.KeyHandler;
import com.sage.rpg.states.MainMenuState;
import com.sage.rpg.states.State;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private final String TITLE = "RPG";
	private final int WIDTH = 800;
	private final int HEIGHT = WIDTH / 16 * 9;
	
	private Thread thread = null;
	private boolean running = false;
	
	BufferStrategy bs = null;
	Graphics g = null;
	
	private ComponentHandler componentHandler;
	private KeyHandler keyHandler;
	
	private State mainMenu;
	
	public Game() {
		
		new Window(this, TITLE, WIDTH, HEIGHT);
	}
	
	public void init() {
		
		componentHandler = new ComponentHandler(this);
		keyHandler = new KeyHandler(this);
		
		mainMenu = new MainMenuState(this);
		
		State.setState(mainMenu);
	}
	
	public synchronized void start() {
		
		if (running)
			return;
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		
		if (!running)
			return;
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		
		if (State.getState() != null) {
			
			keyHandler.tick();
			State.getState().tick();
		}
	}
	
	public void render() {
		
		bs = this.getBufferStrategy();
		
		if (bs == null) {
			
			this.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		if (State.getState() != null) {
			
			State.getState().render(g);
		}
		
		g.dispose();
		bs.show();
		
	}

	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		
		while (running) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / timePerTick;
			lastTime = currentTime;
			
			if (delta >= 1) {
				
				tick();
				render();
				delta--;
			}
		}
		
		stop();
	}
	
	public static void main(String[] args) {
		
		new Game().start();
	}
	
	public ComponentHandler getComponentHandler() {
		
		return componentHandler;
	}
	
	public KeyHandler getKeyHandler() {
		
		return keyHandler;
	}
}
