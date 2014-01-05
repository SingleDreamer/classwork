import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class Map{
    private int x;
    private int y;
    private int width;
    private int height;
    private int tSize;
    private int[][] map;

    public Map(String s, int tileSize){
	tSize = tileSize;
	try{
	    BufferedReader b = new BufferedReader(new FileReader(s));
	    width = Integer.parseInt(b.readLine());
	    height = Integer.parseInt(b.readLine());
	    map = new int[height][width];
	    for(int row = 0; row < height; row++){
		String line = b.readLine();
		String[] space = line.split(" ");
		for(int col = 0; col < width; col++){
		    map[row][col] = Integer.parseInt(space[col]);
		}
	    }
	}
	catch(Exception e){}
    }

    public void draw(Graphics2D g){
	try{
	    File gfile = new File("grass.png");
	    BufferedImage grass = ImageIO.read(gfile);
	    File sfile = new File("stone.png");
	    BufferedImage stone = ImageIO.read(sfile);
	    File dsfile = new File("dstone.png");
	    BufferedImage dstone = ImageIO.read(dsfile);	
	    for(int row = 0; row < height; row++){
		for(int col = 0; col < width; col++){
		    int tile = map[row][col];
		    if(tile == 0)
			g.drawImage(grass,null,x + col, y + row);
		    if(tile == 1)
			g.drawImage(stone,null,x + col, y + row);
		    if(tile == 3)
			g.drawImage(dstone,null,x + col, y + row);
		    //	g.fillRect(x + col * tSize, y + row * tSize, tSize, tSize);
		}
	    }
	}
	catch(Exception e){}
    }
}

