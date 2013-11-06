import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	PC c = new PC();
	NPC n = new NPC();
	Random r = new Random();
	Scanner sc = new Scanner(System.in);
	System.out.println("Greetings, player! There are many paths to take in this adventure! Which kind of character do you wish to be? [Type only the character class]");
	System.out.println("1. Rogue");
	System.out.println("2. Warrior");
	String inp = sc.next();
	if (inp.equals("1")) {
	    Rogue p = new Rogue();
	}
	else if (inp.equals("2")){
	    Warrior p = new Warrior();
	}
	for (int z = 0; z < 50; z ++){
	    if (r.nextInt(2) < 1){
		System.out.println("You've encountered something!");
		NPC x = new NPC();
		Scanner inp = new Scanner(System.in);
		System.out.println("What do you want to do?");
		System.out.println("1. Attack \n 2.Talk \n 3.Ignore");
		int x = inp.nextInt();
		if (x == 1){
		    c.encounter(x)
		}
		else if (x == 2){
		    other.talk();
		}
		else{
		    System.out.println("You keep walking.");
		    other.health = 0;
		}
	    }
	    else{
		System.out.println("You walk merrily onwards");
	    }
	}
	System.out.println("Congratulations! You've made it to the end!");
    }
}
