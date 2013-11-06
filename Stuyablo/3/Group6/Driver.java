import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {

	Warrior w = new Warrior("Warrior");
	Ogre c = new Ogre();

	for (int i = 1, j = 0; w.getHealth() > 0 && c.getHealth() > 0 && j==0; i++) {
	    System.out.println("Round " + i);
	    int e1 = w.encounter(c);
	    if (e1 == 0)
		j = 1;
	    System.out.println("\tUpdated Stats:");
	    System.out.println(w.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println();
	    try{Thread.sleep(2000);}catch(InterruptedException ex){}
	    System.out.println("---NPC's Response---\n");
	    int e2 = c.encounter(w);
	    if (e2 == 0)
		j = 1;
	    System.out.println(w.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println("------------------------");
	}
	

    }

}
