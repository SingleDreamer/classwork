import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.Color.*;


public class draw extends JPanel{
    private Shape[] s = new Shape[25];
 
    public void drawing(){
	setBackground(Color.darkGray);
	repaint();
    }

    public void paintComponent(Graphics g){
	for (int i = 0; i < 25; i++){
	    s[i] = new Shape();
	}
	super.paintComponent(g);
	int x = 40;
	int y = 40;
	int z = 0;
	Point central = new Point(0,0);
	for (int i = 0; i < 5; i ++){
	    for (int j = 0; j < 5; j++){
		central.x = x + 40;
		central.y = y + 40;
		g.setColor(Color.WHITE);
		g.drawString((""+(z+1)),x,y-3);
		Color c = s[z].getColor();
		g.setColor(c);
		int points = s[z].getPoints();
		if (s[z].getFilled()){
		    if (points == 7){
		    g.drawOval(x,y,80,80);
		    g.fillOval(x,y,80,80);
		    }    
		    if (points == 4){
			g.fillRect(x,y,80,80);
		    }
		    if (points == 3){
			Polygon p = new Polygon();
			p.addPoint(x,y+80);
			p.addPoint(x+40,y);
			p.addPoint(x+80,y+80);
			g.fillPolygon(p);
		    }
			    
			    
		    if (points == 6){
			Polygon hex = new Polygon();
			g.setColor(c);
			for (int m = 0; m < 6; m++) {
			    hex.addPoint((int) (x + (45 * Math.cos(m * 2 * Math.PI / 6)) + 40),
					 (int) (y + (45 * Math.sin(m * 2 * Math.PI / 6)) + 40));
			}
			g.drawPolygon(hex);
			g.fillPolygon(hex);
			
		    }
		    
		    if (points == 5){
			Polygon penta = new Polygon();
			penta.addPoint(x,y+40);
			penta.addPoint(x,y+80);
			penta.addPoint(x+80,y+80);
			penta.addPoint(x+80,y+40);
			penta.addPoint(x+40,y);
			g.fillPolygon(penta);
		    }
		}
		else{
		    if (points == 7){
		    g.drawOval(x,y,80,80); 
		    }    
		    if (points == 3){
			Polygon p = new Polygon();
			p.addPoint(x,y+80);
			p.addPoint(x+40,y);
			p.addPoint(x+80,y+80);
			g.drawPolygon(p);
		    }
		    if (points == 4){
			g.drawRect(x,y,80,80);
		    }
		    if (points == 6){
			Polygon hex = new Polygon();
			for (int m = 0; m < 6; m++) {
			    hex.addPoint((int) (x  + 40 + (45 * Math.cos(m * 2 * Math.PI / 6))),
					 (int) (y + 40 + (45 * Math.sin(m * 2 * Math.PI / 6))));
			}
			g.drawPolygon(hex);
		    }
		    if (points == 5){
			Polygon penta = new Polygon();
			penta.addPoint(x,y+40);
			penta.addPoint(x,y+80);
			penta.addPoint(x+80,y+80);
			penta.addPoint(x+80,y+40);
			penta.addPoint(x+40,y);
			g.drawPolygon(penta);
			
		    }
		}
		if (s[z].getDots()){
		    Random m = new Random();
		    g.setColor(Color.RED);
		    g.fillOval(central.x, central.y, 5, 5);
		    g.fillOval(central.x + 10 , central.y, 5, 5);
		    g.fillOval(central.x , central.y + 10, 5, 5);
		    g.fillOval(central.x - 10 , central.y , 5, 5);
		    g.fillOval(central.x , central.y - 10, 5, 5);
		}  
		x = x + 120;
		z = z + 1;
	    }
	    y = y + 120;
	    x = 40;
	    //got the code for the hexagon from Stack Overflow
	}
    }
}
