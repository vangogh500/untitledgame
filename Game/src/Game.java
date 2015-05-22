import input.Keyboard;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import levels.Level;
import levels.SpawnLevel;
import entity.mob.Player;
import gfx.Screen;


public class Game extends Canvas implements Runnable {

	private Level map;
	
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 300;
	public static int HEIGHT =  WIDTH / 16 * 9;
	public static int SCALE = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	private Player player;
	
	private Screen screen;
	private Keyboard key;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		map = new SpawnLevel("/textures/levels/spawn.png");

		
		Dimension size = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
		setPreferredSize(size);
		
		screen = new Screen(WIDTH, HEIGHT);
		
		frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		key = new Keyboard();
		player = new Player(key);
		addKeyListener(key);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double nsPerUpdate = 1000000000D / 60D;
		double delta = 0;
		
		int frames = 0;
	
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerUpdate;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			frames++;
			render();
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle("Game" + " | " + frames + " fps");
				frames = 0;	
			}
		}
	} 
	
	public void update() {
		key.update();
		player.update();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		map.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for(int i=0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
