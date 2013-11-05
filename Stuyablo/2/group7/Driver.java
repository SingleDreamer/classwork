import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("\nEnter a name: ");
    	String name = sc.nextLine();
    	System.out.println("\nChoose your class:\n\nWarrior\nWizard\nThief");
    	System.out.print(">");
    	String pClass = sc.nextLine();
    	Character c1 = new Character();
    	if (pClass.equals("Warrior")) {
    		System.out.println("\nYou are now a warrior!\n");
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
		else {
			System.out.println("\nInvalid class, defaulting to Warrior.\n");
			c1 = new Warrior(name);
		}
		Character c2 = new Ogre("The ogre");
		c1.fight(c2);
    }
}
