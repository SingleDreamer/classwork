import java.util.*;
import java.io.*;
import java.math.*;

public class Player extends Character {
    private int points;
    private Scanner sc = new Scanner(System.in);

    public int addStat(String stat) {
	System.out.println("Add how many points to" + stat + " (0-" + points + ")");
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
    public Player() {
	System.out.println("Please enter your name:");
	name = sc.nextLine();
	points = 8;
	dexterity = 8;
	strength = 8;
	intellegence = 8;
	level = 1;
	ep = 0;
	System.out.println("You have 8 points to add to the following stats: Strength, Dexterity, Intellegence");
	strength = strength + addStat("strength");
	dexterity = dexterity + addStat("dexterity");
	intellegence = intellegence + addStat("intellegence");
	hp = strength;
	mp = strength;
    }
}