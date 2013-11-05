import java.util.*;
import java.io.*;

public class Ogre extends Character{
    int expGiven;
    int goldGiven;
    public Ogre(){
	strength=11;
	dexterity=6;
	intelligence=3;
	expGiven=11;
	goldGiven=11;
    }
    public void giveStats(Character other){
	other.setExp(expGiven);
	other.setGold(goldGiven);
    }
    public void attack(Character other) {
        Random r= new Random();
        int roll=r.nextInt(6) + r.nextInt(6)+ r.nextInt(6); /*three six-sided die roll implementation by Matthew*/
        if (roll < this.getDex()) {
            System.out.println("A hit!");
            loseHealth(other,damage);
            /* do the attack:
               print out the attempt and the result and update
               all relavent variables
	    */
        }
        else {
            System.out.println("A miss...");
        }
    }
    public boolean flee(Character other) {
	Random r= new Random();
        if ( r.nextInt(6)+ r.nextInt(6) +r.nextInt(6) < other.getDex()){ // if the sum of the outcomes of four dice is less than your dexterity, then you escape.
		return true;
	    }
	    else {
		return false;
	    }
	    
	
    
    }
}

