import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.Color.*;
import java.awt.Graphics2D.*;
import java.awt.geom.*;


public class draw extends JPanel{
    private Shape[] s = new Shape[30];
    private Random r = new Random();
    public void drawing(){
        setBackground(Color.darkGray);
        setPreferredSize( new Dimension( 630, 800 ) );       
        //stackoverflow
        repaint();
    }

    public void paintComponent(Graphics g2){
        for (int i = 0; i < 30; i++){
            s[i] = new Shape();
        }        
        Graphics2D g = (Graphics2D)g2;
        super.paintComponent(g);
        int x = 40;
        int y = 40;
        int z = 0;
        Point central = new Point(0,0);
        for (int i = 0; i < 6; i ++){
            for (int j = 0; j < 5; j++){
                central.x = x + 40;
                central.y = y + 40;
                g.setPaint(Color.WHITE);
                g.drawString((""+(z+1)),x,y-6);
                if (s[z].getDashed()){
                    Stroke stroke = new BasicStroke(5,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER,10.0f, new float[] { 12, 12}, 0);
                     g.setStroke(stroke);
                }
                else{ 
                    Stroke stroke = new BasicStroke(5);
                    g.setStroke(stroke);
                }
                    
                Color c = s[z].getColor();
                Color ic = s[z].getInsideColor();
                int points = s[z].getPoints();
                if (s[z].getFilled() && s[z].getGradient()){
                    if (points == 7){
                    GradientPaint ll = new GradientPaint(x,y, Color.gray, x+10,y+10, ic, true);
                    g.setPaint(ll);
                    g.fillOval(x,y,80,80);
                    g.setPaint(c);
                    g.drawOval(x,y,80,80);
                    }    
                    if (points == 4){
                        GradientPaint ll = new GradientPaint(x,y, Color.gray, x+10,y+10, ic, true);
                        g.setPaint(ll);
                        g.fillRect(x,y,80,80);
                        g.setPaint(c);
                        g.drawRect(x,y,80,80);
                    }
                    if (points == 3){
                        Polygon p = new Polygon();
                        p.addPoint(x,y+80);
                        p.addPoint(x+40,y);
                        p.addPoint(x+80,y+80);
                        GradientPaint ll = new GradientPaint(x,y, Color.gray, x+10,y+10, ic, true);
                        g.setPaint(ll);
                        g.fillPolygon(p);
                        g.setPaint(c);
                        g.drawPolygon(p);
                    }            
                    if (points == 6){
                        Polygon hex = new Polygon();
                        for (int m = 0; m < 6; m++) {
                            hex.addPoint((int) (x + (45 * Math.cos(m * 2 * Math.PI / 6)) + 40),
                                         (int) (y + (45 * Math.sin(m * 2 * Math.PI / 6)) + 40));
                        }
                        GradientPaint ll = new GradientPaint(x,y, Color.gray, x+10,y+10, ic, true);
                        g.setPaint(ll);
                        g.fillPolygon(hex);
                        g.setPaint(c);
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
                               GradientPaint ll = new GradientPaint(x,y, Color.gray, x+10,y+10, ic, true);
                        g.setPaint(ll);
                        g.fillPolygon(penta);
                        g.setPaint(c);
                        g.drawPolygon(penta);
                    }
                }




                else if (s[z].getFilled()){
                    if (points == 7){
                        g.setPaint(ic);
                        g.fillOval(x,y,80,80);
                        g.setPaint(c);
                        g.drawOval(x,y,80,80);
                    }    
                    if (points == 4){
                        g.setPaint(ic);
                        g.fillRect(x,y,80,80);
                        g.setPaint(c);
                        g.drawRect(x,y,80,80);
                    }
                    if (points == 3){
                        Polygon p = new Polygon();
                        p.addPoint(x,y+80);
                        p.addPoint(x+40,y);
                        p.addPoint(x+80,y+80);
                        g.setPaint(ic);
                        g.fillPolygon(p);
                        g.setPaint(c);
                        g.drawPolygon(p);                    
                    }            
                    if (points == 6){
                        Polygon hex = new Polygon();
                        g.setPaint(ic);
                        for (int m = 0; m < 6; m++) {
                            hex.addPoint((int) (x + (45 * Math.cos(m * 2 * Math.PI / 6)) + 40),
                                         (int) (y + (45 * Math.sin(m * 2 * Math.PI / 6)) + 40));
                        }
                        g.fillPolygon(hex);
                        g.setPaint(c);
                        g.drawPolygon(hex);
                        
                    }
                    
                    if (points == 5){
                        Polygon penta = new Polygon();
                        penta.addPoint(x,y+40);
                        penta.addPoint(x,y+80);
                        penta.addPoint(x+80,y+80);
                        penta.addPoint(x+80,y+40);
                        penta.addPoint(x+40,y);
                        g.setPaint(ic);
                        g.fillPolygon(penta);
                        g.setPaint(c);
                        g.drawPolygon(penta);
                    }
                }
                else{
                    g.setPaint(c);
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
                    g.setPaint(Color.red);
                    g.fillOval(central.x, central.y, 5, 5);
                    g.fillOval(central.x + 10, central.y, 5, 5);
                    g.fillOval(central.x, central.y + 10, 5, 5);
                    g.fillOval(central.x - 10, central.y , 5, 5);
                    g.fillOval(central.x, central.y - 10, 5, 5);
                    g.fillOval(central.x + 7, central.y + 7, 5, 5);
                    g.fillOval(central.x + 7, central.y - 7, 5, 5);
                    g.fillOval(central.x - 7, central.y - 7, 5, 5);
                    g.fillOval(central.x - 7, central.y + 7, 5, 5);
                }  
                x = x + 120;
                z = z + 1;
            }
            y = y + 120;
            x = 40;
            //got the code for the hexagon from Stack Overflow
        }
    }
    public Shape getRandomShape(){
        return s[r.nextInt(30)];
    }
}
