import java.util.*;
import java.io.*;

public class Character {
    protected int health;
    protected int maxHealth;
    protected int intelligence;
    protected int dexterity;
    protected int strength;
    protected int experience;
    protected String name;
    protected double x;
    protected double y;
    protected int skills;


    private Random r = new Random();

    protected void init(String n, int h, int m, int s, int d, int i, int e, double x, double y) {
	name = n;
	health = h;
	maxHealth = m;
	intelligence = i + 8;
	dexterity = d + 8;
	strength = s + 8;
	experience = e;
	this.x = x;
	this.y = y;
	skills = 0;
    }

    public Character(String name, int limit) {
	Random r = new Random();
	int str = r.nextInt(limit + 1);
	int dex = r.nextInt(limit + 1 -str);
	int inte = limit-str-dex;
	init(name,50,100,str,dex,inte,0,0.0,0.0);
    }
    
    public Character() {        //For player character
	boolean valid, sure;
	int str = 0, dex = 0, inte = 0;
	String yn;

	Scanner scan = new Scanner(System.in);
	sure = false;

	while (!sure) {
	    System.out.print("What is your name? ");
	    name = scan.next();
	    System.out.println("Now time to enter your stats. Remember that you get 8 points in every stat and can put 8 extra points wherever.");
	    System.out.println();
		
	    valid = false;
	    while (!valid) {
		System.out.print("Enter desired extra strength points: ");
		str = scan.nextInt();

		System.out.print("Enter desired extra dexterity points: ");
		dex = scan.nextInt();

		System.out.print("Enter desired extra intelligence points: ");
		inte  = scan.nextInt();
		
		if (inte + dex + str == 8)
		    valid = true;
		else {
		    System.out.println("You did not enter 8 extra points, please try again.");
		    System.out.println();
		}
	    }

	    System.out.println();
	    System.out.println("Name: " + name + " Str: " + str + " Dex: " + dex + " Int: " + inte);
	    valid = false;
	    while (!valid) {
		System.out.print("Are these okay y/n: ");
		yn = scan.next();
		if (yn.equals("y")) {
		    valid = true;
		    sure = true;
		}
		else if (yn.equals("n")) {
		    valid = true;
		    System.out.println("Restarting character creation...");
		    System.out.println();
		}
		else
		    System.out.println("That is not a valid option. Please say <y> or <n>.");
	    }
	}
	    
	System.out.println("Your Character " + name + " has been created!");
	init(name,50,100,str,dex,inte,0,0.0,3.0);
    }

    public double distance(Character other) {
	return Math.sqrt(((other.x - x)*(other.x - x))+((other.y - y)*(other.y - y)));
    }

