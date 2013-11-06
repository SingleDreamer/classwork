import java.io.*;
import java.util.*;

public class Warrior extends Character {
    private int exp=0,lvl=1;
    private int wait;

    public void Warrior() {
	strength = 12;
	dexterity = 4;
	super.setStat();
	health = strength;
	System.out.println("Strength: " + strength);
	System.out.println("Dexterity: " + dexterity);
    }

    public void attack(Character c) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Choose your attack!\n" + "(1) Poke, (2) Stab, (3) SUPERSLASH");
	int atk = sc.nextInt();

	if (atk == 1) {
	    poke(c);
	}
	else if (atk == 2) {
	    stab(c);
	}
	else if (atk == 3) {
	    superslash(c);
	}
	else {
	    System.out.println("Silly " + name + ", you can't kiss them");
	    attack(c);
	}
    }
	       

    public void poke(Character c) {
	Random r = new Random();
	String atk = "poke";
	int dmg = (int(str*r.nextdouble()));

	if (hit() == true) {
	    c.health = c.health - dmg;
	    System.out.println(name + " has hurt " + c + " with a " + atk + ".");
	}
	else {
	    System.out.println(name + " missed " + c + ".");
	}

	if (wait > 0) {
	    wait = wait - 1;
	}
    }

    public void stab(Character c) {
	Random r = new Random();
	String atk = "stab";

	if (wait == 0) {
	    int dmg = (int(str*(0.5 + r.nextDouble())));
	    if (hit() == true) {
		c.health = c.health - dmg;
		System.out.println(name + " has hurt " + c + " with a " + atk + ".");
		    }
	    else {
		System.out.println(name + " missed " + c + ".");
	    }
	    wait = 1;
	}
	else {
	    System.out.println("Sorry, you're too tired to " + atk + ".");
	}
    }

    public void superslash(Character c) {
	Random r = new Random();
	String atk = "superslash";

	if (wait == 0) {
	    int dmg = (int(str*(1 + r.nextDouble())));
	    if (hit() == true) {
		c.health = c.health - dmg;
		System.out.println(name + " has hurt " + c + " with a " + atk + ".")
		    }
	    else {
		System.out.println(name + " missed " + c + ".");
	    }
	    wait = 2;
	}
	else {
	    System.out.println("Sorry, you're too tired to " + atk + ".");
	}

    }	    


    public void defend(int dmg) {
	health = health - dmg;
    }

}
