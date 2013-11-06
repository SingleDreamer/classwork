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
    protected int damage;//Richard added
    Helper h = new Helper();
    public Character(){
	experience = 0;
	gold = 0;
    }
    public int getHealth() {
	return health;
    }
    public String getName() {
	return name;
    }
    public void setName(String n){
	name = n;
    }
    public void setHealth(int n) { 
	health=n; 
    }

    public void loseHealth(Character other, int i){//Richard added
	if (i > other.getHealth()){//make it so that i will print appropriately
	    i = other.getHealth();
	}
	other.setHealth( other.getHealth() - i);
	System.out.println(other.getName()+ " has lost " + i + " health");
	System.out.println(other.getName()+ " has " + other.getHealth() + " health left.");
	System.out.println("---------------------------------------------------------------");
    }
    public int getStr(){
	return strength;
    }
    public int getDex(){
	return dexterity;
    }
    public int getInt(){
	return intelligence;
    }
    public int getGold(){
	return gold;
    }
    public int getExp(){
	return experience;
    }
    public void setStr(int i){
	strength = strength + i;
    }
    public void setDex(int i){
	dexterity = dexterity + i;
    }
    public void setInt(int i){
	intelligence = intelligence + i;
    }
    public void setGold(int i){
	gold = gold + i;
    }
    public void setExp(int i){
	experience = experience + i;
    }
    /* You have to provide other needed get/set methods */


    public void attack(Character other) {
	h.pause();
	Random r= new Random();
	int roll=r.nextInt(6) + r.nextInt(6)+ r.nextInt(6)+3; /*three six-sided die roll implementation by Matthew*/
	if (roll < this.getDex()) {
	    System.out.println("A hit!");
	    loseHealth(other,damage);
	    /* do the attack:
	       print out the attempt and the result and update
	       all relavent variables
	    */
	}
	else {
	    System.out.println("A miss...\n---------------------------------------------------------------");
	}
    }

    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other){
	Random r= new Random();
	int roll=r.nextInt(6) + r.nextInt(6)+ r.nextInt(6) +r.nextInt(6)+4;
	if (roll< this.getDex()){       // if the sum of the outcomes of four dice is less than your dexterity, then you escape.
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

      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead.
    */
    public int encounter(Ogre other) {
	Scanner sc = new Scanner(System.in);
	h.pause();
	System.out.println("\nCAUTION!!!!!\n\n");
        System.out.println("You have encountered a burly ogre!\n");
        h.pause();
	Random r = new Random();
        String choice = "";
        while ((this.getHealth() > 0) && (other.getHealth() > 0)){
            //System.out.println("\n");
            System.out.println(this.getStatus());
            System.out.println("What will you do?: Attack Flee");
	    choice = sc.nextLine();
            if (choice.equals("Attack")){
                System.out.println("---------------------------------------------------------------");
                if (this.getDex()>other.getDex()){
                    this.attack(other);
                    if (other.getHealth() > 0)
                        other.attack(this);
                }
                else{
                    other.attack(this);
                    if (this.getHealth() > 0)
                        this.attack(other);
		}
            }
            else if (choice.equals("Flee")){
		if (this.flee(other)==true){
		    System.out.println("\nYou have escaped this ogre!");
		    h.pause();
		    break;
		}
		else {
		    System.out.println("\nYou did not escape...");
		    System.out.println("---------------------------------------------------------------");

		    other.attack(this);
		    h.pause();
		}
	    }
            if (other.getHealth() <= 0){
                System.out.println("You have slain the ogre!");
                this.setExp(other.getExp());
                this.setGold(other.getGold());
		return 3;
            }
            if (this.getHealth() <= 0){
                System.out.println("Your adventure ends here...");
		return 2;
            }
	    
	}
        System.out.println("\n");
	return 5;
    }
    public void play(int n) {
	while (n>0) {
	    Ogre o=new Ogre();
	    this.encounter(o);
	    n=n-1;
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
	return name + charClass;
    }
    
}
