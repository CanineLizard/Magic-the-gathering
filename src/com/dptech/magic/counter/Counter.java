package com.dptech.magic.counter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.dptech.magic.Main;

public class Counter {
	
	BufferedImage num, downArrow, upArrow;
	public int x, y;
	
	
	int counter = 0;
	
	public Counter (int x, int y){
		try {
			
			//find a way to render two digit or more numbers ... texture class maybe to handle
			//multiple textures 
			
			num = ImageIO.read(new File("C:/Users/acwhi_000/workspace/Magic the gathering/res/Textures/" +  counter + ".png"));
			//downArrow = ImageIO.read(new File(""));
			//upArrow = ImageIO.read(new File(""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		//arrow should be above and below the number texture (height / 2) and (height * 2)
		
		g.drawImage(Main.newColor(num, 255, 255, 255), x, y, null);
		//g.drawImage(downArrow, x, y, null);
		//g.drawImage(upArrow, x, y, null);
		
	}

}
