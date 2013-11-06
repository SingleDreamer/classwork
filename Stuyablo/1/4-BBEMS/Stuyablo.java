import java.util.*;

public class Stuyablo {
	public static boolean isInRange(int x, int a, int b) {return ((x >= a) && (x <= b));} //tests if a <= x <= b	
	public static boolean isInRangeExclusive(int x, int a, int b) {return ((x > a) && (x < b));} //tests if a < x < b
	public static void main(String[] args) {
	    printLogo();
	    System.out.print("Press Enter or enter any character(s) to begin: ");
	    Scanner scanner = (new Scanner(System.in)).useDelimiter(" ");
	    while (!(scanner.hasNext())) {} //waits for input
	    
	    System.out.println("Press Ctrl + C to quit at any time.");
	    
	    scanner = new Scanner(System.in); //intentional, to clear any input from the previous scanner instance
	    
	    Character player = new Character ();
	    //Name
	    System.out.print("Enter name: ");
	    boolean input = false; //method to check input here is slightly different when actually looking for a specific input, rather than simply any input at all. Is there a more efficient method to do this?
	    String name = "";
	    while (!input) {
		name = (scanner.nextLine()).trim();
		if (!(name.equals(""))) {input = true;}
	    }
	    System.out.println("" + name + "\n");
	    
	    //Class
	    System.out.print("Select a class (0 - Random, 1 - Warrior, 2 - Wizard, 3 - Thief): ");
	    input = false;
	    String _class = "";
	    while (!input) {
		_class = (scanner.nextLine()).trim();
		if ((_class.equals("0")) || (_class.equals("1")) || (_class.equals("2")) || (_class.equals("3"))) {input = true;} //is there a more efficient method to do this line?
	    }
	    Random random = new Random();
	    if (_class.equals("0")) {_class = String.valueOf(random.nextInt(3) + 1);} //keep forgetting that it's equals() and not ==, as in Python
	    
	    if (_class.equals("1")) {
		_class = "Warrior";
		player = new Warrior (name);
	    }
	    if (_class.equals("2")) {
		_class = "Wizard";
		player = new Wizard (name);
	    }
	    if (_class.equals("3")) {
		_class = "Thief";
		player = new Thief (name);
	    }

	     random.nextInt (3) = int z;

	    while (!(player.getHealth()=0)) { 
	    
	    System.out.println(player);
	    
	  

	    if (z = 0) {
	    Wizard opponent = new Wizard();
	    player.attack(opponent);
	    player.setOpponentsDefeated(player.getOpponentsDefeated() + 1);

	    }

	    if (z = 1) {
	    Warrior opponent = new Warrior();
	    player.attack(opponent);
	    player.setOpponentsDefeated(player.getOpponentsDefeated() + 1);

	    }

	    if (z = 2) {
	    Thief opponent = new Thief();
	    player.attack(opponent);
	    player.setOpponentsDefeated(player.getOpponentsDefeated() + 1);

	    }

	    }

	    System.out.println (player);
	    Sytsem.out.println ("You have killed" + player.getopponentsDefeated() + "opponents!");
	    
	    
	    System.out.println("\nProgram terminated.");
	}
    // Sean Yip's ASCII Logo thing. Made it into a separate static method to clean main method clean - EL
    public static void printLogo() {
	System.out.println("Welcome to");
	System.out.println("  _________ __                      ___.   .__          ");
	System.out.println(" /   _____//  |_ __ __ ___.__._____ \\_ |__ |  |   ____  ");
	System.out.println(" \\_____  \\\\   __\\  |  <   |  |\\__  \\ | __ \\|  |  /  _ \\ ");
	System.out.println(" /        \\|  | |  |  /\\___  | / __ \\| \\_\\ \\  |_(  <_> )");
	System.out.println("/_______  /|__| |____/ / ____|(____  /___  /____/\\____/ ");
	System.out.println("        \\/             \\/          \\/    \\/             "); //ASCII art doesn't exactly look right in code. Got to use "//" for every backslash (/) for the correct escape sequence
    }	
}
