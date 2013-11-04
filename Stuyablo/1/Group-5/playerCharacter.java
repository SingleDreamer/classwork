import java.io.*;
import java.util.*;

public class playerCharacter extends Character {

    public playerCharacter (String name) {
	Scanner s = new Scanner(System.in);

	System.out.print("Please enter your Desired Name: ");
	name = s.nextLine();
	
	System.out.print("Please enter your Desired Health: ");	
	int health = s.nextInt();

	/*
	System.out.print("Do you want to allocate your skill points Manually or Randomly?");
	String a = s.nextLine();

	if (a.equals("Manually")) {
	    System.out.print("How many points do you want to allocate into Str?");
	    int strength = s.nextInt();
	    str = str + strength;
        }
	*/

	init(name, health);
    }

    public String attack() {
	return "pCharac Attack";
    }

    public String getStr() {
	return "Your Strength is " + str;
    }

}
