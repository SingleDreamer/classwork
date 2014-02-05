import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.Color.*;


public class Shape{
    private Color color;
    private Color insidecolor;
    private boolean hasDots = false;
    private int points;
    private boolean filledIn = false;
    private boolean dimension = false;
    public Color[] c = {Color.GREEN,Color.BLUE,Color.MAGENTA,Color.BLACK,Color.CYAN};
    
    public Shape(){
        Random r = new Random();
        points = 3 + r.nextInt(5);
        int p = r.nextInt(5);
        color = c[p];
        insidecolor = c[r.nextInt(5)];
        if (r.nextInt(2) == 0)
            filledIn = true;
        if (r.nextInt(2) == 0)
            hasDots = true;
        if (r.nextInt(2) == 0)
            dimension = true;
        }
    
    public int getPoints(){
        return points;
    }
    
    public Color getColor(){
        return color;
    }
    public Color getInsideColor(){
        return insidecolor;
    }
    public boolean getFilled(){
        return filledIn;
    }
    public boolean getDots(){
        return hasDots;
    }
    public boolean get3d (){
        return dimension;
    }
}
        
