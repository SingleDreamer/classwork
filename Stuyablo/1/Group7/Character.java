import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth, dexterity, strength, intelligence, experience, gold;
    protected double x,y,distance;
    protected String name,charClass;
    Random r = new Random ();
   

 
    public Character (String name, String charClass) {
	this.name = name1;
	this.charClass = charClass1;
	maxhealth = r.nextInt (2000) + 1000;
	dexterity = r.nextInt (100);
	strength = r.nextInt (100);
	intelligence = r.nextInt (100);
	experience = r.nextInt (100) + 1;
	gold = r.nextInt (10000) + 10000;
	
    }

    public initChar (int maxhealth,int dexterity, int  strength, int  intelligence, int  experience, int gold) {
	this.maxhealth = maxhealth;
	this.dexterity = dexterity;
	this.strength = strength;
	this.intelligence = intelligence;
	this.experience = experience;
	this.gold = gold;
    }

    public int getHealth() {
	return health;
    }

    public int getmaxHealth () {
	return maxhealth;
    }

    public int getDexterity () {
	return dexterity;
    }

    public int getStrength () {
	return strength;
    }
    public int getIntelligence () {
	return intelligence;
    }
    public int getExperience () {
	return experience;
    }
    public int getGold () {
	return gold;
    }
    public int getName () {
	return name;
    }

    public void setHealth(int health) {
	this.health = health;
    }




    public void attack(Character other) {
	System.out.println("-----------------");
        System.out.println("1 to [], 2 to [], 3 to []");
        while (health > 0 && other.getHealth() > 0)
	    if(r.nextInt(100) >= dexterity) {
		other.setHealth(other.getHealth() - (this.strength + 5  + r.nextInt(5) - r.nextInt(5)));
 
		System.out.println("Your attack hit!");
		System.out.println(other.getName + " has " + other.getHealth + " health left.");
	    }
	    else {
		System.out.println("Your attack missed!");
	    }

    }


    public boolean flee(Character other) {
	return (this.dexterity - other.dexterity + 100 > r.nextInt (1000))
	    //low chance of flee if you are slower
}


    

    */
    public int encounter(Character other) {
	if (other.flee) {
	    other.gold = other.gold / 2;
	    other.experience = other.experience / 2;
	    return 0;
	}
     
	else if (this.flee) {
	    return 1;
	}
	else {
	          this.attack(other);
		  if (other.health>0) {
		      other.attack(this);
		      if (this.health < 1 && other.health < 1) {
			  return 4;
		      }
		      else if (other.health < 1) {
			  return 3;
		      }
		      else if (this.health < 1) {
			      return 2;
			  }
		      else {
			  return 5
		      }
	       
		  }

	}

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
