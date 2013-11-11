import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
       	Character player = new Character();
	Random r = new Random();
	player.CharacterS();
	System.out.println(player.getStatus());
	int turns = 20;
	while ( player.getHealth() > 0 && turns > 0){
	    int d = r.nextInt(100);
	    if (d > 50) {
		Goblin g2 = new Goblin("Quacky");
		System.out.println("You have encountered goblin " + g2 + "!");
		while (player.encounter(g2) == 5){
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
		while (player.encounter(gn2) == 5){
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
