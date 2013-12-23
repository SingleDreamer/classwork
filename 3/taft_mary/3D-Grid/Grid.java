import java.io.*;
import java.util.*;

public class Grid {

    private char[][][] grid;

    public Grid(int width, int depth, int height) {
	grid = new char[width][depth][height];
    }
    //left-back-bottom corner is (0,0,0)
    //right-front-top corner is (width,depth,height)

    /*
    preconditions:
    parameter orientation determines the orientation of the plane on which the rectangle will be drawn: top (x and y), front (x and z), or [right] side (y and z)
    parameter layer determines how deep into the grid the rectangle will be drawn (e.g. orientation "top" and crosssection 1 will draw a rectangle just under the bottom surface of the grid, since layer 0 is the very bottom)
    parameters s and name the first point of the rectangle on the desired plane (e.g. s 2 and p 4 with orientation "front" and layer 3 will make the first corner grid[2][3][4]
    note: determine the x, y, and z values by correlating the s and p inputs with the axes of the desired plane and then filling the remainig value (whichever of x, y, and z hasn't been thus filled) with the layer input
    parameters side1 and side2 can be negative; they will be used to determine the remaining corners of the rectangle by extending from the given s and p values (e.g. in the former example, with s 2 and p 4, side1 of 5 and side2 of -2 will determine the remaining 3 points of the grid: grid[6][3][4], grid[2][3][3], and grid[6][3][3] --> in other words, add 1 less than the absolute value of the parameter in the direction determined by the sign (since having a side lengh of 2 means extending 1 from the preexisting corner point))

    postcondition:
    the method will create a rectangle on the desired plane by determining all the blocks on the grid which need to be filled (with a character)
    */
    public void makeRectangle(String orientation, int layer, int s, int p, int side1, int side2) {
	//there must be a way to refactor this
	int x=0,y=0,z=0,x1=0,y1=0,z1=0;
	//had to initialize for the compiler...
	if (orientation.equals("top")) {
	    x = s;
	    y = p;
	    z = layer;
	    if (side1>=0)
		x1 += side1-1;
	    else
		x1 -= side1+1;
	    if (side2>0)
		y1 += side2-1;
	    else
		y1 -= side2+1;
	    z1 = z;
	}
	else if (orientation.equals("front")) {
	    x = s;
	    y = layer;
	    z = p;
	    if (side1>=0)
		x1 += side1-1;
	    else
		x1 -= side1+1;
	    y1 = y;
	    if (side2>0)
		z1 += side2-1;
	    else
		z1 -= side2+1;
	}
	else if (orientation.equals("side")) {
	    x = layer;
	    y = s;
	    z = p;
	    x1 = x;
	    if (side1>=0)
		y1 += side1-1;
	    else
		y1 -= side1+1;
	    if (side2>0)
		z1 += side2-1;
	    else
		z1 -= side2+1;
	}
	else {
	    //handle invalid input
	}
	if (x1>=x) {
	    for (int i=x; i<=x1; i++) {
		if (y1>=y) {
		    for (int j=y; j<=y1; j++) {
			if (z1>=z) {
			    for (int k=z; k<=z1; k++) {
				grid[i][j][k] = 'o';
			    }
			} else {
			    for (int k=z; k<=z1; k--) {
				grid[i][j][k] = 'o';
			    }
			}
		    }
		} else {
		    for (int j=y; i>=y1; j--) {
			if (z1>=z) {
			    for (int k=z; k<=z1; k++) {
				grid[i][j][k] = 'o';
			    }
			} else {
			    for (int k=z; k<=z1; k--) {
				grid[i][j][k] = 'o';
			    }
			}
		    }
		}
	    }
	} else {
	    for (int i=x; i>=x1; i--) {
		if (y1>=y) {
		    for (int j=y; j<=y1; j++) {
			if (z1>=z) {
			    for (int k=z; k<=z1; k++) {
				grid[i][j][k] = 'o';
			    }
			} else {
			    for (int k=z; k<=z1; k--) {
				grid[i][j][k] = 'o';
			    }
			}
		    }
		} else {
		    for (int j=y; i>=y1; j--) {
			if (z1>=z) {
			    for (int k=z; k<=z1; k++) {
				grid[i][j][k] = 'o';
			    }
			} else {
			    for (int k=z; k<=z1; k--) {
				grid[i][j][k] = 'o';
			    }
			}
		    }
		}
	    }
	}	    
    }



    /*preconditions:
    parameters x, y, and z name one corner of the prism
    parameters width, depth, and height can be positive or negative: the former to extend right, forwards, and upwards from the given corner; the latter to extend left, backwards, and downwards from the given corner
    */
    public void makeRectPrism(int x, int y, int z, int width, int depth, int height) {
	//start at the bottom left-hand corner
	//build a rectangle on the horizontal plane
	//multiply that rectangle across all layers of height
	int count = 0;
	while (count<height)
	    makeRectangle("top",z,x,y,width,depth);
    }

    

}
