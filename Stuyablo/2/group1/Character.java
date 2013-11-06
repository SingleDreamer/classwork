import java.io.*;
import java.util.*;

public class Character {
   
    protected String name;
    protected String charclass="none";
    protected int health,maxHealth;
    protected int dexterity=8,strength=8,intelligence;
    protected int points;
    protected int exp=0,lvl=1;
    protected int x,y;

    public String getName() {
	return name;
    }
	   
    public void attack(Character other) {
        System.out.println("Sissy Slap!");
    }
    
    public void takeDamage(int amount) {
	    health -= amount;
	    if(health < 0)
		    health = 0;
    }

    public boolean flee() {
	    Random r = new Random();
	    if(r.nextFloat() > 0.35)
	    {
		    System.out.println("Got away safely");
		    return true;
	    }
	    System.out.println("Failed to escape");
	    return false;
	
    }

    public boolean hit() {
	Random r = new Random();
	int d1,d2,d3,sum;
	d1 = r.nextInt(6) + 1;
	d2 = r.nextInt(6) + 1;
	d3 = r.nextInt(6) + 1;
	sum = d1 + d2 + d3;
	return (sum <= dexterity);
    }

    public void encounter(Character other) {
        while (other.getHealth() > 0 && this.getHealth() > 0){
	    System.out.print("(1)Fight or (2)Flee\n");
	    Scanner sc = new Scanner(System.in);
	    String input = sc.nextLine();
	    if (input.equals("1")){
		this.attack(other);
		other.attack(this);
		}
	    else if (input.equals("2")){
		this.flee();
	    }
	    else {
		System.out.println("Invalid choice");
	    }
	    System.out.println("Your Health: " + this.getHealth());
	    System.out.println("Enemy Health: " + other.getHealth());
	    System.out.println("-------------------------------");
	}
    }

    /*
    public String getStatus() {
      String attrib1=String.format("Str: %d Dex: %d Int: %d", strength, dexterity, intelligence);
      String attrib2=String.format("Exp: %d Health: %d of %d", exp,health,maxHealth);
      String locale = String.format("x: %5.2f y: %5.2f",x,y);
      String whole=String.format("%s\n%s\n%s\n%s\n", name,attrib1,attrib2,locale);
      return whole;
    }
    */


    public String toString() {
        return name;
    }

    /* public Character() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII.\nEnter your name: ");
	name = sc.nextLine();
	System.out.println("Hello " + name);
	strength = dexterity = intelligence = 8;
	setStat();
	health = maxHealth = strength;
    }
    */

    public void setChar() {
	Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
	System.out.print("What would you like to be? Warrior? Wizard? ");
	if (sc.nextLine().equals("Warrior")) {
=======
	System.out.print("What would you like to be? Warrior? Wizard?\n");
	String input = sc.nextLine();
	if (input.equals("Warrior")) {
	    Warrior w = new Warrior(name);
>>>>>>> ef390c44a389a69826bae6a12f99a52ebb10f42d
	    System.out.println("Woo, You're a warrior");
	    Warrior w = new Warrior(name);
	}
<<<<<<< HEAD
	else if (sc.nextLine().equals("Wizard")) {
=======
	else if (input.equals("Wizard")) {
	    Wizard w = new Wizard(name);
>>>>>>> ef390c44a389a69826bae6a12f99a52ebb10f42d
	    System.out.println("Woo, you're a Wizard");
	    Wizard w = new Wizard(name);
	}
	else {
	    System.out.println("Silly you, ponies aren't a choice");
	    setChar();
	}
    }

    //SETCLASS IS DEFINITELY NOT THE RIGHT WAY TO DO THIS
    //
    //public void setWarrior() {
    //    strength = 12;
    //    dexterity = 4;
    //    health = strength;
    //    Scanner sc = new Scanner(System.in);
    //    System.out.println("Strength: " + strength);
    //    System.out.println("Dexterity: " + dexterity);
    //    setStat();
    //}


    public void setStat() {
	points = 8;
	Scanner sc = new Scanner(System.in);

	System.out.println("You have " + points + " skill points available.");
	System.out.print("Strength = 8 + :\n");
	int add = sc.nextInt();
	if (add > points){
	    add = points;
	    System.out.printf("Only able to add %d points\n",add);
	}
        strength = strength + add;
	health = strength;
        points = points - add;
	System.out.println("-------------------------------");
        System.out.println("You still have " + points + " skill points available");
	System.out.print("Dexterity = 8 + :\n");
	add = sc.nextInt();
	if (add > points) {
	    add = points;
	    System.out.printf("Only able to add %d points\n",add);
	}

	dexterity = dexterity + add;
	points = points - add;
	
	System.out.printf("%d points put into dexterity\n",add);
	System.out.println("-------------------------------");
	System.out.printf("Remaining %d points put into intelligence\n",points);
	intelligence += points;
    }

    public int getHealth() {
	return health;
    }

    public boolean alive()
    {
	    return health > 0;
    }

    public int aliveState(Character other)
    {
	    if(alive())
	    {
		if(other.alive())
			return 5;
		else
			return 3;
	    }
	    else
	    {
		if(other.alive())
			return 2;
	    	else
			return 4;
	    }
    }

    public String getCharclass() {
	return charclass;
    }


}

