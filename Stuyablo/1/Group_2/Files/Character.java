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

    private Random r = new Random();

    protected void init(String name, int health, int m, int i, int d, int s, int e, double x, double y, int base) {
	this.name = name;
	this.health=health;
	maxHealth = m;
	intelligence = i + base;
	dexterity = d + base;
	strength = s + base;
	experience = e;
	this.x = x;
	this.y = y;
    }
    
    public Character() {
	init("No Name",50,100,8,8,8,0,0,0,8);
    } 
    public Character(String name) {
	init(name,50,100,8,8,8,0,0,0,8);
    }
    public Character(String name,int di,int dd,int ds,int limit,int db,boolean pc,boolean preset) {
	if (preset) {
		init(name,50,100,di,dd,ds,0,0,0,db);}
	else {
	boolean sure = false;
	if (pc) {
	di = 0;
	dd = 0;
	ds = 0;
	int total = 0;
	while (!sure || total >= limit || total < 0) {
	if (total >= limit || total < 0)
		System.out.println("Stats invalid. Try again");		
	di = 0;
	dd = 0;
	ds = 0;
	System.out.print("What is your name? ");
	Scanner scn = new Scanner(System.in);
	name = scn.nextLine();
	System.out.println("Now time to enter your stats. Remember that you get 8 points in every stat, and can put 8 extra points wherever.");

	System.out.print("Enter desired extra intelligence points: ");
	Scanner sci = new Scanner(System.in);
	di = sci.nextInt();
	System.out.println(" ");

	System.out.print("Enter desired extra dexterity points: ");
	Scanner scd = new Scanner(System.in);
	dd = scd.nextInt();
	System.out.println(" ");

	System.out.print("Enter desired extra strength points: ");
	Scanner scs = new Scanner(System.in);
	ds = scs.nextInt();
	System.out.println(" ");

	System.out.println("Name: " + name + " Int: " + di + " Dex: " + dd + " Str: " + ds);
	System.out.println("Are these okay y/n?"); 
	Scanner sc = new Scanner(System.in);
	if (sc.nextLine().equals("y"))
		sure = true;
	else if (sc.nextLine().equals("n"))
		sure = false;
	while (!sure && !sc.nextLine().equals("n")) {
	System.out.println("Please enter y for yes or n for no");
	sc = new Scanner(System.in);
	if (sc.nextLine().equals("y"))
		sure = true;
	else if (sc.nextLine().equals("n"))
		sure = false;
	total = di + dd + ds; }}
	System.out.println("Your Character " + name + " has been created!!"); }
	else if (!pc) {
 	Random r = new Random();
	di = r.nextInt(limit + 1);
	dd = r.nextInt(limit - di + 1);
	ds = limit - di - dd;}	
	init(name,50,100,di,dd,ds,0,0,0,db);

    }}

    public double distance(Character other){
	return Math.sqrt(((other.x - x)*(other.x - x))+((other.y - y)*(other.y - y)));
    }

    public void battle(Character other) {
	if (this.dexterity >= other.dexterity) {
	other.health = other.health - this.attack(other);
	this.health = this.health - other.attack(this);
	System.out.println(this.name + "'s hp: " + this.health);
	System.out.println(other.name + "'s hp: " + other.health); }
	else {
	this.health = this.health - other.attack(this);
	other.health = other.health - this.attack(other);
	System.out.println(other.name + "'s hp: " + other.health);
	System.out.println(this.name + "'s hp: " + this.health); }
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

    public String talk(){
	return "Generic talk";
    }



    public String toString() {
	return name;
    }

    public int attack(Character other) {
	System.out.println(this.name + " attacked " + other.name);
	Random r = new Random();
	int Rolls = ((1 + r.nextInt(6)) + (1 + r.nextInt(6)) + (1 + r.nextInt(6)));
	if (Rolls >= 16) {
	System.out.println(this.name + " missed terribly"); 
	return 0; }
	else if (Rolls >= this.dexterity && Rolls < 16) {
	System.out.println(this.name + " missed");
	return 0; }
	else if (Rolls == 4) {
	int damage = this.strength * 2;
	System.out.println(this.name + " critically hit " + other.name + " for " + damage + " points of damage!"); 
	return damage; }
	else if (Rolls == 3) {
	int damage = this.strength * 3;
	System.out.println(this.name + " devastated " + other.name + " for " + damage + " points of damage!"); 
	return damage; }
	//Javac was acting weird because no return statement outside of these if statements, so the last case isn't in an else
	int damage = this.strength;
	System.out.println(this.name + " hit " + other.name + " for " + damage + " points of damage!"); 
	return damage; 
	}
}
