import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
       	Character c = new Character();
	System.out.println(c.getStatus());
	Random r = new Random();
	c.CharacterS();
	System.out.println(c.getStatus());
	int turns = 20;
	while ( c.getHealth() > 0 && turns > 0){
	    int d = r.nextInt(100);
	    if (d > 50) {
		Goblin g2 = new Goblin("Quacky");
		System.out.println("You have encountered goblin " + g2 + "!");
		while (c.encounter(g2) == 5){
		    System.out.println();
		    System.out.println("#################");
		    System.out.println("Next Round:");
		    System.out.println();
		}
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	    }
	    else {
	        Gnome gn2 = new Gnome("Wacky");
		System.out.println("You have encountered gnome " + gn2 + "!");
		while (c.encounter(gn2) == 5){
		    System.out.println();
		    System.out.println("#################");
		    System.out.println("Next Round:");
		    System.out.println();
		}
		try {
		    Thread.sleep(2000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	    }
	    turns ++;
	}
    }
   
}
