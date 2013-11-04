import java.io.*;
import java.util.*;

public class Driver {
    public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
	String type = new String();
	int x = 0;
	while ( x == 0 ) {
	    System.out.print("Which type of character do you want to be? (Warrior, Wizard, or Thief)");
	    type = sc.nextLine();
	    if ( type.equals ( "Warrior" ) ) {
		Warrior w = new Warrior ( name );
		x = 1;
	    }
	    else if ( type.equals ( "Wizard" ) ) {
		Wizard wi = new Wizard ( name );
		x = 1;
	    }
	    else if ( type.equals ( "Thief" ) ) {
		Thief t = new Thief ( name );
		x = 1;
	    }
	    else System.out.println ("Misspelled character type");
	}
	System.out.print ( "Hello " + name + "! Congratulations on becoming a " + type + "! Please select what you want to do next. (Attack nearest enemy(a), explore(e), or talk to friend(t))");
    }
}
