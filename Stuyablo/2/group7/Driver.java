import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter your name: ");
    	String name = sc.nextLine();
    	System.out.println("\nChoose your class:\n\nWarrior\nWizard\nThief\n");
    	String pClass = sc.nextLine();
    	Character c1 = new Character();
    	if (pClass.equals("Warrior")) {
    		System.out.println("You are now a warrior!");
    		c1 = new Warrior(name);
    	}
    	/* add in once we make these classes
		else if (pClass.equals("Wizard")){
			System.out.println("You are now a wizard!");
			c1 = new Wizard(name);
		}
		else if (cPlass.equals("Thief")){
			System.out.println("You are now a thief!");
			c1 = new Thief(name);
		}
		*/

		Character c2 = new Ogre("An Ogre");
		c1.game(c2);
    }
}
