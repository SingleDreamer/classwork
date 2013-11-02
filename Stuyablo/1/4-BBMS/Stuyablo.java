import java.util.*;

public class Stuyablo {
	public static void main(String[] args) {
		System.out.println("Welcome to");
		System.out.println("  _________ __                      ___.   .__          ");
		System.out.println(" /   _____//  |_ __ __ ___.__._____ \\_ |__ |  |   ____  ");
		System.out.println(" \\_____  \\\\   __\\  |  <   |  |\\__  \\ | __ \\|  |  /  _ \\ ");
		System.out.println(" /        \\|  | |  |  /\\___  | / __ \\| \\_\\ \\  |_(  <_> )");
		System.out.println("/_______  /|__| |____/ / ____|(____  /___  /____/\\____/ ");
		System.out.println("        \\/             \\/          \\/    \\/             ");
		System.out.print("Press Enter or enter any character(s) to begin: ");
		Scanner scanner = (new Scanner(System.in)).useDelimiter("");
		while (!(scanner.hasNext())) {} //waits for input
		
		scanner = new Scanner(System.in); //intentional, to clear any input from the previous scanner instance
		
		//Name
		System.out.print("Enter name: ");
		boolean wait_for_input = true; //method to check input here is slightly different when actually looking for a specific input, rather than simply any input at all. Is there a more efficient method to do this?
		String name = "";
		while (wait_for_input) {
			name = (scanner.nextLine()).trim();
			if (!(name.equals(""))) {wait_for_input = false;}
		}
		System.out.println("Name: " + name + "\n");
		
		//Class
		System.out.print("Select a class (0 - Random, 1 - Class 1, 2 - Class 2, 3 - Class 3): ");
		wait_for_input = true;
		String _class = ""; //lol, too lazy to think of any creative name
		while (wait_for_input) {
			_class = (scanner.nextLine()).trim();
			if ((_class.equals("0")) || (_class.equals("1")) || (_class.equals("2")) || (_class.equals("3"))) {wait_for_input = false;} //is there a more efficient method to do this line?
		}
		Random random = new Random();
		if (_class.equals("0")) {_class = String.valueOf(random.nextInt(3) + 1);} //keep forgetting that it's equals() and not ==, as in Python
		if (_class.equals("1")) {_class = "Class 1";}
		if (_class.equals("2")) {_class = "Class 2";}
		if (_class.equals("3")) {_class = "Class 3";}
		System.out.println("Class: " + _class + "\n");
		
		//
		System.out.println("\nProgram terminated.");
	}
}
