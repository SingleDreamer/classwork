import java.io.*;
import java.util.*;


public class Wizard extends Character {
    protected double spelldamage;
    protected Random r;


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
	    if (Math.random() < 0.4) {
		other.condition = "frozen";
	    }
	}

}



