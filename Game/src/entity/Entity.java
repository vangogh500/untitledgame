package entity;

import gfx.Screen;

import java.util.Random;

import levels.Level;

public abstract class Entity {
	
	public int x, y;
	public boolean removed = false;
	protected Level map;
	protected final Random random = new Random();
	
	public void update() {
	
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
}
