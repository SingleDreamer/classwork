import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;

    public Character() {
	health = 8;
	maxhealth = 20; // If you agree.
	dexterity = 8;
	strength = 8;
	intelligence = 8;
	experience = 0; 
	gold = 0;
	distance = 0;
	name = "Unnamed Character";
	charClass = "PC or NPC"; // I think.
 
    public void setHealth(int i) {
	health = i;
    }

    public int getHealth() {
	return health;
    }

    public void setMaxHealth(int i) {
	maxhealth = i;
    }

    public int getMaxHealth() {
	return maxhealth;
    }

    public void setDexterity(int i) {
	dexterity = i;
    }

    public int getDexterity() {
	return dexterity;
    }

    public void setStrength(int i) {
	strength = i;
    }

    public int getStrength() {
	return strength;
    }

    public void setIntelligence(int i) {
	intelligence = i;
    }

    public int getIntelligence() {
	return intelligence;
    }

    public void setExperience(int i) {
	experience = i;
    }

    public int setExperience() {
	return experience;
    }

    public void setGold(int i) {
	gold = i;
    }

    public int getGold() {
	return gold;
    }

    public void setDistance(double d) {
	distance = d;
    }

    public double getDistance() {
	return distance;
    }

    public void setName(String s) {
	name = s;
    }

    public String getName() {
	return name;
    }

    public void setCharClass(String s) {
	charClass = s;
    }

    public String getCharClass() {
	return charClass;
    }



    public void attack(Character other) {
	/* do the attack:
	   print out the attempt and the result and update
	   all relavent variables
	*/
    }



    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
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
    public int encounter(Character other) {
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


/*

Attributes

For a human, each attribute starts at 8 and you have 8 additional points to distribute. A PC can use user input to generate the characters or you can do it randomly. An NPC should randomly set the attributes. Other races can have different starting points and point allotments. Likewise you can start specific characters with certain strengths and weaknesses.

Combat

To hit an opponent, you have to roll your dexterity or less on three six sided dice.

For distance weapons, the in the real game you subtracted 1 from your dexterity for the purposes of the roll per grid space travelled. You would make the adjustment based on the distance between the two characters.

Damage is based on the weapon you use and the weapons you can use are based on strength, k.

*/
