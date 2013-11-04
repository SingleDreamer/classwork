import java.io.*;
import java.util.*;

public class playerCharacter extends Character {

    public playerCharacter (String name) {
	super();

	Scanner s = new Scanner(System.in);
	System.out.print("Please enter your Desired Name: ");
	name = s.nextLine();

	System.out.print("Please enter your Desired Health: ");	
	int health = s.nextInt();

	init(name,health);
    }

    public String attack() {
	return "pCharac Attack";
    }

}
