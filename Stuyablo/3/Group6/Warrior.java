import java.io.*;
import java.util.*;

public class Warrior extends Character {

    public Warrior() {
	dexterity = 6;
	strength = 11;
	health = strength;
	intelligence = 7;
	name = "Warrior";
	charClass = "PC";
    }

    // add and edit encounter method so that the player has the option to try to flee or to attack (using Scanner)

    public void attack(Character other) {
	System.out.println(this.name + " tried to attack " + other.name + ".");
	boolean hitsuccess = this.roll();
	if (hitsuccess == false) {
	    System.out.println("Attack failed.");
	    System.out.println();
	}
	if (hitsuccess == true) {
	    int damage = strength * 3 / 2; // damage is 2/3 that of strength
	    System.out.println("Attack succeeded.");
	    if (other.health <= damage) {
		other.health = 0;
		this.experience += other.experience;
		System.out.println("Opponent defeated.  Experience increased by " + other.experience + "points.");
		System.out.println();
	    }
	    else
		other.setHealth(other.health - damage);
	    System.out.println("Opponent's health has decreased to " + other.getHealth());
	    this.experience += 1;
	    System.out.println("Experience increased by 1 point.");
	    System.out.println();	    
	}
    }

    public boolean flee(Character other) {
	// this doesn't incorporate distance (not yet, anyway)
	if (0.3 > Math.random() && this.dexterity > other.dexterity) // there's a 30% chance this warrior wants to flee, and it will be successful if it's fast enoug
	       return true;
	else
	    return false;
    }

}
