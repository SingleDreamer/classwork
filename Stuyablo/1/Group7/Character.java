import java.io.*;
import java.util.*;

public class Character {
    protected int roll, health, maxhealth, dexterity, strength, intelligence, experience, gold;
    protected double x,y,distance;
    protected String name,charClass;
    Random r = new Random ();
    
    public Character(){
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter name: ");
	name = sc.next();
        strength = 8+ r.nextInt(4);
	dexterity = 8 + r.nextInt(4);
	health = strength;
	maxhealth = 20;
    }
    public Character (String name, String charClass) {
	this.name = name;
	this.charClass = charClass;
	maxhealth = 20;
	dexterity = r.nextInt (10)+5;
	strength = r.nextInt (4)+8;
	intelligence = r.nextInt (10)+5;
	experience = r.nextInt (10) + 1;
	gold = r.nextInt (10) + 100;
	health = strength;
    }

    public void initChar (int maxhealth,int dexterity, int  strength, int  intelligence, int  experience, int gold) {
	this.maxhealth = maxhealth;
	this.dexterity = dexterity;
	this.strength = strength;
	this.intelligence = intelligence;
	this.experience = experience;
	this.gold = gold;
	this.health = strength;
    }

    public int getHealth() {
	return health;
    }

    public int getmaxHealth () {
	return maxhealth;
    }

    public int getDexterity () {
	return dexterity;
    }

    public int getStrength () {
	return strength;
    }
    public int getIntelligence () {
	return intelligence;
    }
    public int getExperience () {
	return experience;
    }
    public int getGold () {
	return gold;
    }
    public String getName () {
	return name;
    }

    public void setHealth(int health) {
	this.health = health;
    }
    public void setStrength(int Strength){
	this.strength = strength;
    }



    public void rolls(){
	Random rand = new Random();
	int ran = 0;
	for (int i = 0; i <3; i = i + 1){
	    ran = rand.nextInt(6);
	    if (ran == 0){
		ran = ran + 1;
	    }
	    roll = roll + ran;
	}
    }
    public void attack(Character other) {
	System.out.println(name + " tries to attack" + "\n");
	this.rolls();
	if (this.getDexterity() > roll){
	    System.out.println(name + " misses");
	    this.setStrength(this.getStrength()-1);
	    System.out.println(other.name);
	    System.out.println("   Health:" + other.getHealth());
	    System.out.println(this.name);
	    System.out.println("   Health:" + this.health);

	}
	       
	else {

	    System.out.println(name + " hits the enemy");
	    other.setHealth(other.getHealth()-1);
	    this.setStrength(this.getStrength()+1);
	    this.experience = this.experience + 10;
	    System.out.println(other.name);
	    System.out.println("   Health:" + other.getHealth());
	    System.out.println(this.name);
	    System.out.println("   Health:" + this.health);

     
	}
       
	System.out.println("------------------");
		

    }

    public boolean flee(Character other) {
	return (this.dexterity - other.dexterity + 10 > r.nextInt (30));
 
    }



    public void Battle(int n, Character other){
	int stat = 0;
	while (n>=0){
	    if (n==0){
		System.out.println("Game Over");

		break;
	    }
	    else {
		if (this.strength > other.strength){
		    stat=this.encounter(other);
		    if (stat > 1 && stat < 5){
			if (stat == 2){
			    System.out.println("You have died");
			    
			}
			else if (stat == 3){
			    System.out.println("Your opponent has died");
			}
			else if (stat == 4){
			    System.out.println("You and your opponent have both died");
			}
			break;
		    }
		    else{
			n = n-1;
		    }
		}
		else {
		    stat = other.encounter(this);
		    if (stat > 1 && stat < 5){
			if (stat == 2){
			    System.out.println("Your opponent has died");
			 
			}
			else if (stat == 3){

			    System.out.println("You have died");
	        
			}
			else if (stat == 4){

			    System.out.println("You and your opponent have both died");
	       
			}
			break;
		    }
		    else{
			n = n-1;
		    }
		}
	    }
	}
    }

		    
    public int encounter(Character other) {
	int ex = 0;
	if (this.getHealth() > 0 && other.getHealth() > 0){
	    if (other.flee(this)) {
		System.out.println(other.name + " flees");
		System.out.println(other.name);
		System.out.println("   Health:" + other.getHealth());
		System.out.println(this.name);
		System.out.println("   Health:" + this.health);
		System.out.println("------------------- \n");
		ex= 0;
	    }
     
	    else if (this.flee(other)) {
		ex = 1;
		System.out.println(this.name + " flees");
		System.out.println(other.name);
		System.out.println("   Health:" + other.getHealth());
		System.out.println(this.name);
		System.out.println("   Health:" + this.health);
		System.out.println("------------------- \n");

	    }
	    else {
		other.attack(this);
		if (this.health <= 0){
		    if(other.health <= 0) {
			ex= 4;
		    }
		    ex = 2;
		}
		else if (other.health <= 0) {
		    ex= 3;
		}
	
		else {
		    ex= 5;
		}
	    }
	}
	else{
	    ex = 5;
		}
	     
	return ex;
    }

    //Still needs a levelUp method
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
