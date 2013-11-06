import java.io.*;
import java.util.*;

public class Character {
    protected int health = 100, maxhealth=100;
    protected int dexterity=8 , strength =8 , intelligence= 8;
    protected int experience = 0, level = 1;
    protected int gold = 100;
    protected String name;
    protected String charClass = "undecided";
 
    public int getHealth() {
	return health;
    }

    public boolean flee(Character other) {
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
    public int encounter() {
	return 0;
    }

    public String getStatus() {
	String cclass = "Character Class: " + charClass;
	String attrib1=String.format("Str: %d Dex: %d Int: %d",
				     strength, dexterity, intelligence);
	String attrib2=String.format("Health: %d of %d",
				     health,maxhealth);
	String attrib3=String.format("Gold: %d   Exp: %d",
				     gold, experience);
	String whole=String.format("%s\n%s\n%s\n%s\n%s\n",
				   name,cclass,attrib1,attrib2,attrib3);
	return whole;
    }

    public int  setStrength(int points){
	int p = points;
	Scanner s = new Scanner (System.in);
	System.out.print (" \n" + "Strength: + ");
	int strengthboost = s.nextInt();
	if (strengthboost <= points){
	    strength = strength + strengthboost;
	    p = points - strengthboost;
	}
	else {
	    System.out.print("Getting a little greedy now?");
	    p = this.setStrength(points);
	}
	return p;
    }

    public int  setDexterity(int points){
	int p = points;
	Scanner s = new Scanner (System.in);
	System.out.print (" \n" + "Dexterity: + ");
	int dexboost = s.nextInt();
	if (dexboost <= points){
	    dexterity = dexterity + dexboost;
	    p = points - dexboost;
	}
	else {
	    System.out.print("Getting a little greedy now?");
	    p = this.setDexterity(points);
	}
	return p;
    }
    public int  setIntelligence(int points){
	int p = points;
	Scanner s = new Scanner (System.in);
	System.out.print (" \n" + "Intelligence: + ");
	int intboost = s.nextInt();
	if (intboost <= points){
	    intelligence = intelligence + intboost;
	    p = points - intboost;
	}
	else {
	    System.out.print("Getting a little greedy now?");
	    p = this.setIntelligence(points);
	}
	return p;
    }


    public void setStat(){
	System.out.print ("\n" + "Here are three stat points for you to add.");
	int points = 8;
	points = setStrength (points);
	System.out.print ("\n" + "There are " + points + " points left");
        if (points > 0){
	    points = setDexterity (points);
	    System.out.print ("\n" + "There are " + points + " points left");
	}
	if (points > 0){
	    points = setIntelligence (points);
	    System.out.print ("\n" + "There are " + points + " points left");
	}
	if (points > 0){
	    System.out.print ("\n" + "Due to failure to use all your points, they are now gone. -poof-" + "\n");
	}
    }

    public void setClass(){
        Scanner s = new Scanner (System.in);
	System.out.print ("Are you a Wizard or a Warrior? Please type 'Wizard' or 'Warrior'");
	String c = s.nextLine();
	if (c.equals("Wizard")){
	    charClass = "Wizard";
	}
	else if (c.equals("Warrior")){
	    charClass = "Warrior";
	}
	else {
	    System.out.print ("Silly player. That's not a choice. \n");
	    setClass();
	}
    }

    public int getExperience(){
	return experience;
    }

    public String toString() {
	return name;
    }
    
    public void loseHealth(int n){
	health = health - n;
    }
    public void gainHealth(int n){
	health = health + n;
    }

    public void gainGold(int n){
	gold = gold + n;
    }

    public void loseGold(int n){
	gold = gold - n;
    }

    public void gainExp(int n){
	experience = experience + n;
    }


}
