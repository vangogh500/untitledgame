package levels.tile;

import gfx.Screen;
import gfx.Sprite;

public class GrassDirtTile extends Tile {

	public GrassDirtTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
