import java.io.*;
import java.util.*;

public class Character {
   
    protected String name;
    protected String charclass="none";
    protected int health,maxHealth;
    protected int dex,str;
    protected int points;
    protected int exp=0,lvl=1;
	   
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

    /*
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
    */


    public String toString() {
        return name;
    }

    public Character() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII.\nEnter your name: ");
	name = sc.nextLine();
	System.out.println("Hello " + name);
	setClass();
    }

    public void	setClass() {
	Scanner sc = new Scanner(System.in);
	System.out.print("You may be a Warrior or a Theif. Select your class: ");
	if (sc.nextLine().equals("Warrior")) {
	    System.out.println("\nYou have selected the Warrior!\n");
	    setWarrior();
	}
	else if (sc.nextLine().equals("Theif")) {
	    System.out.println("\nYou have selected the Theif!\n");
	    setTheif();
	}
	else {
	    System.out.println("Sorry, that is not a class.");
	    setClass();
	}
    }

    public void setWarrior() {
	str = 12;
	dex = 4;
	health = str;
	Scanner sc = new Scanner(System.in);
	System.out.println("Strength: " + str);
	System.out.println("Dexterity: " + dex);
	setStat();
    }

    public void setTheif() {
	System.out.println("hello");
    }

    public void setStat() {
	points = 8;
	Scanner sc = new Scanner(System.in);
	System.out.println("You have " + points + " skill points available.");
	System.out.print("Strength + ");
	if (sc.nextInt() > points) {
	    System.out.println("Sike! Try again");
	    setStat();
	}
	else {	
	    int addS = sc.nextInt();
	    str = str + addS;
	    points = points - addS;
	    System.out.println("You still have " + points + " skill points available");
	}
	System.out.print("Dexterity + ");
	if (sc.nextInt() > points) {
	    System.out.println("Nah... try again");
	    setStat();
	}
	else {
	    int addD = sc.nextInt();
	    dex = dex + addD;
	    points = points - addD;
	    System.out.println("You still have " + points + " skill points available");
	}
	if (points > 0) {
	    System.out.println("Your remaining skill points will be destroyed! teehee");
	}
    }

    public int getHealth() {
	return health;
    }

    public String getCharclass() {
	return charclass;
    }

}

