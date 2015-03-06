package com.sage.rpg.component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.sage.rpg.Game;
import com.sage.rpg.Saving;
import com.sage.rpg.gfx.SpriteHandler;
import com.sage.rpg.interfaces.CharacterCreation;
import com.sage.rpg.states.CharacterCreationState;
import com.sage.rpg.states.GameState;
import com.sage.rpg.states.MainMenuState;
import com.sage.rpg.states.State;

public class ComponentHandler extends MouseAdapter {
	
	private List<Component> components;
	private List<Component> exiledComponents;
	
	private int index = 0;
	private int stage = 0;
	
	private State mainMenu;
	private State gameState;
	private State characterCreation;
	
	private Game game;
	
	public ComponentHandler(final Game game) {
		
		this.game = game;
		
		components = new ArrayList<Component>();
		exiledComponents = new ArrayList<Component>();
		
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
	}
	
	public void mouseMoved(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		int componentId = -1;
		
		for (Component c : components) {
			
			if (c == null || c.isDisabled())
				continue;
			
			if (c.contains(x, y)) {
				componentId = c.getId();
			
				if (!c.getHovered())
					c.setHovered(true);
			} else
				c.setHovered(false);
		}
		
		if (componentId != -1) {
			
			switch(componentId) {
				// TODO: HANDLE THINGS
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		int componentId = -1;
		
		for (Component c : components) {
			
			if (c == null || c.isDisabled())
				continue;
			
			if (c.contains(x, y)) {
				componentId = c.getId();
				
				if (!c.isSelected() && !exiledComponents.contains(c));
					c.setSelected(true);
			} else {
				
				if (!exiledComponents.contains(c))
					c.setSelected(false);
			}
		}
		
		if (componentId != -1) {
			
			Component component = getComponentById(componentId);
			
			switch(componentId) {
			
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				component.setSelected(true);
				index = componentId;
				
				for (Component c : exiledComponents) {
					
					if (c.getId() >= 0 && c.getId() <= 4) {
						
						if (c.getId() != component.getId())
							c.setSelected(false);
					}
					
					if (c.getId() >= 5 && c.getId() <= 33) {
						
						if (((Button) component).getColor() == ((Button)c).getColor())
							c.setSelected(true);
						else
							c.setSelected(false);
					}
				}
				break;
				
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
			case 24:
			case 25:
			case 26:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
			case 32:
			case 33:
				component.setSelected(true);
				
				CharacterCreation.player[index] = SpriteHandler.changeColor(CharacterCreation.player[index],
						CharacterCreation.playerColor[index],
						
						((Button)component).getColor());
				CharacterCreation.playerColor[index] = ((Button)component).getColor();
				
				for (Component c : exiledComponents) {
					
					if (c.getId() >= 5 && c.getId() <= 33) {
						
						if (c != component)
							c.setSelected(false);
					}
					
					if (c.getId() >= 0 && c.getId() <= 4) {
						
						if (c.getId() == index) {
							
							((Button) c).setColor(((Button) component).getColor());
						}
					}
				}
				break;
				
			case 34:
				mainMenu = new MainMenuState(game);
				State.setState(mainMenu);
				break;
			case 35:
				
				TextBox tb = (TextBox) getComponentById(36);
				
				if (tb.getText() != null && tb.getText().length() > 0) {
					Saving.saveKey(Saving.currentSave, "username", tb.getText());
					Saving.saveKey(Saving.currentSave, "hair_color", Integer.toString(CharacterCreation.playerColor[0].getRGB()));
					Saving.saveKey(Saving.currentSave, "eyes_color", Integer.toString(CharacterCreation.playerColor[1].getRGB()));
					Saving.saveKey(Saving.currentSave, "shirt_color", Integer.toString(CharacterCreation.playerColor[2].getRGB()));
					Saving.saveKey(Saving.currentSave, "pants_color", Integer.toString(CharacterCreation.playerColor[3].getRGB()));
					Saving.saveKey(Saving.currentSave, "skin_color", Integer.toString(CharacterCreation.playerColor[4].getRGB()));
					
					gameState = new GameState(game);
					State.setState(gameState);
				} else
					System.out.println("Invalid username...");
				break;
			case 37: // New Game
				characterCreation = new CharacterCreationState(game);
				State.setState(characterCreation);
				
				if (Saving.available(Saving.SAVE_0))
					Saving.currentSave = Saving.SAVE_0;
				else if (Saving.available(Saving.SAVE_1))
					Saving.currentSave = Saving.SAVE_1;
				else if (Saving.available(Saving.SAVE_2))
					Saving.currentSave = Saving.SAVE_2;
				
				System.out.println("Current Save:" + Saving.currentSave);
				break;
			case 38: // Continue
				
				stage = 1;
				getComponentById(37).setDisabled(true);
				getComponentById(38).setDisabled(true);
				getComponentById(39).setDisabled(true);
				
				if (Saving.loadKey(Saving.SAVE_0, "username") != null) {
					getComponentById(40).setDisabled(false);
					((Button)getComponentById(40)).setText(Saving.loadKey(Saving.SAVE_0, "username"));
				}
				if (Saving.loadKey(Saving.SAVE_1, "username") != null) {
					getComponentById(41).setDisabled(false);
					((Button)getComponentById(41)).setText(Saving.loadKey(Saving.SAVE_1, "username"));
				}
				if (Saving.loadKey(Saving.SAVE_2, "username") != null) {
					getComponentById(42).setDisabled(false);
					((Button)getComponentById(42)).setText(Saving.loadKey(Saving.SAVE_2, "username"));
				}
				
				break;
			case 39: // Quit
				System.exit(0);
				break;
			case 40: // Save 1
				Saving.currentSave = Saving.SAVE_0;
				component.setSelected(true);
				getComponentById(41).setSelected(false);
				getComponentById(42).setSelected(false);
				
				getComponentById(44).setDisabled(false);
				getComponentById(45).setDisabled(false);
				break;
			case 41: // Save 2
				Saving.currentSave = Saving.SAVE_1;
				component.setSelected(true);
				getComponentById(40).setSelected(false);
				getComponentById(42).setSelected(false);
				
				getComponentById(44).setDisabled(false);
				getComponentById(45).setDisabled(false);
				break;
			case 42: // Save 3
				Saving.currentSave = Saving.SAVE_2;
				component.setSelected(true);
				getComponentById(40).setSelected(false);
				getComponentById(41).setSelected(false);
				
				getComponentById(44).setDisabled(false);
				getComponentById(45).setDisabled(false);
				break;
			case 43: // menu
				mainMenu = new MainMenuState(game);
				State.setState(mainMenu);
				break;
			case 44: // play
				
				gameState = new GameState(game);
				State.setState(gameState);
				break;
			case 45: // delete
				if (Saving.currentSave == Saving.SAVE_0) {
					getComponentById(40).setDisabled(true);
					getComponentById(40).setSelected(false);
					((Button) getComponentById(40)).setText("Empty");
				} else if (Saving.currentSave == Saving.SAVE_1) {
					getComponentById(41).setDisabled(true);
					getComponentById(41).setSelected(false);
					((Button) getComponentById(41)).setText("Empty");
				} else if (Saving.currentSave == Saving.SAVE_2) {
					getComponentById(42).setDisabled(true);
					getComponentById(42).setSelected(false);
					((Button) getComponentById(42)).setText("Empty");
				}
				
				Saving.deleteSave(Saving.currentSave);
				Saving.currentSave = null;
				
				getComponentById(44).setDisabled(true);
				getComponentById(44).setHovered(false);
				getComponentById(45).setDisabled(true);
				getComponentById(45).setHovered(false);
				
				if (Saving.available(Saving.SAVE_0) && Saving.available(Saving.SAVE_1) &&
						Saving.available(Saving.SAVE_2)) {
					
					mainMenu = new MainMenuState(game);
					State.setState(mainMenu);
				}
				break;
			}
		}
	}
	
	public void deleteSave() {
	}
	
	public void addComponent(Component component) {
		
		components.add(component);
	}
	
	public void removeComponent(int componentId) {
		
		for (Component c : components) {
			
			if (c != null) {
				
				if (c.getId() == componentId)
					components.remove(c);
			}
		}
	}
	
	public Component getComponentById(int componentId) {
		
		for (Component c  : components) {
			
			if (c != null) {
				
				if (c.getId() == componentId)
					return c;
			}
		}
		
		return null;
	}
	
	public List<Component> getComponents() {
		
		return components;
	}
	
	public void addExiledComponent(Component component) {
		
		exiledComponents.add(component);
	}
	
	public List<Component> getExiledComponents() {
		
		return exiledComponents;
	}
	
	public int getStage() {
		
		return stage;
	}
	
	public void setStage(int stage) {
		
		this.stage = stage;
	}
}