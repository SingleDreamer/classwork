import java.util.*;
import java.io.*;
import java.math.*;

Public Teacher extends Character {
    
    ///////////// randomly distribute points////////////////////////////
    public void distribute(level) {
    	int pointsleft = level * 1 + 8;

    	while (pointsleft > 0) {
	    Random group = new Random();
	    int roundgroup = group.nextInt(2)+1; /*if roundgroup = 1,
    					      add point to dex
    					      if roundgroup = 2
    					      add point to strength 
					      if roundup = 3
					      add point to int */
	    if (roundgroup = 1)
		dexterity++;
	    if (roundgroup = 2)
		strength++;
	    if (roundgroup = 3)
		intelligence++;
		
	    pointsleft = pointsleft - 1;
	    }
    }

    
    public Teacher(String name1, int levelh){
	name = name1;
	distribute(levelh);
	hp = strength;
	mp = strength;
    }

}
