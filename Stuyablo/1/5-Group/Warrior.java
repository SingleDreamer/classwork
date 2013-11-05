import java.io.*;
import java.util.*;

public class Warrior extends playerCharacter{
    private Random rand = new Random();

    public void basicAttack (Character c){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	if (x < dex) {
	    c.subHealth(1);
	}
    }
    public void critHit (Character c){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	if (x < dex) {
	    c.subHealth(1);
	    if (x < dex - 5) {
			c.subHealth(1);
			System.out.println ("Critical hit! + 1 damage");
	    }
	}
    }

public void tripleStrike (Character c){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	if (x < dex) {
	    c.subHealth(rand.nextInt(2));
	    if (rand.nextInt(1) > 0){
		System.out.println ("Hit!");
	    }
	    c.subHealth(rand.nextInt(2));
	    if (rand.nextInt(1) > 0){
		System.out.println ("Hit!");
	    }
	    c.subHealth(rand.nextInt(2));
	    if (rand.nextInt(1) > 0){
		System.out.println ("Hit!");
	    }
	}   
}
}
