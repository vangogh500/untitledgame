package gfx;

import java.util.Random;

import levels.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	
	public int[] tiles = new int[64*64];
	
	public int xOffset, yOffset;
	
	private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		
		for (int i = 0; i < 64*64; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp = xp - xOffset;
		yp = yp - yOffset;
		for (int y = 0; y < tile.sprite.HEIGHT; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.WIDTH; x++) {
				int xa = x+xp;
				if(xa < -tile.sprite.WIDTH || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.WIDTH];
			}	
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		xp = xp - xOffset;
		yp = yp - yOffset;
		for (int y = 0; y < 18; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3)  ys = 17 - y;
			for (int x = 0; x < 16; x++) {
				int xa = x+xp;
				int xs = x;
				if(flip == 1 || flip == 3) xs = 15 - x;
				if(xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if(xa < 0) xa = 0;
				int col = sprite.pixels[xs+ys*16];
				if(col != 0xff271443) pixels[xa+ya*width] = col;
			}	
		}
	}
	
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
