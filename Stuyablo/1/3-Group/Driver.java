import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	PC c = new PC();
	NPC n = new NPC();
	System.out.println(c.getStatus());
	Random r = new Random();
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
