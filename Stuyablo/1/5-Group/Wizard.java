import java.util.*;
import java.io.*;

public class Wizard extends playerCharacter {
    private Random rand = new Random();

    public Wizard(String n){
	name = n;
    }

    public void turn (String a, Character other) {
	a = a.toUpperCase();
	Random r = new Random();
	boolean correct = false;
	while (!correct){
	    if (a.equals("FLEE")) {
		if ((r.nextInt(6) + r.nextInt(6) + r.nextInt(6)) < dex-1) {
		    System.out.println("You have fled from combat");
		}
		else {
		    System.out.println("You failed to flee");
		}
		correct = true;
	    }
	    else if (a.equals("ATTACK")) {
		boolean correct2 = false;
		Scanner s = new Scanner(System.in);
		while (!correct2){
		    System.out.println("1. Basic Attack ");
		    System.out.println("2. Fireball ");
		    System.out.println("3. Lightning Strike ");
		    System.out.println("What do you want to do? ");
		    int t = s.nextInt();

		    if (t==1) {
			basicAttack(other);
		    }
		    else if (t==2) {
			Fireball(other);
		    }
		    else if (t==3) {
			Lightning(other);
		    }
		    else {
			System.out.println("please just say 1, 2, or 3");
		    }
		}	    
		correct = true;
	    }
	    else {
		System.out.println("please type in Attack or Flee, or some variation");
	    }
	}
    }
    public void turn (String a, Kracken other) {
	a = a.toUpperCase();
	Random r = new Random();
	boolean correct = false;
	while (!correct){
	    if (a.equals("FLEE")) {
		if ((r.nextInt(6) + r.nextInt(6) + r.nextInt(6)) < dex-1) {
		    System.out.println("You have fled from combat");
		}
		else {
		    System.out.println("You failed to flee");
		}
		correct = true;
	    }
	    else if (a.equals("ATTACK")) {
		boolean correct2 = false;
		Scanner s = new Scanner(System.in);
		while (!correct2){
		    System.out.println("1. Basic Attack ");
		    System.out.println("2. Fireball ");
		    System.out.println("3. Lightning Strike ");
		    System.out.println("What do you want to do? ");
		    int t = s.nextInt();

		    if (t==1) {
			basicAttack(other);
		    }
		    else if (t==2) {
			Fireball(other);
		    }
		    else if (t==3) {
			Lightning(other);
		    }
		    else {
			System.out.println("please just say 1, 2, or 3");
		    }
		}	    
		correct = true;
	    }
	    else {
		System.out.println("please type in Attack or Flee, or some variation");
	    }
	}
    }
    
    public void basicAttack (Character c){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	if (x < dex) {
	    c.subHealth(1);
	}
    }

    public void Fireball (Character c) {
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	int y = str;

	if (x < dex && y > 0) {
	    if (rand.nextInt(5)>0) {
		c.subHealth(intl-rand.nextInt(5)-3);
	    }
	    else {
		y = y - 1;
	    }
	}
    }

    public void Lightning (Character c) {
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	int y = str;

	if (x < dex && y > 0) {
	    if (rand.nextInt(2)>0) {
		c.subHealth(intl-rand.nextInt(3));
	    }
	    else {
		y = y - 1;
	    }
	}
    }
}
