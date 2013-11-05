import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {

	Character c1 = new Character("Character 1");
	Character c2 = new Character("Character 2");
	/*
	for (int i = 1; c1.getHealth() > 0 && c2.getHealth() > 0; i++) {
	    System.out.println("Round " + i);
	    c1.encounter(c2);
	    System.out.println(c1.getStatus());
	    System.out.println(c2.getStatus());
	    System.out.println();
	    c2.encounter(c1);
	    System.out.println(c1.getStatus());
	    System.out.println(c2.getStatus());
	    System.out.println("------------------------");
	}
	*/

	Warrior w = new Warrior("Warrior");
	Character c = new Character("Character");

	for (int i = 1; w.getHealth() > 0 && c.getHealth() > 0; i++) {
	    System.out.println("Round " + i);
	    w.encounter(c);
	    System.out.println("\tUpdated Stats:");
	    System.out.println(w.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println();
	    try{Thread.sleep(2000);}catch(InterruptedException ex){}
	    System.out.println("---NPC's Response---\n");
	    c2.encounter(w);
	    System.out.println(w.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println("------------------------");
	}
	

    }

}
