import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience, gold;
    protected double x, y, distance;
    protected String name, charClass;

    // remember to print out players' stats regularly during battle

    public Character() {
	Random r = new Random();
	int j = 8;
	int d = r.nextInt(j);
	j = j - d;
	int s = r.nextInt(j);
	j = j - s;
	int i = j;
	dexterity = 8 + d;
	strength = 8 + s;
	intelligence = 8 + i;
	health = strength;
	maxhealth = 50;
	experience = 0; 
	gold = 0;
	distance = 0;
	name = "Unnamed Character";
	charClass = "PC or NPC";
    }
 

    public boolean roll() {
	Random r1 = new Random();
	Random r2 = new Random();
	Random r3 = new Random();
	int d1 = r1.nextInt(6) + 1;
	int d2 = r2.nextInt(6) + 1;
	int d3 = r3.nextInt(6) + 1;
	return (dexterity > (d1+d2+d3));
    }


    public void attack(Character other) {
	System.out.println(this.name + " tried to attack " + other.name + ".");
	boolean hitsuccess = this.roll();
	if (hitsuccess == false) {
	    System.out.println("Attack failed.");
	    System.out.println();
	}
	if (hitsuccess == true) {
	    int damage = strength / 2; // damage is half that of strength
	    System.out.println("Attack succeeded.");
	    if (other.health <= damage) {
		other.health = 0;
		this.experience += other.experience;
		System.out.println("Opponent defeated.  Experience increased by " + other.experience + " points.");
		System.out.println();
	    }
	    else
		other.setHealth(other.health - damage);
	    System.out.println("Opponent's health has decreased to " + other.getHealth() + ".");
	    this.experience += 1;
	    System.out.println("Experience increased by 1 point.");
	    System.out.println();	    
	}
    }


    public boolean flee(Character other) {
	// this doesn't incorporate distance (not yet, anyway)
	if (0.5 > Math.random() && this.dexterity > other.dexterity) // there's a 50% chance this character wants to flee, and it will be successful if it's fast enough
	    return true;
	else
	    return false;
    }


    public int encounter(Character other) {
	if (0.5  > Math.random()) {
	    System.out.println("This character tried to flee.");
	    boolean fleesuccess = other.flee(other);
	    if (fleesuccess == true) {
		other.experience += 1;
		System.out.println("Fleed successfully.");
		System.out.println();
		return 0;
	    }
	    if (fleesuccess == false) {
		System.out.println("Failed to flee.");
		System.out.println();
		return 1;
	    }
	}
	else {
	    this.attack(other);
	    if (other.health > 0)
		other.attack(this);
	}
	if (this.health == 0 && other.health == 0) {
	    System.out.println("Both characters died.");
	    System.out.println();
	    return 4;
	}
	else if (this.health == 0) {
	    System.out.println("This character died.");
	    System.out.println();
	    return 2;
	}
	else if (other.health == 0) {
	    System.out.println("The opponent died.");
	    System.out.println();
	    return 3;
	}
	else {
	    System.out.println("No character killed.  Battle continues.");
	    System.out.println();
	    return 5;
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

    public void setHealth(int i) {health = i;}
    public int getHealth() {return health;}

    public void setMaxHealth(int i) {maxhealth = i;}
    public int getMaxHealth() {return maxhealth;}

    public void setDexterity(int i) {dexterity = i;}
    public int getDexterity() {return dexterity;}

    public void setStrength(int i) {strength = i;}
    public int getStrength() {return strength;}

    public void setIntelligence(int i) {intelligence = i;}
    public int getIntelligence() {return intelligence;}

    public void setExperience(int i) {experience = i;}
    public int getExperience() {return experience;}

    public void setGold(int i) {gold = i;}
    public int getGold() {return gold;}

    public void setDistance(double d) {distance = d;}
    public double getDistance() {return distance;}

    public void setName(String s) {name = s;}
    public String getName() {return name;}

    public void setCharClass(String s) {charClass = s;}
    public String getCharClass() {return charClass;}

    public String toString() {return name;}

}
