import java.io.*;
import java.util.*;

public class Ogre extends Character {

public Ogre(int level) {
	charClass = "Ogre";
	name = "Some Ogre";
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	x = r.nextInt(8);
	y = r.nextInt(14);
	/*Since humans have 32 base points after distribution, so will ogres, based entirely off their spawn level, so they will gain a point per level.*/
	strength = 18;
	dexterity = 6;
	intelligence = 0;
	this.level = level;
	for(int i = 0;i < (8 + level);i++) {
		/*8 remaining points randomly distributed (like a human), but none in intelligence, because this is an ogre. 1 more point per level.*/
		if (r.nextInt(2) == 0)
			strength = strength + 1;
		else
			dexterity = dexterity + 1;
		}
	maxhealth = strength;
	health = maxhealth;
	}

public void level(int exp) {
	experience = experience + exp;
	if (experience > experienceneeded) {
		level = level + 1;
		System.out.println("You leveled up to level " + level + "! \nWhere would you like to spend your ability point? \n1. Dexterity \n2. Strength \n3.Intelligence");
		
	
	Scanner s = new Scanner(System.in);
	int i = s.nextInt();
	if (i == 1) {
		dexterity = dexterity + 1;
		experienceneeded = experienceneeded + 5 * (level - 1);
	}
	if (i == 2) {
		strength = strength + 1;
		experienceneeded = experienceneeded + 5 * (level - 1);
	}
	else {
		intelligence = intelligence + 1;
		experienceneeded = experienceneeded + 5 * (level - 1); /*Increases exp needed to level up by 5 per level, so its 10, 15, 25, 40, 60 Consider that you get 10 exp + enemies health per each kill.*/
	}
	maxhealth = strength;
	health = maxhealth; //health regeneration
	}
	

} 
public boolean flee(Character other) {
	int[] a = other.getStat();
	if (health < 12) {
		health = health + 8;
		return true;
	}
	if (distance < 11 || distance > -11)
		return false;
	if (dexterity < a[0])
		return false;
	else
		return true;
	
}

public void attack(Character other) {
	System.out.println(getStatus());
	System.out.println(other.getStatus());
	try {
	    Thread.sleep(2000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
/* do the attack:
	   print out the attempt and the result and update
	   all relavent variables
	*/
	Random r = new Random();
	int roll = r.nextInt(16) + 3;
	if (health == 0) {
		System.out.println("Ogre died.");
	}
	else {
		if (dexterity >= roll) {
		
		other.damage(strength + 3);
		System.out.println("Ogre dealt " + (strength+3) + " damage to its enemy!");
		System.out.println("----------------------------------------------------------------");
		}
		else { 
		System.out.println("Ogre missed!");
		System.out.println("----------------------------------------------------------------");
	}
}
		

	
}
}
/* We do not need this method, but if we ever do, it will be useful.
public void move() {
	Scanner s = new Scanner(System.in);
	System.out.println("You may move in x-direction: upto 4 steps for Archers");
	int xstep = s.nextInt();
	if (xstep <= -4 && x >=4)
		x = x - 4;
	elseif (xstep <= -4)
		x = 0;
	elseif (xstep >= 4 && x <=4)
		x = x + 4;
	elseif (xstep >=4)
		x = 8;
	else 
		x = x + xstep;

int ystep = s.nextInt();
	if (ystep <= -4 && y >=4)
		y = y - 4;
	elseif (ystep <= -4)
		y = 0;
	elseif (ystep >= 4 && y <=10)
		y = y + 4;
	elseif (ystep >=4)
		y = 14;
	else 
		y = y + ystep;
	}
*/

