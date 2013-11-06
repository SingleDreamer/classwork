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

    public void cast (Character other, int spell){
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
	    spelldamage = this.intelligence * 3;
	    super.attack(other,spelldamage);
	    Sysetm.out.println (other.getName() + "has been hit by the final flame");
	}
    }
}



