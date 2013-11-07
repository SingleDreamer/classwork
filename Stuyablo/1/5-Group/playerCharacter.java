import java.io.*;
import java.util.*;

public class playerCharacter extends Character {

    public playerCharacter () {
	str = 8;
	maxhp = str;
	hp = maxhp;
	dex = 8;
	intl = 8;
	def = 8;
    }
 
    public void turn (String a, Kracken other) {
	/*
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	Warrior w = new Warrior();
	Wizard wi = new Wizard();

	if (a.equals("Flee")) {
	    if ((r.nextInt(6) + r.nextInt(6) + r.nextInt(6)) > 12) {
		System.out.println("You have fled from combat");
	    }
	}
	else if (a.equals("Attack")) {
	    if (role.equals("Warrior")) {
	        
	        System.out.println("1. Basic Attack ");
		System.out.println("2. Triple Strike ");
		System.out.println("3. Critical Hit ");
	        System.out.println("What do you want to do? ");
		int t = s.nextInt();
		
		if (t==1) {
		    w.basicAttack(other);
		}
		else if (t==2) {
		    w.tripleStrike(other);
		}
		else if (t==3) {
		    w.critHit(other);
		}
		else {
		    System.out.println("");
		}
	    }

	    if (role.equals("Wizard")) {

	        System.out.println("1. Basic Attack ");
		System.out.println("2. Fireball ");
		System.out.println("3. Lightning Strike ");
	        System.out.println("What do you want to do? ");
		int t = s.nextInt();
		
		if (t==1) {
		    wi.basicAttack(other);
		}
		else if (t==2) {
		    wi.Fireball(other);
		}
		else if (t==3) {
		    wi.Lightning(other);
		}
		else {
		    System.out.println("");
		}

	    }
	}
	else {
	    System.out.print("");
	}
	*/
	System.out.println("you don't understand inheritance");
    }

    public String getStr() {
	return "Your Strength (and max HP) is " + str;
    }
    public String getDex() {
	return "Your Dexterity is " + dex;
    }
    public String getInt() {
	return "Your Intelligence is " + intl;
    }
    public String getHP() {
	return "Your current Health is " + hp;
    }

}
