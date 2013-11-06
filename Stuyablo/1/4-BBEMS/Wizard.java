import java.io.*;
import java.util.*;


public class Wizard extends Character {
    protected double spelldamage;
    protected Random r;
    protected int boostcount;


    public Wizard () {
	super("New character", "Wizard");
    }

    public Wizard (String name) {

	super (name, "Wizard");

    }

    public void attack (Character other){
	if (freezecount == 0) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Do You Want To");
	    System.out.println("Cast");
	    System.out.println("Attack");
	    String option = sc.next();
	    if (option.equals("Cast") || option.equals("cast")) {
		System.out.println("Select the spell you want to use");
		System.out.println("1. Fireball");
		System.out.println("2. Heal");
		System.out.println("3. Ice Storm");
		System.out.println("4. Power boost");
		System.out.println("5. Sleep");
		System.out.println("6. Final Flame");
		int spell = sc.nextInt();
		if (spell == 1) {
		    spelldamage = (this.intelligence * 1.5) - r.nextInt(4);
		    super.attack(other, spelldamage);
		    System.out.println(other.getName() + "was hit by a fireball");
		}
		if (spell == 2) {
		    this.health = this.health + 30;
		    System.out.println(super.getName() + "cast heal");
		}
		if (spell == 3) {
		    spelldamage = (this.intelligence * 1.1);
		    super.attack(other,spelldamage);
		    System.out.println(other.getName() + "was hit by ice");
		    if (Math.random() < 0.4) {
			other.freezecount  = 2;
			System.out.println (other.getName() + "was frozen");
		    }
		}
		if (spell == 4) {
		    this.intelligence = this.intelligence * 2.5;
		    this.boostcount = 2;
		    System.out.println(this.getName() + "has increased their intelligence");
		}
		if (spell == 5) {
		    other.freezecount = 3;
		    System.out.println (other.getName() + "is asleep");
		}
		
		if (spell == 6) {
		    spelldamage = this.intelligence * 3 - r.nextInt(10);
		    super.attack(other,spelldamage);
		    Sysetm.out.println (other.getName() + "has been hit by the final flame");
		}
		else {
		    System.out.println("Invalid spell, you will now perform a basic attack");
		}
	    }
	    else {
		spelldamage = this.strength;
	    }
	    other.health = other.health - spelldamage;
	}
	else {
	    System.out.println ("Your character is immobilized");
	}
	if (freezecount > 0) {
	    freezecount = freezecount - 1;
	}
	if (boostcount > 0) {
	    boostcount = boostcount - 1;
	}
	if (boostcount == 0) {
	    this.intelligence = this.intelligence * 0.4;
	    boostcount = boostcount - 1;
	}
    }
}



