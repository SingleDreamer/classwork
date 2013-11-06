import java.io.*;
import java.util.*;

public class Rogue extends PC {

    private Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    protected int poison;
    protected int stealth;

    public Rogue() {
	super();
	poison=0;
    }

    public int dice() {
	int total = 0;
	int a = 0;
	int i = 0;
	while (i < 3) {
	    a = rand.nextInt(6) + 1;
	    total = total + a;
	    i++;
	}
	return total;
    }
	    

    public void attack (Character other) {
	System.out.println("Choice of Attack? 1-Weak Slap 2-Knife");
	int weapon = sc.next();
	if (weapon == 1) {
	    System.out.println("Quick Attack!");
	    Thread.sleep(2000);
	    System.out.println(name + " slaps the " + other.name+"!");
	    other.setHealth(other.getHealth()-1);
	    System.out.println(name + " deals 1 damage!");
	}
	else if (weapon ==2) {
	    System.out.println("Knife!");
	    Thread.sleep(2000);
	    if (dexterity > roll()) {
		System.out.println(name + " stabs the " + other.name+"!");
		other.setHealth(other.getHealth()-strength);
		System.out.println(name + " deals " + strength + " damage!");
	    }
	    else {
		System.out.println(name + " missed!");
	    }
	}
	else {
	    System.out.println("Nope.");
	}
    }
	
	    
	  
	    
	    
	    
	
