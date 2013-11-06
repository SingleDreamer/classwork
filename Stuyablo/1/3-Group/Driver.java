import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	PC c = new PC();
	NPC n = new NPC();
	System.out.println(c.getStatus());
	Random r = new Random();
	System.out.println("Greetings, player! There are many paths to take in this adventure! Which kind of character do you wish to be? [Type only the character class]");
	System.out.println("1. Rogue");
	System.out.println("2. Warrior");
	String inp = sc.next();
	if (inp.equals("Rogue")) {
		Rogue p = new Rogue();
	}
	else {
		Warrior p = new Warrior();
	}
	for (int z = 0; z < 50; z ++){
	    if (r.nextInt(2) < 1){
		System.out.println("You've encountered something!");
		NPC x = new NPC();
		c.encounter(n);
	    }
	    else{
		System.out.println("You walk merrily onwards");
	    }
	}
	System.out.println("Congratulations! You've made it to the end!");
    }
}
