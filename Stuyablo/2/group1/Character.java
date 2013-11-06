import java.io.*;
import java.util.*;

public class Character {
   
    protected String name;
    protected String charclass="none";
    protected int health,maxHealth;
    protected int dexterity,strength,intelligence;
    protected int points;
    protected int exp=0,lvl=1;
    protected int x,y;
	   
    public void attack(Character other) {
        /* do the attack:
	   print out the attempt and the result and update
	   all relavent variables
        */
    }

    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
	return true;
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
        return 0;
    }

    public String getStatus() {
      String attrib1=String.format("Str: %d Dex: %d Int: %d", strength, dexterity, intelligence);
      String attrib2=String.format("Exp: %d Health: %d of %d", experience,health,maxhealth);
      String locale = String.format("x: %5.2f y: %5.2f",x,y);
      String whole=String.format("%s\n%s\n%s\n%s\n", name,attrib1,attrib2,locale);
      return whole;
    }


    public String toString() {
        return name;
    }

    public Character() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII.\nEnter your name: ");
	name = sc.nextLine();
	System.out.println("Hello " + name);
	setStat();
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
	System.out.print("Strength = 8 + :");
	int add = sc.nextInt();
	if (add > points){
	    add = points;
	    System.out.printf("Only able to add %d points\n",add);
	}
        strength = strength + add;
        points = points - add;

        System.out.println("You still have " + points + " skill points available");
	add = sc.nextInt();
	System.out.print("Dexterity = 8 + :");
	if (add > points) {
	    add = points;
	    System.out.printf("Only able to add %d points\n",add);
	}

	dexterity = dexterity + add;
	points = points - add;
	
	System.out.printf("Remaining %d points put into intelligence",points);
	intelligence += points;
    }

    public int getHealth() {
	return health;
    }

    public String getCharclass() {
	return charclass;
    }

}

