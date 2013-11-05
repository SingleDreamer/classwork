import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, maxDex, strength, maxStr, intelligence, maxInt;
    protected int experience;
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;
 
    public String multStr(String str, int times){
	for(int i = 0; i < times; i++) {
	    System.out.print(str);
	}
    }


    /* You have to provide other needed get/set methods */
    //Get Methods
    public int getHP() {
	return health;
    }
    public int getDex() {
	return dexterity;
    }
    public int getStr() {
	return strength;
    }
    public int getInt() {
	return intelligence;
    }
    public int getExp() {
	return experience;
    }

    //Set Methods
     public int settHP(x) {
	this.health = x;
    }
    public int getDex(x) {
	this.dexterity=x;
    }
    public int getStr(x) {
	this.strength =x;
    }
    public int getInt(x) {
	this.intelligence=x;
    }
    public int getExpx(x) {
	this.experience=x;
    }


    public void attack(Character other) {
        /* do the attack:
           print out the attempt and the result and update
           all relavent variables
        */

	random dice1 = new Random() * 6;
	random dice2 = new Random() * 6;
	random dice3 = new Random() * 6;

	if (dice1 + dice2 + dice3 > this.getDex) {
	    this.attack(other)
		}
    }

    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
	int ans;
	double r = Math.random();
	if (r > .5) {
	    ans = true}
	else {
	    ans = false}
	return ans;
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
	Scanner sc = new Scanner(System.in);
	if (other.flee(this)) { //this is your player, other is NPC
	    return 0;
	}

	System.out.println("YOUR STATS:");

	//Player Stats
	System.out.println("Health": player.getHealth); //Health
	System.out.print(multstr('▓',((player.getHP/player.maxHP)*100)));  //Health Bar
	System.out.println("(" + ((player.getHP/player.maxHP)*100) + "%)");
	System.out.println("Health": player.getStr); //Strength
	System.out.print(multstr('▓',((player.getStr/player.maxStr)*100)));  //Strength Bar
	System.out.println("(" + ((player.getStr/player.maxStr)*100) + "%)");
	System.out.println("Health": player.getDex); //Dexterity
	System.out.print(multstr('▓',((player.getDex/player.maxDex)*100)));  //Health Bar
	System.out.println("(" + ((player.getDex/player.maxDex)*100) + "%)");



	System.out.println("Choose your Move!"); //move chooser
	System.out.println("a - attack \nr - run");
	String choice = sc.nextLine();
	if (choice.equals("2")) {
	    if (this.flee(other)){
		return 1;
	    }
	}


	else if (choice.equals("1")){
	    this.attack(other);

	    if (other.health>0) {
		other.attack(this);
		if (this.health<=0) {
		    return 2;
		}	

	    }
	    else {
		return 3;
	    }
		    return 5;
	}
    }
    
}