package levels.tile;

import gfx.Screen;
import gfx.Sprite;

public class LongGrassTile extends Tile {

	public LongGrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
