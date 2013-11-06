import java.util.*;
import java.io.*;
import java.math.*;

public class Elf extends Character {
    private String[] weapons = new String[]{"basic dagger", "broadsword", "longsword", "flaming sword", "master sword"};
    private int points;
    private Scanner sc = new Scanner(System.in);
    private boolean firstencounter = true;
    private boolean atk;

    public int addStat(String stat) {
	System.out.println("Add how many points to " + stat + " (0-" + points + ")");
	int number = sc.nextInt();
	if (number > points) {
	    System.out.println("You do not have that many points to add. Added all your points to " + stat + ".");
	    int result = points;
	    points = 0;
	    return result;
	}
	else {
	    System.out.println("Added " + number + " points to " + stat + ".");
	    points -= number;
	    return number;
	}
    }
    public Elf() {
	System.out.println("Please enter your name:");
	name = sc.nextLine();
	points = 8;
	dexterity = 9;
	strength = 8;
	intellegence = 9;
	level = 1;
	ep = 0;
	System.out.println("You have 8 points to add to the following stats: Strength, Dexterity, Intellegence");
	strength = strength + addStat("strength");
	dexterity = dexterity + addStat("dexterity");
	intellegence = intellegence + addStat("intellegence");
	hp = strength;
	mp = strength;
    }

    public boolean encounter(Character other) {	
	if (firstencounter == true)
	System.out.println("A wild " + other + " Appeared!");
	firstencounter = false;
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println("What would you like to do? Enter 1 for flee, 2 for attack");
	int whatdo = sc.nextInt();
	if (whatdo == 1)
	    return flee(other);
	if (whatdo == 2) {
	    atk = attack(other);
	    firstencounter = !atk;
	    return atk;
	}
	return encounter(other);
    }

    public boolean flee(Character other) {
	System.out.println("You attempt to flee...");
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	if (dexterity > other.getDexterity()) {
	    System.out.println("You got away safely!");
	    firstencounter = true;
	    return false;
	}
	System.out.println("You cannot escape!");
	return true;
    }
    public boolean attack(Character other){
	try{
	    Thread.sleep(1000);
	}
	catch(InterruptedException ex){
	    Thread.currentThread().interrupt();
	}
	if (roll()){
	    System.out.println(name + " deals " +(strength+dexterity)/4 + " damage with the " + weapons[strength/5]);
	    return other.changeHP((strength+dexterity)/4);
	}
	else {
	    System.out.println(name + " 's attack misses!");
	    return true;
	}
    }

    public boolean die() {
	System.out.println("you are dead.");
	firstencounter = true;
	return false;
    }
}
