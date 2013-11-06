import java.io.*;
import java.util.*;

public class Ogre extends Character {

    private String weapon;
    private boolean hasWeapon, isPlayer;

    // if the classes want the ogre to be a possible player class, we can use this constructor to give an option
    public Ogre(String name, boolean playable) {
	super(name,10,6,3,playable);
	isPlayer = playable;
	if (isPlayer) {
		weapon = "Club";
		hasWeapon = true;
	    }
	else {
	    weapon();
	}
    }

    public Ogre(String name) {
	super(name,10,6,3,false);
	isPlayer = false;
	weapon();
    }

    public Ogre() {
	super("Ogre",10,6,3,false);
	isPlayer = false;
	weapon();
    }

    // some ogres might have weapons
    public void weapon() {
	if (Math.random() < .5) {
	    weapon = "Club";
	    hasWeapon = true;
	}
	else {
	    weapon = "None";
	    hasWeapon = false;
	}
    }

    public void attack(Character other) {
	if (isPlayer) {
	    // if the ogre is a player, the player will be given the option of how he wants to fight
	    // but if the ogre is only a NPC class, we can just get rid of this part
	      Random r = new Random();
	      Scanner sc = new Scanner(System.in);
	      int dex = dexterity;
	      int mult = 1;
	      int x = r.nextInt(6) + 1, y = r.nextInt(6) + 1, z = r.nextInt(6) + 1;
	      System.out.println("\nChoose your weapon:\n1 - Club\n2 - Fists");
	      System.out.print(">");
	      int weapon = sc.nextInt();
	      if (weapon == 1) {
		  dex = dexterity - 2;
		  mult = 3;
	      }
	      else if (weapon == 2) {
		  dex = dexterity + 3;
		  mult = 1;
	      }
	      if (x+y+z <= dex) {
		  int dmg = damageDone(other, mult);
		  other.loseHealth(dmg);
		  System.out.println("\n" + name + " did " + dmg + " damage to " + other + "!");
	      }
	      else {
		  System.out.println("\n" + name + " missed!");
	      }
	}
	else { // ogre is an NPC
	    if (hasWeapon) {
		Random r = new Random();
		int dex = dexterity;
		int mult = 1;
		int x = r.nextInt(6) + 1, y = r.nextInt(6) + 1, z = r.nextInt(6) + 1;
		dex = dexterity - 2;
		mult = 3;
		if (x+y+z <= dex) {
		    int dmg = damageDone(other, mult);
		    other.loseHealth(dmg);
		    System.out.println("\n" + name + " did " + dmg + " damage to " + other + "!");
		}
		else {
		    System.out.println("\n" + name + " missed!");
		}
	    }
	    else {
		super.attack(other);
	    }
	}
    }

}
	      
	      
	      
	      
