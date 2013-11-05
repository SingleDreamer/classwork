import java.io.*;
import java.util.*;

public class Character {
  protected int health, maxhealth;
  protected int dexterity, strength, intelligence;
  protected int experience;
  protected String name;
  protected String charClass;

  public Character(String name, int dexterity, int strength, int intelligence) {
    this.dexterity = dexterity;
    this.strength = strength;
    this.intelligence = intelligence;
    this.health = strength;
    this.maxhealth = 32;
  }

  public Character(String name) {
    dexterity = 8;
    strength = 8;
    intelligence = 8;
    health = 8;
    maxhealth = 32;
  }

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

  public roll() {
    Random r = new Random();
    die1 = r.nextInt(6) + 1;
    die2 = r.nextInt(6) + 1;
    die3 = r.nextInt(6) + 1;
    return die1 + die2 + die3;
  }

  public void attack(Character other) {
    return "Generic Attack"
  }

    // returns true if you succesfully flee, false otherwise
  public boolean flee() {
    roll = this.roll()
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

    */
  public int encounter(Character other) {
      return 0;

  }



  public String getStatus() {
    attrib1=String.format("Str: %d Dex: %d Int: %d",
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
