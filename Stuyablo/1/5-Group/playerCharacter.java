import java.io.*;
import java.util.*;

public class playerCharacter extends Character {
    protected String role; 

    public playerCharacter (String name) {
	Scanner s = new Scanner(System.in);

	str = 8;
	dex = 8;
	intl = 8;
	def = 8;
	
	// NAME

	System.out.print("Please enter your Desired Name: ");
	name = s.nextLine();
	System.out.println("");

	// ROLE

	System.out.println(" Warrior");
	System.out.println(" Wizard");
	System.out.print("Which class would you like to be? ");
	role = s.nextLine();

	int q = 1;
	while (q>0) {
	    if (role.equals("Warrior") || role.equals("Wizard")) {
		q = q - 1;
	    }
	    else {
		System.out.println("This role does not exist");
		System.out.println("");
		System.out.println(" Warrior");
		System.out.println(" Wizard");
		System.out.print("Which class would you like to be? ");
		role = s.nextLine();
	    }
	}

	System.out.println("");

	// SKILL POINTS

	System.out.print("Do you wish to allocate your skill points Manually or Randomly? ");
	String a = s.nextLine();
	System.out.println("");

	if (a.equals("Manually")) {
	    int x = 8;
	    while (x>0){
		System.out.println("");
		System.out.println("You have " + x + " attribute points left");

		System.out.println("1. Strength");
		System.out.println("2. Dexterity");
		System.out.println("3. Intelligence");
		System.out.print("Select the number of the Attribute you would like to increase: ");
		int attIncrease = s.nextInt();

	        if (attIncrease == 1) {
		    str = str + 1;
		}
		else if (attIncrease == 2) {
		    dex = dex + 1;
		}
		else if (attIncrease == 3) {
		    intl = intl + 1;
		}
		else {
		    try {
			Thread.sleep(1000);
		    }
		    catch (Exception e) {		
		    }
		    System.out.println("The game has ended because you were not smart enough to select the correct number");
		    try {
			Thread.sleep(2500);
		    }
		    catch (Exception e) {		
		    }
		    System.out.println("Just Kidding. Please Retry.");
		    x = x + 1;
		}

		x = x - 1;
	    }
	}
	else {
	    Random f = new Random();
	    for(int x=8; x>0; x--) {
	        int y = f.nextInt(2);
		if (y==1) {
		    str = str + 1;
		}
		else if (y==2) {
		    dex = dex + 1;
		}
		else {
		    intl = intl + 1;
		}
	    }
	}

	init(name, str);
    }

    public void turn (String a) {
	Random r = new Random();
	
	if (a.equals("Flee")) {
	    
	}
    }
    
    public String getRole () {
	return role;
    }

    public String getStr() {
	return "Your Strength is " + str;
    }
    public String getDex() {
	return "Your Dexterity is " + dex;
    }
    public String getInt() {
	return "Your Intelligence is " + intl;
    }

}
