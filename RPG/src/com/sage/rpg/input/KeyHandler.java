package com.sage.rpg.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sage.rpg.Game;
import com.sage.rpg.component.Component;
import com.sage.rpg.component.TextBox;

public class KeyHandler implements KeyListener {
	
	private boolean[] key;
	public boolean up, down, left, right;
	
	private final int MAX_CHARS = 12;
	
	private char[] valid_characters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', 
			'4', '5', '6', '7', '8', '9', ' '};
	
	private Game game;
	
	public KeyHandler(final Game game) {
		
		this.game = game;
		
		key = new boolean[256];
		
		game.addKeyListener(this);
	}
	
	public void tick() {
		
		up = key[KeyEvent.VK_W];
		left = key[KeyEvent.VK_A];
		down = key[KeyEvent.VK_S];
		right = key[KeyEvent.VK_D];
	}
	
	public void keyPressed(KeyEvent e) {
		
		key[e.getKeyCode()] = true;
		
		for (Component c : game.getComponentHandler().getComponents()) {
			
			if (c.getId() == 36) {
				
				TextBox tb = (TextBox) c;
				
				if (c.isSelected()) {
					
					if (validChar(valid_characters, e.getKeyChar())) {
						
						if (tb.getText() == null)
							tb.setText("");
						
						if (tb.getText().length() < MAX_CHARS) {
							tb.setText(tb.getText() + e.getKeyChar());
							tb.setCaretX(tb.getCaretX() + tb.getFM().charWidth(e.getKeyChar()));
						}
						
					} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						
						if (tb.getText() != null && tb.getText().length() > 0) {
							
							tb.setCaretX(tb.getCaretX() - tb.getFM().charWidth(tb.getText().charAt(tb.getText().length() - 1)));
							tb.setText(tb.getText().substring(0, tb.getText().length() - 1));
						}
					}
				}
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		key[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public boolean equalsIgnoreCase(char value1, char value2) {
		
		if (Character.toLowerCase(value1) == Character.toLowerCase(value2))
			return true;
		
		return false;
	}
	
	public boolean validChar(char[] charArray, char value) {
		
		for (char c : charArray) {
			
			if (equalsIgnoreCase(c, value))
				return true;
		}
		return false;
	}
}
