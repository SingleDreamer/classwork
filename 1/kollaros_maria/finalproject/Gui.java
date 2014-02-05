import java.util.*;
import java.io.*;
import javax.swing.*;

//used youtude tutorial for assistance to set up the basic paint and graphics

public class Gui{
    public static void main(String[] args){
	JFrame frame = new JFrame("Test");
	frame.setVisible(true);
	frame.setSize(800,800);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	draw object = new draw();
	frame.add(object);
	object.drawing();
    }
}

