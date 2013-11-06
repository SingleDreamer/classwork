import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {

	Warrior w = new Warrior("Warrior");
	Ogre c = new Ogre();

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
