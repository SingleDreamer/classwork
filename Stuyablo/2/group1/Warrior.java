import java.io.*;
import java.util.*;

public class Warrior extends Character {
    private int exp=0,lvl=1;
    private int wait;

    public void Warrior() {
	str = 12;
	dex = 4;
	super.setStat();
	health = str;
	System.out.println("Strength: " + str);
	System.out.println("Dexterity: " + dex);
    }

    public void attack(NPC c) {
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
		
    public boolean hit() {
	Random r = new Random();
	int d1,d2,d3,sum;
	d1 = r.nextInt(6) + 1;
	d2 = r.nextInt(6) + 1;
	d3 = r.nextInt(6) + 1;
	sum = d1 + d2 + d3;
	return (sum <= dex);
    }

    public void poke(NPC c) {
	Random r = new Random();
	String atk = "poke";
	int dmg = (int)(str*r.nextDouble());

	if (hit()) {
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

    public void stab(NPC c) {
	Random r = new Random();
	String atk = "stab";

	if (wait == 0) {
	    int dmg = (int)(str*(0.5 + r.nextDouble()));
	    if (hit()) {
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

    public void superslash(NPC c) {
	Random r = new Random();
	String atk = "superslash";

	if (wait == 0) {
	    int dmg = (int)(str*(1 + r.nextDouble()));
	    if (hit()) {
		c.health = c.health - dmg;
		System.out.println(name + " has hurt " + c + " with a " + atk + ".");
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
