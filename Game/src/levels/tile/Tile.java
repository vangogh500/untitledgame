package levels.tile;

import gfx.Screen;
import gfx.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	
	public static Tile grass_long = new LongGrassTile(Sprite.grass_long);
	public static Tile grass_flower = new GrassTile(Sprite.grass_flower);
	
	public static Tile grass_dirt_nw = new GrassDirtTile(Sprite.grass_dirt_nw);
	public static Tile grass_dirt_n = new GrassDirtTile(Sprite.grass_dirt_n);
	public static Tile grass_dirt_ne = new GrassDirtTile(Sprite.grass_dirt_ne);
	public static Tile grass_dirt_e = new GrassDirtTile(Sprite.grass_dirt_e);
	public static Tile grass_dirt_sw = new GrassDirtTile(Sprite.grass_dirt_sw);
	public static Tile grass_dirt_s = new GrassDirtTile(Sprite.grass_dirt_s);
	public static Tile dirt = new DirtTile(Sprite.dirt);
	
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return false;
	}
}
