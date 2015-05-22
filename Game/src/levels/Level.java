package levels;

import gfx.Screen;
import levels.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
				
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x<0 || y<0 || x >= width || y >= height) return Tile.voidTile;
		if(tiles[x + y * 30] == 0xff79bf1d) return Tile.grass;
		else if(tiles[x + y * width] == 0xffbede2c) return Tile.grass_dirt_n;
		else if(tiles[x + y * width] == 0xffdc5173) return Tile.grass_dirt_ne;
		else if(tiles[x + y * width] == 0xffb82535) return Tile.grass_dirt_sw;
		else if(tiles[x + y * width] == 0xffff9fb6) return Tile.grass_dirt_e;
		else if(tiles[x + y * width] == 0xffb3b3b3) return Tile.grass_dirt_s;
		else if(tiles[x + y * width] == 0xff4f4f4f) return Tile.grass_dirt_nw;
		else if(tiles[x + y * width] == 0xffffffff) return Tile.grass_flower;
		else if(tiles[x + y * width] == 0xff1e5537) return Tile.grass_long;
		else if(tiles[x + y * width] == 0xff8c5c4d) return Tile.dirt;
		else return Tile.voidTile;
	}
	
	private void time() {
		
	}
}
