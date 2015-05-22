package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int HEIGHT;
	public final int WIDTH;
	public int[] pixels;
	
	public static SpriteSheet test = new SpriteSheet("/textures/testsheet.png", 256, 208);
	public static SpriteSheet player = new SpriteSheet("/textures/character.png",144,72);
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.WIDTH = width;
		this.HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		loadImage();
	}
	
	private void loadImage() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
