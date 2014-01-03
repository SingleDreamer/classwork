import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.Color.*;


public class Shape{
    private Color color;
    private boolean hasDots = false;
    private int points;
    private boolean filledIn = false;
    public Color[] c = {Color.GREEN,Color.BLUE,Color.MAGENTA,Color.BLACK,Color.CYAN};
    
    public Shape(){
	Random r = new Random();
	points = 3 + r.nextInt(5);
	int p = r.nextInt(5);
	color = c[p];
	if (r.nextInt(2) == 0)
	    filledIn = true;
	if (r.nextInt(2) == 0)
	    hasDots = true;
	}
    
    public int getPoints(){
	return points;
    }
    
    public Color getColor(){
	return color;
    }
    
    public boolean getFilled(){
	return filledIn;
    }
    public boolean getDots(){
	return hasDots;
    }
}
	
	
