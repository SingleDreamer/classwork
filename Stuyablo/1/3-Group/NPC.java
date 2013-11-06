import java.io.*;
import java.util.*;

public class NPC extends Character{
    
    public NPC(){
	dexterity = 6;
	strength = 6;
	intelligence = 6;
	Random r = new Random();
	strength = strength + r.nextInt(3);
	dexterity = dexterity + r.nextInt(3);
	intelligence = intelligence + r.nextInt(3);
	health = 50 + ((strength - 8)*4);
    }
    
    public boolean adjacentCheck(PC other){
	boolean o = false;
	if (x == other.x && ((y + 1 == other.y) || (y - 1 == other.y)))
	    o = true;
	if (y == other.y && ((x + 1 == other.x) || (x - 1 == other.x)))
	    o = true;
	return o;
    }
    
    public void turn (PC other){
	int move = 2;
	while (move > 0 && !adjacentCheck(other)){ // while there are still moves and pc isn't next to npc
	    Random r = new Random();
	    int z = r.nextInt(2);
	    if (z == 0 && (x != other.x)){
		if (other.x > x)
		    x = x + 1;
		else
		    x = x - 1;
	    }
	    if (z == 1 && (y != other.y)){
		if (other.y > y)
		    y = y + 1;
		else
		    y = y - 1;
	    }
	}
    }
}

