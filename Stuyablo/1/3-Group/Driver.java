import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	PC c = new PC();
	c.PCCreation();
	NPC x = new NPC();
	System.out.println(c.getStatus());
	Random r = new Random();
	for (n = 0, n < 50, n ++){
	    if (r.nextInt(100) < 50){
		System.out.println("You've encountered something!");
	    }
	    else{
		System.out.println("You walk merrily onwards");
	    }
	}
	System.out.println("Congratulations! You've made it to the end!")
    }
}