    public void die(){
	if (health <= 0)
	    

    public void battle(Character other) {
	boolean npcliving = true;
	while (health >0){
	    if (other.health <= 0){
		npcliving = false;
		system.out.println("Your opponent has died. Success!");
	    }
	    while (npcliving){
		Scanner sc;
		if (this.dexterity >= other.dexterity) {
		    System.out.println("Choose an attack: ");
		    sc = new Scanner(System.in);
		    other.health = other.health - this.attack(sc.nextInt(),other);
		    this.health = this.health - other.attack(AIAttack(other),this);
		    System.out.println(this.name + "'s hp: " + this.health);
		    System.out.println(other.name + "'s hp: " + other.health); }
		else {
		    this.health = this.health - other.attack(AIAttack(other),this);
		    System.out.println("Choose an attack: ");
		    sc = new Scanner(System.in);
		    other.health = other.health - this.attack(sc.nextInt(),other);
		    System.out.println(other.name + "'s hp: " + other.health);
		    System.out.println(this.name + "'s hp: " + this.health); }
	    }
	}
    }

    //fight called in battle
    public void fight(int weapon, double dist){

    }

    //flee called in battle
    public boolean flee(Character other){
	if ((r.nextInt(6)+1)*distance(other)>10){
	    return true;
	}
	return false;
    }

    public String talk(Character c){
	Scanner sc1;
	System.out.println("Choices: /n 1. Say something nice /n 2. Say something evil /n 3. Say nothing");
	sc1 = new Scanner(System.in);
	int choice = sc1.nextInt();
	respond(choice,c);

	return "Generic talk";
    }

    public void respond(int i,Character c){
	if (i == 1){
	    health++;
	    System.out.println("You have delighted your comrade and he awards you with extra health!");
	}
	else if (i == 2){
	    System.out.println("You have made your enemy angry and are now being attacked!");
	    c.battle(this);
	}
	else if (i == 3){
	    System.out.println("Well, give nothing, get nothing!");
		}
    }
	    
	

    public String toString() {
	return name;
    }

    public void getInfo() {
	System.out.println("Name: " + name);
	System.out.println("Health: " + health);
	System.out.println("Max Health: " + maxHealth);
	System.out.println("Strength: " + strength);
	System.out.println("Dexterity: " + dexterity);
	System.out.println("Intelligence: " + intelligence);
	System.out.println("Experience: " + experience);
	System.out.println("Location: (" + x + "," + y + ")");
    }

    public int attack(Character other, int range, int weapon, String type) {
	int damage = 0;
	double d = distance(other);
	if (d  > range) {
	    System.out.println(other.name + " is too far away."); 
	    return damage;
	}

	Random r = new Random();
	int rolls = ((1 + r.nextInt(6)) + (1 + r.nextInt(6)) + (1 + r.nextInt(6)));

	if (rolls >= 16) {
	    System.out.println(this.name + " missed terribly."); 
	    return damage;
	}
	else if (rolls > (this.dexterity - (int)d + 1)) {
	    System.out.println(this.name + " missed.");
	    return damage;
	}
	else if (rolls == 4) {
	    if (type == 0)
		damage = this.strength * 2;
	    else if (type == 1)
		damage = this.intelligence * 2;
	    System.out.println(this.name + " critically hit " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
	else if (rolls == 3) {
	    if (type == 0)
		damage = (this.strength + weapon) * 3;
	    else if (type == 1)
		damage = (this.intelligence + weapon) * 3;
	    System.out.println(this.name + " devastated " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
	else {
	    if (type == 0)
		damage = this.strength + weapon;
	    else if (type == 1)
		damage = this.intelligence + weapon;
	    System.out.println(this.name + " hit " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
    }

    public int test(Character other, int range, int weapon, String type) {
	int damage = 0;
	double d = distance(other);
	if (d  > range) {
	    return damage; }
	

	if (type == 0)
	damage = this.strength + weapon;
	else if (type == 1)
	damage = this.intelligence + weapon;
	return damage;
	}
	
    public int attack(int type, Character other) {
	int damage = 0;	
	Random r = new Random();
	double d = distance(other);

	if (d > 1) {
	    System.out.println(other.name + " is too far away."); 
	    return damage; }

	int rolls = ((1 + r.nextInt(6)) + (1 + r.nextInt(6)) + (1 + r.nextInt(6)));

	if (rolls >= 16) {
	    System.out.println(this.name + " missed terribly."); 
	    return damage;
	}
	else if (rolls > this.dexterity) {
	    System.out.println(this.name + " missed.");
	    return damage;
	}
	else if (rolls == 4) {
	    damage = this.strength * 2;
	    System.out.println(this.name + " critically hit " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
	else if (rolls == 3) {
	    damage = this.strength * 3;
	    System.out.println(this.name + " devastated " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
	else {
	    damage = this.strength;
	    System.out.println(this.name + " hit " + other.name + " for " + damage + " points of damage!"); 
	    return damage;
	}
    }

    public int test(int type, Character other) {
	int damage = 0;
	double d = distance(other);

	if (d > 1) {
	    return damage; }

	damage = this.strength;
	return damage;
	}

   public int AIAttack(Character other) {
	int input = 0;
	int fdmg = 0;
	for(int i = 0; i < this.skills; i++) {
	int fdmg2 = this.test(i,other);
	fdmg = Math.max(fdmg,fdmg2);
	if (fdmg == fdmg2)
	input = i; }
	return input;
   }

    public void turnHelper(int h, Character c){
	if (h == 1){
	    battle(c);
	}
	if (h == 2){
	    talk(c);
	}
    }

    public void turn(){
	boolean living = true;
	while (living){
	    Scanner turnscan;
	    Character c = new Character();
	    System.out.println("You have approached a character. Please choose whether to 1. Initiate battle or 2. Initiate conversation.");
	    turnscan = new Scanner(System.in);
	    int choice = turnscan.nextInt();
	    turnHelper(choice,c);
	    if (health =< 0){
		living = false;
	    }
	}
	if (!living){
	    System.out.println("Oh no! You have died! The game is over. *cries*");
	    }
    }

    public void play(){
	boolean l = true;
	if (health <= 0){
	    l = false;
	}
	while (l){
	    turn();
	}
}
