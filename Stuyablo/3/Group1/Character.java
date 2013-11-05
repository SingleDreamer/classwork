import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int effDex, effStr, effInt; //Effective stats
    protected int experience;
	
	//I thought these were needed.
	protected int level;
	protected int statpt;
	
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;

    Random rand = new Random();

    public Character(String name){
        this.name = name;
        dexterity = 8;
        strength = 8;
        intelligence = 8;
        health = strength;
        effDex = dexterity;
    }

    public int getHealth() {
	return health;
    }

    public String getName(){
        return name;
    }

    public void setHealth(int health){
        this.health = health;
    }

    // I put roll method here because roll method is necessary in many methods in this class
    // such as attack methods            
    public int roll(int diceNumber, int diceSize){
        int i = 0;
        int diceSum = 0;
        while (i < diceNumber){
            diceSum = diceSum + 1 + rand.nextInt(diceSize);
            i++;
        }
        return diceSum;
    }

    /* You have to provide other needed get/set methods */

    public void lightAttack(Character other) {
	/* do the attack:
	   print out the attempt and the result and update
	   all relavent variables
	*/
        int roll = this.roll(3,6);
        System.out.println(this.getName() + " rolled " + roll);
        System.out.print(this.getName() + "'s effDex + 1: ");
        System.out.println(effDex+1);
        if (roll < this.effDex+1){ //Plus 1 is to make this attack more accurate
            other.setHealth(other.getHealth()-1);
            System.out.println("Attack successful");
			System.out.println("*");
        }
        
    }

    public void heavyAttack(Character other) {
        int roll = this.roll(3,6);
        System.out.println(this.getName() + " rolled " + roll);
        System.out.print(this.getName() + "'s effDex - 1: ");
        System.out.println(effDex-1);
        if (roll < this.effDex-1){ //Minus 1 is to make this attack less accurate
            other.setHealth(other.getHealth()-2);
            System.out.println("Heavy attack successful");
			System.out.println("*");
        }
        
    }
    // returns true if you succesfully flee, false otherwise
    public boolean flee() { //I don't see why you need Character other in parameter
		boolean success = false;
		if (this.roll(2, effDex/2) >= dexterity/2) {
			success = true;
		}
        return success;
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
    public int encounter(Character other,String command) {
	boolean playerDied = false;
        boolean opponentDied = false;
        if (command.equals("Light Attack")){
            this.lightAttack(other);
            if (other.getHealth() <= 0)
                opponentDied = true;
            other.lightAttack(this);
            if (this.getHealth() <= 0)
                playerDied = true;
        }
        if (command.equals("Heavy Attack")){
            this.heavyAttack(other);
            if (other.getHealth() <= 0)
                opponentDied = true;
            other.heavyAttack(this);
            if (this.getHealth() <= 0)
                playerDied = true;
        }
        if (command.equals("Flee")){
            if (this.flee())
                return 1;
        }
        System.out.println("This Character's status: ");
        System.out.println(this.getStatus());
        System.out.println("Other Character's status: ");
        System.out.println(other.getStatus());
		
        if (playerDied && opponentDied)
            return 4;
        else if (playerDied)
            return 2;
        else if (opponentDied)
            return 3;
        else
            return 5;
    }



    public String getStatus() {
	String attrib1=String.format("Name:%s Str: %d Dex: %d Int: %d",
				     name, strength, dexterity, intelligence);
	String attrib2=String.format("Exp: %d Health: %d of %d",
				     experience,health,strength);
	String locale = String.format("x: %5.2f y: %5.2f",x,y);
	String whole=String.format("%s\n%s\n%s\n%s\n",
				   name,attrib1,attrib2,locale);
	return whole;
    }


    public String toString() {
	return name;
    }
    
}
