import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;

//Timer mainTimer;
//private Map map;

public class Bomberman extends JFrame{
    int GridW = 31;
    int GridH = 31;
    
    public Bomberman(){
	//mainTimer = new Timer(10,this);
	
	ImageIcon grass = new ImageIcon("grass.png");
	ImageIcon stone = new ImageIcon("stone.png");
	JPanel grid = new JPanel();
	grid.setLayout(new GridLayout(GridW,GridH));
	for (int i =0; i < GridW; i++){
	    for (int n = 0; n <GridH; n++){
		if ((n % 2 == 0) && (i % 2 == 0))
		    grid.add(new JLabel(stone));
		else
		    grid.add(new JLabel(grass));
	    }
	}


	//sets up window
	JFrame frame = new JFrame("Bomberman");
	this.setTitle("Bomberman");
        this.setSize(800,800);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(grid);
	this.setResizable(false);
     	this.setVisible(true);
    }

    /*    public void actionPerformed(ActionEvent arg0){
	this.update(this.getGraphics());
	}*/

    public static void main(String[] args){
	//Bomberman b = new Bomberman();
	Map map = new Map("map.txt",32);
    }
}


  
