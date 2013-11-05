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

    public Character(String n){
	name = n;
    }
    public void setAttributes(){
	int dex;
	int stren;
	int intell;
	Random r=new Random();
	try{
	    dex=r.nextInt(8)+1;
	    stren=r.nextInt(8-dex)+1;
	    intell=8-dex-stren;
	}
	catch (Exception e){
	    dex=3;
	    stren=3;
	    intell=2;
	}
	health=50;
	maxhealth=50;
	dexterity=dex+8;
	strength=stren+8;
	intelligence=intell+8;
    }

    public void chooseClass(){
	Scanner sc=new Scanner(System.in);
	System.out.println("Press 1 to be a WARRIOR");
	System.out.println("Press 2 to be a WIZARD");
	System.out.println("Press 3 to be an OGRE ");
	System.out.println("Press 4 to be a THEIF");

	int answer=sc.nextInt();

	if (answer == 1)
	    charClass="Warrior";
	if (answer == 2)
	    charClass="Wizard";
	if (answer == 3)
	    charClass="Ogre";
	if (answer == 4)
	    charClass="Theif";
	else {
	    System.out.println("That is not a valid key.\n");
	    System.out.println("Press 1 to be a WARRIOR");
	    System.out.println("Press 2 to be a WIZARD");
	    System.out.println("Press 3 to be an OGRE ");
	    System.out.println("Press 4 to be a THEIF");
	    //doesn't work b/c goes straight to the encounter
	}
	System.out.println("----------------------");

    }

    public void randomClass(){
	Random rand=new Random();
	int c=rand.nextInt(4)+1;
	if (c == 1)
	    charClass="Warrior";
	if (c == 2)
	    charClass="Wizard";
	if (c == 3)
	    charClass="Ogre";
	if (c == 4)
	    charClass="Theif";


    }
 
    public int getHealth() {
        return health;
    }

    /* You have to provide other needed get/set methods */

    public void delay (x) {
    	try {
	    Thread.sleep(x);
	}
	catch(Exception e){
	
	} 
    }


    public void talk(Character other){

	Scanner sc = new Scanner(System.in);
	say ("you have chosen to talk!");
	delay (2000);
        say ("type the number corresponding to your choice");
        delay (2000); 
        say ("1. Hey big guy, you wanna go out for some drinks instead?");
        delay (1000); 
        say ("2. Please, don't you know who I am? I am the greatest swordsman in the East! " + 
	     "I've been training since I was 3! You don't have any chance of defeating me!" );
        delay (1000);
        say ("3. Didn't you know that they're having a body building competition in the next town?" +
	     " I bet you'd fit right in!");
        delay (1000);
        int answer = sc.nextInt(); 
        boolean x = new nextBoolean ();
        if (answer == 1) {
	    if (x) {
		delay (1000); 
		say ("Sure");
		//end turn
	    }        
	    else {
		delay (1000);
		say ("no way you freak!"); 
		this.attack(other);
	    }
        }
        if (answer == 2) {
	    if (x) {
		delay (1000); 
		say ("sh*t");
		other.flee(this);
	    }
	    else {
		delay (1000); 
		say ("bullsh*it"); 
		this.attack(other);
	    }
        }
        if (answer == 3) {
	    if (x) {
		delay (1000); 
		say ("...you're a riot, kid. and an idiot");
		//end turn
	    }
	    else {
		delay (1000);
		say ("are you serious?");
		this.attack(other);
	    }
        }
        //1="Say something charming";
        //2="Say something intimidating";
        //3="Say something funny";
        /*so on and so forth*/
        /*RESPONSES*/
        /*NPC's strength increases, deceases, player's strength increases, decreases, blahblahblah. RANDOM RESPONSE*/
    	Scanner sc = new Scanner(System.in);
    	say ("you have chosen to talk!");
    	delay (2000);
	say ("type the number corresponding to your choice");
	delay (2000); 
	say ("1. Hey big guy, you wanna go out for some drinks instead?");
	delay (1000); 
	say ("2. Please, don't you know who I am? I am the greatest swordsman in the East! " + 
	"I've been training since I was 3! You don't have any chance of defeating me!" );
	delay (1000);
	say ("3. Didn't you know that they're having a body building competition in the next town?" +
	" I bet you'd fit right in!");
	delay (1000);
	int answer = sc.nextInt(); 
	boolean x = new nextBoolean ();
	if (answer == 1) {
		if (x) {
			delay (1000); 
			say ("Sure");
			//end turn
		}	
		else {
			delay (1000);
			say ("no way you freak!"); 
			this.attack(other);
		}
	}
	if (answer == 2) {
		if (x) {
			delay (1000); 
			say ("sh*t");
			other.flee(this);
		}
		else {
			delay (1000); 
			say ("bullsh*it"); 
			this.attack(other);
		}
	}
	if (answer == 3) {
		if (x) {
			delay (1000); 
			say ("...you're a riot, kid. and an idiot");
			//end turn
		}
		else {
			delay (1000);
			say ("are you serious?");
			this.attack(other);
		}
	}
	//1="Say something charming";
	//2="Say something intimidating";
	//3="Say something funny";
	/*so on and so forth*/
	/*RESPONSES*/
	/*NPC's strength increases, deceases, player's strength increases, decreases, blahblahblah. RANDOM RESPONSE*/
    }
    public int roll(){
	
	Random x = new Random();
	int dice1 = x.nextInt(6) + 1;
	int dice2 = x.nextInt(6) + 1;
	int dice3 =  x.nextInt(6) + 1;
        return dice1+dice2+dice3;
    }
    public void takedamage(int k){
	health = health - k;
    }
    public void say(String s){
	System.out.println(s);
    }
    public void takegold( Character other){
	gold = gold + other.gold;
    }
    public void loosegold() {
	gold = 0;
    }
    public void die(){
	say( name + " has died");
    }

    public int  attack(Character other) {
	while (this.health > 0 || other.health > 0){
	    if (dexterity <= roll()){
		other.takedamage(this.strength);
		say (other + " has lost " + strength + " health points and has "+other.getHealth()+" health points left");
		try {
		    Thread.sleep(2000);
		}
		catch(Exception e){
		
		} 
	    }
	    if (other.dexterity <= other.roll()){
		this.takedamage(other.strength);
		say(name + " has lost " + other.strength + " health points and has "+this.getHealth()+" health points left");
		try {
		    Thread.sleep(2000);
		}
		catch(Exception e){
		
		} 
	    }
	    if (this.health <= 5){
		if (this.flee(other)){
		    return 0;
		}
	    }
	    if (other.health <= 5){
		if (other.flee(this)){
		    return 1;
		}
	    }
		
	}
	if (this.health <= 0){
	    this.die();
	    return 3;
	}
	else{
	    other.die();
	    return 2;
	}
    }
	    
        /* do the attack:
           print out the attempt and the result and update
           all relavent variables
        */

    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
	Random x = new Random();
	if (x.nextInt(intelligence) >= intelligence/2){
	    say(this + " has fled");
	    other.takegold(this);
	    loosegold();
	    return true;
	}
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

      and then return 3 if this is dead, 2 if other is dead, 4 if both dead, 5 if none dead.

    */
    public int encounter(Character other) {
	Scanner sc = new Scanner(System.in);
	say("you have encountered " + other);
	try {
	    Thread.sleep(2000);
	}
	catch(Exception e){
	
	} 
	say("his status is");

	say (other.getStatus2());

	say (other.getStatus());
	try {
	    Thread.sleep(2000);
	}
	catch(Exception e){
	
	} 

	say ("type 1 if you wish to talk");
	try {
	    Thread.sleep(2000);
	}
	catch(Exception e){
	
	} 
	say("type 2 if you wish to attempt to flee");
	try {
	    Thread.sleep(2000);
	}
	catch(Exception e){
	
	} 
	say("type 3 if you wish to fight");
	
	int answer = sc.nextInt();
	if (answer == 1)
	    this.talk(other);
	if (answer == 2){
	    if (this.flee(other))
		return 1;
	    else
		answer = 3;
	}
	if (answer == 3){
	    int i = attack(other);
	    if (i == 0)
		return 1;
	    if (i == 1)
		return 0;
	    if (i == 2){
		experience = experience + 1;
		return 2;
	    }
	    else 
		return i;
	}
	return 0;
	   
    }



    public String getStatus() {
	setAttributes();
	chooseClass();
        String attrib1=String.format("Str: %d Dex: %d Int: %d",
                                     strength, dexterity, intelligence);
        String attrib2=String.format("Exp: %d Health: %d of %d",
                                     experience,health,maxhealth);
        String locale = String.format("x: %5.2f y: %5.2f",x,y);
        String whole=String.format("%s\n%s\n%s\n%s\n%s\n",
                                   name,charClass,attrib1,attrib2,locale);
        return whole;
    }

    public String getStatus2() {
	setAttributes();
	randomClass();
        String attrib1=String.format("Str: %d Dex: %d Int: %d",
                                     strength, dexterity, intelligence);
        String attrib2=String.format("Exp: %d Health: %d of %d",
                                     experience,health,maxhealth);
        String locale = String.format("x: %5.2f y: %5.2f",x,y);
        String whole=String.format("%s\n%s\n%s\n%s\n",
                                   name,charClass,attrib1,attrib2,locale);
        return whole;
    }


    public String toString() {
        return name;
    }

    
}
