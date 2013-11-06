import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected int gold;
    protected double x,y;
    protected String name;
    protected String charClass;
    protected int distance;
    protected boolean isHere;

Random generator = new Random();

	public void setDistance() {
		distance = generator.nextInt(10) + 1;
	}

	public int getDistance() {
		return distance;
	}

    public int getHealth() {
		return health;
	  }

	public int getStrength() {
		return strength;
	}

	public int getExperience() {
		return experience;
	}

	public int getDexterity() {
		return dexterity;
	}

    /* You have to provide other needed get/set methods */


    public void attack(Character other) {
	/* do the attack:
	   print out the attempt and the result and update
	   all relavent variables
	*/
    }

    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
		return true;
    }


    /*
      this routine will decide first ask if other tries to flee. If
      so, and if it's succesful it should adjust experience and or
      gold as needed and return a 0.

      Then, it should decide if this character tries to flee.
      If so and it's succesful, return a 1;

      Otherwise, call attack on both sides:
      this.attack(other);
      if (other.health>0)
        other.attack(this);

      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead.

    */

 public int encounter(Character other){
	 return 0;
	 }


    public String getStatus() {
	String attrib1=String.format("Str: %d Dex: %d Int: %d",
				     strength, dexterity, intelligence);
	String attrib2=String.format("Exp: %d Health: %d of %d",
				     experience,health,maxhealth);
	String locale = String.format("x: %5.2f y: %5.2f",x,y);
	String whole=String.format("%s\n%s\n%s\n%s\n",
				   name,attrib1,attrib2,locale);
	return whole;
    }


    public String toString() {
	return name;
    }

}
