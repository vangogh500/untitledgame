package entity.mob;

import gfx.Screen;
import gfx.Sprite;
import input.Keyboard;

public class Player extends Mob{
	
	Keyboard input;
	Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if(anim < 7500) anim++;
		else anim = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) { 
			walking = true;
			move(xa,ya);
		}
		else walking = false;
	}
	
	public void render(Screen screen) {
		int flip = 0;
		if(dir == 0) {
			sprite = Sprite.player_up;
			if(walking) {
				if(anim % 30 > 15) {
					sprite = Sprite.player_up_1;
				}
				else sprite = Sprite.player_up_2;
			}	
		}
		if(dir == 1 || dir == 3) {
			sprite = Sprite.player_right;
			if(walking) {
				if(anim % 30 > 15) {
					sprite = Sprite.player_right_1;
				}
				else sprite = Sprite.player_right_2;
			}	
		}
		if(dir == 2) {
			sprite = Sprite.player_down;
			if(walking) {
				if(anim % 30 > 15) {
					sprite = Sprite.player_down_1;
				}
				else sprite = Sprite.player_down_2;
			}	
		}
		if(dir == 3) flip = 1;	
		screen.renderPlayer(x - 8, y - 9, sprite, flip);
	}
	
}
