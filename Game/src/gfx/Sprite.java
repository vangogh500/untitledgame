package gfx;

public class Sprite {
	
	public final int WIDTH;
	public final int HEIGHT;
	
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 16, 3, 0, SpriteSheet.test);
	public static Sprite grass_long = new Sprite(16, 16, 0, 5, SpriteSheet.test);
	public static Sprite grass_flower = new Sprite(16,16,3,4,SpriteSheet.test);
	
	public static Sprite grass_dirt_nw = new Sprite(16,16,0,0,SpriteSheet.test);
	public static Sprite grass_dirt_n = new Sprite(16,16,1,0,SpriteSheet.test);
	public static Sprite grass_dirt_ne = new Sprite(16,16,2,0,SpriteSheet.test);
	public static Sprite grass_dirt_e = new Sprite(16,16,2,1,SpriteSheet.test);
	public static Sprite grass_dirt_se = new Sprite(16,16,2,2,SpriteSheet.test);
	public static Sprite grass_dirt_s = new Sprite(16,16,1,2,SpriteSheet.test);
	public static Sprite grass_dirt_sw = new Sprite(16,16,0,2,SpriteSheet.test);
	public static Sprite dirt = new Sprite(16,16,1,1,SpriteSheet.test);
	public static Sprite voidSprite = new Sprite(16, 16, 0x91FFEA);
	
	public static Sprite player_down = new Sprite(16, 18, 1, 2, SpriteSheet.player);
	public static Sprite player_up = new Sprite(16, 18, 1, 0, SpriteSheet.player);
	public static Sprite player_right = new Sprite(16, 18, 1, 1, SpriteSheet.player);
	
	public static Sprite player_down_1 = new Sprite(16, 18, 0, 2, SpriteSheet.player);
	public static Sprite player_down_2 = new Sprite(16, 18, 2, 2, SpriteSheet.player);
	public static Sprite player_up_1 = new Sprite(16, 18, 0, 0, SpriteSheet.player);
	public static Sprite player_up_2 = new Sprite(16, 18, 2, 0, SpriteSheet.player);
	public static Sprite player_right_1 = new Sprite(16, 18, 0, 1, SpriteSheet.player);
	public static Sprite player_right_2 = new Sprite(16, 18, 2, 1, SpriteSheet.player);
	
	public Sprite(int width, int height, int xPos, int yPos, SpriteSheet sheet) {
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[WIDTH*HEIGHT];
		xPos = xPos * WIDTH;
		yPos = yPos * HEIGHT;
		this.sheet = sheet;
		load(xPos, yPos);
	}
	
	public Sprite(int width, int height, int color) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH*HEIGHT];
		setColor(color);
	}
	
	private void setColor(int color) {
		for(int i = 0; i < WIDTH*HEIGHT; i++) {
			pixels[i] = color;
		}
	}
	
	private void load(int xPos, int yPos) {
		for(int y=0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				pixels[x+y*WIDTH] = sheet.pixels[(x+xPos)+(y+yPos)*sheet.WIDTH];
			}
		}
	}

}
