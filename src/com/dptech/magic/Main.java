package com.dptech.magic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.dptech.magic.counter.Counter;

public class Main implements Runnable, MouseListener{
	
	private Display display;
	
	private boolean running = false;
	public int width, height;
	public String title;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	private BufferedImage bm = null;
	
	Counter counter;
	
	public Main(String title, int height, int width){
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	public void init(){
		display = new Display(title, width, height);
		counter = new Counter(width / 2, height / 2);
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if (!running) {
			return;
		}
		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();
		
		while(running){
			render();
		}
		
		stop();
	}
	
	
	public void render(){
		
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		//g.setColor(Color.BLUE);
		//g.setFont(new Font("Arial", Font.PLAIN, 80));
		//g.drawString("20", width / 2 - (80 / 2), height / 2);
		
		
		counter.render(g);
		
		bs.show();
		g.dispose();
		
	}
	
	public static BufferedImage newColor(BufferedImage image, int R, int G, int B){
		int width = image.getWidth();
		int height = image.getHeight();
		
		WritableRaster raster = image.getRaster();
		
		   for (int xx = 0; xx < width; xx++) {
	            for (int yy = 0; yy < height; yy++) {
	                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
	                pixels[0] = R;
	                pixels[1] = G;
	                pixels[2] = B;
	                raster.setPixel(xx, yy, pixels);
	            }
	        }
		
		return image;
		
	}
	
	
}
