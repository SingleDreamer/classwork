import java.io.*;
import java.util.*;
public class Ogre extends Character{
    Random r = new Random();
    public Ogre(){
	maxhealth = 14 + (r.nextInt(4) - 2);
	health = maxhealth;
	strength = 8 + (r.nextInt(4) - 2);
	dexterity = 10 + (r.nextInt(4) - 2);
	intelligence = 5 + (r.nextInt(4) - 2);
	damage = strength;
	experience = 10;
	gold = 10;
	name = "Steve the Ogre";
    }
    public void attack(Character other) {
        h.pause();
        Random r= new Random();
        int roll=r.nextInt(6) + r.nextInt(6)+ r.nextInt(6)+3; /*three six-sided die roll implementation by Matthew*/
        if (roll < this.getDex()) {
            System.out.println("A hit!");
            loseHealth(other,damage);
            /* do the attack:
               print out the attempt and the result and update
               all relavent variables
	    */
        }
        else {
            System.out.println("The ogre missed...\n---------------------------------------------------------------");
        }
    }

}

