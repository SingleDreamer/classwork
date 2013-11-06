package Game;
import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	Character c = new Character();
	c = new Archer();
	while (c.getHealth() > 0) {
		Ogre o = new Ogre(c.getLevel() + r.nextInt(2) - 1);
		c.play(o);
	}
    
	System.out.println("You finally died at a level of " + c.getLevel() + "!");
    }
} 
/*
while (c.getHealth() > 0) {
	Enemy NPC appears, you fight, repeats
	Ogre o = new Ogre(c.getLevel() + r.nextInt(20) - 10);
	This will spawn an ogre with a possible level deviation of 10 from you.
	while ((c.getHealth() > 0) && (o.getHealth() > 0)) {
		c.encounter(o); //Fight till one of you drops.
	}
}
*/