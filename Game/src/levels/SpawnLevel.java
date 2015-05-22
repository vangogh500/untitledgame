package levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import levels.tile.Tile;

public class SpawnLevel extends Level {
		
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception: Could not load spawn level file");
		}
	}
	
	
	//Grass = 79bf1d
	//Grass_Dirt_N = bede2c
	//Grass_Dirt_NE = dc5173
	//Grass_Dirt_SW = b82535
	//Grass_Dirt_E = ff9fb6
	//Grass_Dirt_S = b3b3b3
	//Grass_Dirt_NW = 4f4f4f
	
	//Grass_Flower = ffffff
	//Grass_Long = 1e5537
	
	//Dirt = 8c5c4d
	
	//Spawn = 004c73
	protected void generateLevel() {
	}
}
