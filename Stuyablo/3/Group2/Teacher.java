import java.util.*;
import java.io.*;

Public Teacher extends Character {
    
    ////////////////////randomly distribute points////////////////////////////
    public void distribute() {
	int pointsleft = 8;
        double group =  math.random ()* 2  + 1; /*random generates 0 - 1 so
						  we have to add 1 to make it 
						  b/c we have 2 vars

						  this is for selecting the 
						  group that gets the point.*/
	while (pointsleft > 0) {
	    int roundgroup = round (group); /*if roundgroup = 1,
					      add point to dex
					      if roundgroup = 2
					      add point to strength */
	    
	}
	
	pointsleft = pointsleft - 1; 
