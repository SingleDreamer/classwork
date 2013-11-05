import java.io.*;
import java.util.*;
public class Warrior extends Character{
    public Warrior(){//Richard added
	health = 10;
	maxhealth = 10;
	dexterity = 10;
	strength = 12;
	intelligence = 8;
	name = "Arthur";
	charClass = "Warrior";
    }
    public Warrior(String name, int strAdd, int intAdd, int dexAdd) {
        experience=0;
        gold=0;
        strength=8+strAdd;
        intelligence=8+intAdd;
        dexterity=8+dexAdd;
    }
    public void attack(Character other) {
	Random r=new Random();
	int roll=r.nextInt(18); /*three six-sided die roll implementation by Ma\
				  tthew*/
        if (roll < dexterity) {
            System.out.println("A hit!");
            loseHealth(other,(strength*3)/2);
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