import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience, gold;
    protected double x, y, distance;
    protected String name, charClass;

    public Character() {
	dexterity = 8;
	strength = 8;
	intelligence = 8;
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
	int d1 = r1.nextInt(5) + 1;
	int d2 = r2.nextInt(5) + 1;
	int d3 = r3.nextInt(5) + 1;
	return (dexterity > (d1+d2+d3));
    }

    public void attack(Character other) {
	System.out.println(this.name + " tried to attack " + other.name + ".");
	boolean hitsuccess = this.roll();
	if (hitsuccess == false)
	    System.out.println("Attack failed.");
	if (hitsuccess == true) {
	    System.out.println("Attack succeeded.");
	    other.setHealth(other.health - this.strength/4);
	    System.out.println("Other's health has decreased to " + other.getHealth());
	}
    }

    public boolean flee(Character other) {
	Random r = new Random();
	if  (distance > (r.nextInt(10) - 5 + distance))
	    return true;
	else
	    return false;
    }

    public int encounter(Character other) {
	if (0.5  > Math.random()) {
	    boolean fleesuccess = other.flee(this);
	    if (fleesuccess == true) {
		other.experience += 1;
		return 0;
	    }
	    if (fleesuccess == false)
		return 1;
	}
	else {
	    this.attack(other);
	    if (other.health > 0)
		other.attack(this);
	}
	if (this.health == 0 && other.health <= 0)
	    return 4;
	else if (this.health == 0)
	    return 2;
	else if (other.health == 0)
	    return 3;
	else
	    return 5;
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
