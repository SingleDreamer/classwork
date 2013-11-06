public class Driver {
    public static void main(String[] args) {

	Scanner scanner = new Scanner();

	System.out.println("Enter your name: ");
	try {
	    Thread.sleep(2000); // pauses for 2 seconds
	}
	catch (Exception a){
	    // intentionally empty...nothing happens
	}

	String name = "";
	name = scanner.nextLine();
	System.out.println("Hello " + name + " \n");

	Scaanner scan2 = new Scanner();
	System.out.println("Type a number to choose a type: 1 - Mr. Moran, 2 - Wizard, 3 - Ms. Zhang: ");

	String inputs = "";

	inputs = scan2.nextLine();

	if (inputs == 1)

	Character player = new Character();
	System.out.println(player.getStatus());
	

	// input name, options for names, create an init
    }
}
