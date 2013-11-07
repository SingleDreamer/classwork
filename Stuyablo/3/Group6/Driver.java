import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {

	Warrior w = new Warrior("Warrior");
	Ogre c = new Ogre();
	Thief t = new Thief();
	GoblinMage m = new GoblinMage();

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
	/*
	for (int i = 1, j = 0; m.getHealth() > 0 && c.getHealth() > 0 && j==0; i++) {
	    System.out.println("Round " + i);
	    int e1 = m.encounter(c);
	    if (e1 == 0)
		j = 1;
	    System.out.println("\tUpdated Stats:");
	    System.out.println(m.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println();
	    try{Thread.sleep(2000);}catch(InterruptedException ex){}
	    System.out.println("---NPC's Response---\n");
	    int e2 = c.encounter(m);
	    if (e2 == 0)
		j = 1;
	    System.out.println(m.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println("------------------------");
	}

    for (int i = 1, j = 0; t.getHealth() > 0 && c.getHealth() > 0 && j==0; i++) {
	    System.out.println("Round " + i);
	    int e1 = t.encounter(c);
	    if (e1 == 0)
		j = 1;
	    System.out.println("\tUpdated Stats:");
	    System.out.println(t.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println();
	    try{Thread.sleep(2000);}catch(InterruptedException ex){}
	    System.out.println("---NPC's Response---\n");
	    int e2 = c.encounter(t);
	    if (e2 == 0)
		j = 1;
	    System.out.println(t.getStatus());
	    System.out.println(c.getStatus());
	    System.out.println("------------------------");
	}
	*/
	/*Would like to say that I, Rushil Kumar was supposed to finish this up and did 
          not do so properly. If any points are to be deducted from the errors in this, 
          please do so from my grade and not my group members. They put in their work
          but I feel I did not do my part. Also, 3 scenarios are given. Two of them are commented 
          out while the other one is not.
	 */
    }
}
