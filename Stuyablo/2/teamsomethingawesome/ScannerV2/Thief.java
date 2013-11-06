import java.io.*;
import java.util.*;

public class Thief extends Character {/*added by Matthew*/
    public Thief() {
	health=9;
	maxhealth=9;
	dexterity=14;
	strength=9;
	intelligence=8;
    }
    public void attack(Character other) {
	Random r= new Random();
	int roll=r.nextInt(18); /*three six-sided die roll implementation by Matthew*/
	if ( 2*roll < dexterity) {
	    System.out.println("A critical hit!!!");
	    loseHealth(other,strength*2);
	}
	else if (roll < dexterity) {
	    System.out.println("A hit!");
	    loseHealth(other,strength);
	    /* do the attack:
               print out the attempt and the result and update
               all relavent variables
	    */
	}
	else {
	    System.out.println("A miss...");
	 
	}
    }
}