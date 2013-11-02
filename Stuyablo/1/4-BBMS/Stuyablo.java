import java.util.*;

public class Stuyablo {
	public static boolean isInRange(int x, int a, int b) {return ((x >= a) && (x <= b));} //tests if a <= x <= b
	
	public static boolean isInRangeExclusive(int x, int a, int b) {return ((x > a) && (x < b));} //tests if a < x < b
		
	public static void main(String[] args) {
		System.out.println("Welcome to");
		System.out.println("  _________ __                      ___.   .__          ");
		System.out.println(" /   _____//  |_ __ __ ___.__._____ \\_ |__ |  |   ____  ");
		System.out.println(" \\_____  \\\\   __\\  |  <   |  |\\__  \\ | __ \\|  |  /  _ \\ ");
		System.out.println(" /        \\|  | |  |  /\\___  | / __ \\| \\_\\ \\  |_(  <_> )");
		System.out.println("/_______  /|__| |____/ / ____|(____  /___  /____/\\____/ ");
		System.out.println("        \\/             \\/          \\/    \\/             "); //ASCII art doesn't exactly look right in code. Got to use "//" for every backslash (/) for the correct escape sequence
		System.out.print("Press Enter or enter any character(s) to begin: ");
		Scanner scanner = (new Scanner(System.in)).useDelimiter("");
		while (!(scanner.hasNext())) {} //waits for input
		
		System.out.println("Press Ctrl + C to quit at any time.");
		
		Character player = new Character();
		scanner = new Scanner(System.in); //intentional, to clear any input from the previous scanner instance
		
		//Name
		System.out.print("Enter name: ");
		boolean input = false; //method to check input here is slightly different when actually looking for a specific input, rather than simply any input at all. Is there a more efficient method to do this?
		String name = "";
		while (!input) {
			name = (scanner.nextLine()).trim();
			if (!(name.equals(""))) {input = true;}
		}
		player.setName(name);
		System.out.println(player.getName() + "\n");
		
		//Class
		System.out.print("Select a class (0 - Random, 1 - Class 1, 2 - Class 2, 3 - Class 3): ");
		input = false;
		String _class = ""; //lol, too lazy to think of any creative name
		while (!input) {
			_class = (scanner.nextLine()).trim();
			if ((_class.equals("0")) || (_class.equals("1")) || (_class.equals("2")) || (_class.equals("3"))) {input = true;} //is there a more efficient method to do this line?
		}
		Random random = new Random();
		if (_class.equals("0")) {_class = String.valueOf(random.nextInt(3) + 1);} //keep forgetting that it's equals() and not ==, as in Python
		if (_class.equals("1")) {_class = "Class 1";}
		if (_class.equals("2")) {_class = "Class 2";}
		if (_class.equals("3")) {_class = "Class 3";}
		player.setCharacterClass(_class);
		System.out.println(player.getCharacterClass() + "\n");
		
		//Stats (Not class-specific)
		System.out.println("Stats:");
		String answer = "";
		boolean yes = false;
		int attribute1 = 0, attribute2 = 0, attribute3 = 0, attribute4 = 0;
		while (!yes) {
			attribute1 = random.nextInt(11) + 5;
			System.out.println("Attribute 1: " + attribute1);
			attribute2 = random.nextInt(11) + 5;
			System.out.println("Attribute 2: " + attribute2);
			while (!(isInRange(attribute1 + attribute2 + attribute3, 25, 39))) {attribute3 = random.nextInt(11) + 5;}
			System.out.println("Attribute 3: " + attribute3);
			attribute4 = 40 - (attribute1 + attribute2 + attribute3);
			System.out.println("Attribute 4: " + attribute4);
			
			System.out.print("Accept these stats (y/n)? ");
			input = false;
			while (!input) {
				answer = (scanner.nextLine()).trim();
				if ((answer.equals("y")) || (answer.equals("n"))) {input = true;}
			}
			if (answer.equals("y")) {yes = true;}
			System.out.println("");
		}
		player.setAttribute1(attribute1);
		player.setAttribute2(attribute2);
		player.setAttribute3(attribute3);
		player.setAttribute4(attribute4);
		
		System.out.println(player);
		
		//
		System.out.println("\nProgram terminated.");
	}
}
