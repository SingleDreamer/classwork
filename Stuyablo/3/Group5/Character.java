import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected String name;
    protected String charClass;


    public int getHealth() {
	return health;
    }

    public int getDexterity() {
	return dexterity;
    }

    public int getStrength() {
	return strength;
    }

    public int getIntelligence() {
	return intelligence;
    }

    public int roll() {
	Random r = new Random();
	int die1 = r.nextInt(6) + 1;
	int die2 = r.nextInt(6) + 1;
	int die3 = r.nextInt(6) + 1;
	return die1 + die2 + die3;
    }

    public void attack(Character other) {
	int dice = roll();
	int attackDmg =(int) (strength / 3);
	if (dexterity <= dice){
	    System.out.println("Successful Attack!");
	    other.health = other.health - attackDmg;
	}
	else
	    System.out.println("Attack failed.");
	
    }

    // returns true if you succesfully flee, false otherwise
  public boolean flee() {
    int roll = this.roll();
    if (roll < this.dexterity && roll%2==0)
      return true;
    else
      return false;
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

      (they would never be both dead.)
    */
    public int encounter(Character c, Character other) {
	if (other.flee() == true){
	    c.experience ++;
	    return 0;
	}
	if (c.flee() == true){
	    return 1;
	}
	System.out.println(c + " attacks " + other);
	c.attack(other);
	if (other.health > 0){
	    System.out.println(other + " attacks " + c);
	    other.attack(c);
	    if (c.health == 0) {
		System.out.println(c + " dies");
		return 2;
	    }
	}
	else {
	    System.out.println(other + " dies");
	    return 3;
	}
	return 5;
  }



  public String getStatus() {
    String attrib1=String.format("Str: %d Dex: %d Int: %d",
    			     strength, dexterity, intelligence);
    String attrib2=String.format("Exp: %d Health: %d of %d",
    			     experience,health,maxhealth);
    String whole=String.format("%s\n%s\n%s\n",
    			   name,attrib1,attrib2);
	return whole;
  }


  public String toString() {
    return name;
  }
    
}
