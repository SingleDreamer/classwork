import java.io.*;
import java.util.*;

public class Grid {

    private char[][][] grid;

    public Grid(width,depth,height) {
	grid = new char[width][depth][height];
    }

    /*
    preconditions:
    parameter orientation determines the orientation of the plane on which the rectangle will be drawn: top (x and y), front (x and z), or right (y and z)
    parameter crosssection determines how deep into the grid the rectangle will be drawn (e.g. orientation "top" and crosssection 1 will draw a rectangle just under the top surface of the grid, since crosssection 0 is the very top)
    parameters s and name the first point of the rectangle on the desired plane (e.g. s 2 and p 4 with orientation "front" and crosssection 3 will make the first corner grid[2][3][4]
    note: determine the x, y, and z values by correlating the s and p inputs with the axes of the desired plane and then filling the remainig value (whichever of x, y, and z hasn't been thus filled) with the crosssection input
    parameters side1 and side2 can be negative; they will determine lines which extend from the given s and p values (e.g. in the former example, with s 2 and p 4, side1 of 5 and side2 of 1 will determine the remaining 3 points of the grid: grid[7][3][4], grid[2][3][5], and grid[7][3][5]

    postcondition:
    the method will create a rectangle on the desired plane by determining all the blocks on the grid which need to be filled (with a character)
    */
    public void makeRectangle(String orientation, int crosssection, int s, int p, int side1, int side2) {
    }


    /*preconditions:
    parameters x, y, and z name one corner of the prism
    parameters width, depth, and height can be positive or negative: the former to extend right, forwards, and upwards from the given corner; the latter to extend left, backwards, and downwards from the given corner
    */
    public void makeRectPrism(int x, int y, int z, int width, int depth, int height) {
    }

    

}
