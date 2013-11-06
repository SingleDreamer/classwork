import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxHealth;
    protected int dexterity, maxDex, strength, maxStr, intelligence, maxInt;
    protected int experience;
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;
 
    public String toString() {
	return name;
    }

    public void multStr(String str, int times){
	for (int i = 0; i < times; i++) {
	    System.out.print(str);
	}
	
    }

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

    public void setDex(int x) {
	this.dexterity=x;
    }
    public void setStr(int x) {
	this.strength =x;
    }
    public void setInt(int x) {
	this.intelligence=x;
    }
    public void setExp(int x) {
	this.experience=x;
    }
    public void setHP(int x) {
	this.health = x;
    }
   

    public void getStatus() {
	System.out.println(this + "'s STATS:");

	System.out.println("Health: "+ this.getHP()); 
        //multStr("*",((this.getHP()/this.maxHealth)*100.0));  
	System.out.println("(" + (((this.getHP()*1.0)/(this.maxHealth*1.0))*100.0) + "%)");

	System.out.println("Strength: "+ this.getStr());
        //multStr("*",((this.getStr()/this.maxStr)*100)); 
	System.out.println("(" + (((this.getStr()*1.0)/(this.maxStr*1.0))*100.0) + "%)");

	System.out.println("Dexterity: "+ this.getDex());
        //multStr("*",((this.getDex()/this.maxDex)*100)); 
	System.out.println("(" + (((this.getDex()*1.0)/(this.maxDex*1.0))*100) + "%)");
    }

    public void attack(Character other) {
        Random r = new Random();

	int dice1 = r.nextInt(6);
	int dice2 = r.nextInt(6);
	int dice3 = r.nextInt(6);

	if (dice1 + dice2 + dice3 > this.getDex()) {
	    int damage = r.nextInt(this.strength/4);
	    other.health = other.health - damage;
	}
    }

    public boolean flee(Character other) {
        Random r = new Random();
	if (r.nextDouble() > .5) {
	    return true;
	}
	else {
	    return false;
	}
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
      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead. */

    public int encounter(Character other) {
	Scanner sc = new Scanner(System.in);
	System.out.println("You have an encountered " + other);
	this.getStatus();
	if (other.flee(this)) { 
	    return 0;
	}
	
	System.out.println("Do you want to escape?");
	System.out.println("y - yes \nn - no");
	String choice = sc.nextLine();
	if (choice.equals("y")) {
	    if (this.flee(other)) {
		return 1;
	    }
	}
	
	this.attack(other);
	if (other.health > 0) {
	    other.attack(this);
	}
	this.getStatus();
	if (other.health == 0) {
	    return 3;
	}
	else if (this.health == 0) {
	    return 2;
	}
	else if ((this.health == 0) && (other.health == 0)) {
	    return 4;
	}
	else {
	    return 5;
	}
       
    }

}
