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
    protected int dieRoll;

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


    public int DieRoll(){
        for (int i=0; i<3; i++){
	    dieRoll = dieRoll + generator.nextInt(5) + 1;
        }
        return dieRoll;
    }

    public void flee(){
	DieRoll();
	if (dieRoll <= dexterity) {
	    System.out.println("You have fled");
	    isHere = false;
	}
	else 
	    System.out.println("You tried to flee but weren't fast enough!");
    }


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


    public boolean isAlive(){
	if (health > 0)
	    return true;
	return false;
    }

    public void playerEncounter(Character other){	
	Scanner sc = new Scanner(System.in);
	System.out.println("What would you like to do?(a for attack, f for flee)");
	String action = sc.nextLine();
	if (action == "a")
	    attack(other);
	    System.out.println("The enemy now has" + " " + other.getHealth() + " " + "health");
	if (action == "f")
	    flee();
	if (action != "a" && action != "f")
	    System.out.println("That is not a valid choice. Skip turn.");
    }


    public void startEncounter(Character other){
	isHere = true;
	System.out.println("You have encountered an enemy");
	while (isAlive() && other.isAlive() && isHere){
	    playerEncounter(other);
	    other.attack(this);
	    System.out.println("Your current health is" + " " + health);
	}
	if (!other.isAlive())
	    System.out.println("You win!");
	if (!isHere)
	    System.out.println("You ran from battle.");
	else
	    System.out.println("You died");
	    System.out.println("GAME OVER");	       
    }

    public String toString() {
	return name;
    }

}
