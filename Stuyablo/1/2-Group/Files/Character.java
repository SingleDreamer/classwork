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
    protected boolean pc;
    protected int movement;

    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();

    protected void init(String n, int h, int m, int s, int d, int i, int e, double x, double y, boolean playable) {
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
	pc = playable;
	movement = 10;
    }

    public Character(String name, int limit) {
	Random r = new Random();
	int str = r.nextInt(limit + 1);
	int dex = r.nextInt(limit + 1 -str);
	int inte = limit-str-dex;
	init(name,50,100,str,dex,inte,0,0.0,0.0,false);
    }
    
    public Character() {        //For player character
	boolean valid, sure;
	int str = 0, dex = 0, inte = 0;
	String yn;
	sure = false;

	while (!sure) {
	    System.out.print("What is your name? ");
	    name = sc.next();
	    System.out.println("Now time to enter your stats. Remember that you get 8 points in every stat and can put 8 extra points wherever.");
	    System.out.println();
		
	    valid = false;
	    while (!valid) {
		System.out.print("Enter desired extra strength points: ");
		str = sc.nextInt();

		System.out.print("Enter desired extra dexterity points: ");
		dex = sc.nextInt();

		System.out.print("Enter desired extra intelligence points: ");
		inte  = sc.nextInt();
		
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
		yn = sc.next();
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
	init(name,50,100,str,dex,inte,0,0.0,0.0,true);
    }

    public double distance(Character other) {
	return Math.sqrt(((other.x - x)*(other.x - x))+((other.y - y)*(other.y - y)));
    }

    public void battle(Character c2, Character c1) {
	while (c1.health > 0 && c2.health > 0) {
		if (c1.dexterity >= c2.dexterity) {
		    c1.action(c1, c2);
		    c2.action(c2, c1);
		    System.out.println(c1.name + "'s hp: " + c1.health);
		    System.out.println(c2.name + "'s hp: " + c2.health);
		}
		else {
		    c2.action(c2, c1);
		    this.action(c1, c2);
		    System.out.println(c2.name + "'s hp: " + c2.health);
		    System.out.println(c1.name + "'s hp: " + c1.health);
		}
	}
	if (c1.health <= 0)
	    System.out.println(c1.name + " has died!");
	else
	    System.out.println(c2.name + " has died!");
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
	System.out.println("Choices: 1. Say something nice 2. Say something evil 3. Say nothing");
	int choice = sc.nextInt();
	respond(choice,c);

	return "Generic talk";
    }

    public void respond(int i,Character c){
	if (i == 1){
	    //health++;
	    System.out.println("You have delighted your comrade and he awards you with extra health!");
	}
	else if (i == 2){
	    System.out.println("You have made your enemy angry and are now being attacked!");
	    c.battle(c, this);
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

    public int attack(Character other, int range, int weapon, int type) {
	int damage = 0;
	double d = distance(other);
	if (d  > range) {
	    System.out.println(other.name + " is too far away."); 
	    return damage; }
	

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

    public int attack(int a, Character b) {return 0;} //Will be overridden

    public int test(Character other, int range, int weapon, int type) {
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
	for(int i = 0; i <= this.skills; i++) {
	    int fdmg2 = this.test(i,other);
	    fdmg = Math.max(fdmg,fdmg2);
	    if (fdmg == fdmg2)
		input = i; }
	return input;
    }

    public int command(Character c1, Character c2) {
	int choice = 0;
	if (c1.pc) {
	    System.out.println("Enter 1 to attack, 2 to move, or 3 to flee");
	    choice = sc.nextInt();
	    
	    while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
		System.out.println(choice);
		System.out.println("Enter 1 to attack, 2 to move, or 3 to flee");
		choice = sc.nextInt();
	    }
	    
	}
	else
	    choice = AI(c1,c2);

	return choice;
    }

    public void action(Character c1, Character c2) {  //c1's turn
	int moved = c1.movement;
	boolean turn = true;
	//boolean talked = false;

	while (turn && moved > 0) {
	    int command = command(c1,c2);
	    switch(command) {
	    case 1:
		if (c1.pc) {
		    System.out.println("Choose an attack: ");
		    c2.health = c2.health - c1.attack(sc.nextInt(),c2);
		}
		else
		    c2.health = c2.health - c1.attack(AIAttack(c2),c2);
		turn = false;
		break;
	    
	    case 2:
		if (c1.pc) {
		    int direction;
		    int distance = -1;
		    System.out.println("Choose a direction to move in. 1 for north, 2 for northeast, 3 for east, 4 for south east, 5 for south, 6 for southwest, 7 for west, and 8 for northwest");
		    direction = sc.nextInt();
		    while (!("12345678".contains(""+direction))) {
			System.out.println("That is not a valid option");
			direction = sc.nextInt();
		    }
		    
		    String range = "";
		    for (int i = 0; i <= moved; i++) {
			range = range + i; }
		    System.out.println("Move how far? You can move up to " + moved + "yards");
		    distance = sc.nextInt();
		    while (distance < 0 || distance > moved) {
			while (range.indexOf(""+distance) == -1) {
			    System.out.println("Move how far? You can move up to " + moved + "yards");
			}
			
		    }
		    moved = moved - move(direction,distance);
		}
	
		else
		    moved = moved - AIMove(c2,moved); 
		System.out.println(c1.name + "'s current location: " + c1.x + "," + c1.y);
		break;

		/*case 3:
		if (talked)
		    System.out.println(c1.name + " already tried talking");
		else {
		    talk(c2);
		    talked = true;
		}
		break;*/

	    case 3:
		if(flee(c2)){
		    System.out.println(c1 + " was able to flee!");
		    turn();
		}
		else{
		    System.out.println(c1 + " was unable to flee!");
		}
		break;
	    }

	    if (turn && moved > 0)
		command = command(c1, c2);
	}
    }


    public int move(int direction, int distance) {
	if (direction == 1)
	    this.y = this.y + distance;

	if (direction == 2) {
	    this.y = this.y + (distance * Math.sqrt(.5));
	    this.x = this.x + (distance * Math.sqrt(.5));
	}

	else if (direction == 3)
	    this.x = this.x + distance;

	if (direction == 4) {
	    this.y = this.y - (distance * Math.sqrt(.5));
	    this.x = this.x + (distance * Math.sqrt(.5));
	}

	if (direction == 5)
	    this.y = this.y - distance;

	if (direction == 6) {
	    this.y = this.y - (distance * Math.sqrt(.5));
	    this.x = this.x - (distance * Math.sqrt(.5));
	}

	if (direction == 7)
	    this.x = this.x - distance;

	if (direction == 8) {
	    this.y = this.y + (distance * Math.sqrt(.5));
	    this.x = this.x - (distance * Math.sqrt(.5));
	}
	return distance;	
    }

    public int AIMove(Character other, int potential) {
	Random r = new Random();
	double chance = r.nextDouble();
	if (this.health > this.maxHealth/2) {
	    if (distance(other) >= potential)
		return move(face(other,1),potential);
	    else
		return move(face(other,1),((int)(distance(other)/2)+r.nextInt((int)(distance(other)/2))));
	}
	
	else if (this.health <= this.maxHealth/2 && this.health >= this.maxHealth/5) {
	    if (chance >= .25) {
		if (distance(other) >= potential)
		    return move(face(other,1),potential);
		else
		    return move(face(other,1),(((int)distance(other)/2)+r.nextInt(((int)distance(other)/2))));
	    }
	    else 
		return move(face(other,0),((potential/2 + r.nextInt(potential/2))));
	}

	else {
	    if (chance >= .5)
		return move(face(other,-1),((potential/2 + r.nextInt(potential/2)))); 
	    else if (chance	< .5 && chance >= .4)
		return move(face(other,0),((potential/2 + r.nextInt(potential/2))));
	    else {
		if (distance(other) >= potential)
		    return move(face(other,1),potential);
		else
		    return move(face(other,1),(((int)distance(other)/2)+r.nextInt(((int)distance(other)/2))));
	    }
	}

    }

    public int face(Character other, int direction) { 
	double xdiff = other.x - this.x;
	double ydiff = other.y - this.y;
	Random r = new Random();
	if (xdiff > 0 && ydiff > 0) {
	    if (direction == 1)
		return 2;
	    else
		return 5 + r.nextInt(3);
	}		

	else if (xdiff > 0 && ydiff == 0) {
	    if (direction == 1)
		return 3;
	    else {
		if (5 + r.nextInt(5) > 8)
		    return 1;
		else
		    return 5 + r.nextInt(4);
	    }
	}

	else if (xdiff > 0 && ydiff < 0) {
	    if (direction == 1)
		return 4;
	    else {
		if (7 + r.nextInt(3) > 8)
		    return 1;
		else
		    return 7 + r.nextInt(2);
	    }
	}

	else if (xdiff < 0 && ydiff > 0) {
	    if (direction == 1)
		return 8;
	    else
		return 3 + r.nextInt(3);
	}
	
	else if (xdiff < 0 && ydiff == 0) {
	    if (direction == 1)
		return 7;
	    else
		return 1 + r.nextInt(5);
	}

	else if (xdiff < 0 && ydiff < 0) {
	    if (direction == 1)
		return 6;
	    else
		return 1 + r.nextInt(3);
	}

	else if (xdiff == 0 && ydiff > 0) {
	    if (direction == 1)
		return 1;
	    else
		return 3 + r.nextInt(5);
	}

	else if (xdiff == 0 && ydiff < 0) {
	    if (direction == 1)
		return 5;
	    else {
		if (7 + r.nextInt(5) > 8)
		    return 1 + r.nextInt(3);
		else
		    return 7 + r.nextInt(1);
	    }
	}
	else
	    return 1 + r.nextInt(8);
    }
    public void turnHelper(int h, Character c){
	if (h == 1){
	//    battle(c);
	}
	if (h == 2){
	    talk(c);
	}
    }

    public void turn(){
	boolean living = true;
	while (living){
	    //Character c = new Character();
	    Character c = new Character("Enemy",8);
	    System.out.println("You have approached a character. Please choose whether to 1. Initiate battle or 2. Initiate conversation.");
	    int choice = sc.nextInt();
	    turnHelper(choice,c);
	    if (health <= 0){
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
    public int AI(Character c1, Character c2) {
	if (c1.test(AIAttack(c2),c2) > 0)
	    return 1;
	else
	    return 2;
    }
}
