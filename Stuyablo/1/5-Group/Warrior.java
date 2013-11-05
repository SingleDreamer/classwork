import java.io.*;
import java.util.*;

public class Warrior extends playerCharacter{
    private Random rand = new Random();

    public void basicAttack (Character c){
	int x = 3 + rand.nextint(6) + rand.nextint(6) + rand.nextint(6);
	if (x < dex) {
	    c.subhealth(1);
	}
    }
    public void critHit (Character c){
	int x = 3 + rand.nextint(6) + rand.nextint(6) + rand.nextint(6);
	if (x < dex) {
	    c.subhealth(1);
	    if (x < dex - 5) {
			c.subhealth(1);
			System.out.println ("Critical hit! + 1 damage");
	    }
	}
    }

public void tripleStrike (Character c){
	int x = 3 + rand.nextint(6) + rand.nextint(6) + rand.nextint(6);
	if (x < dex) {
	    c.subhealth(rand.nextint(2));
	    if (rand.nextint(1) > 0){
		System.out.println ("Hit!");
	    }
	    c.subhealth(rand.nextint(2));
	    if (rand.nextint(1) > 0){
		System.out.println ("Hit!");
	    }
	    c.subhealth(rand.nextint(2));
	    if (rand.nextint(1) > 0){
		System.out.println ("Hit!");
	    }
	}   
}
}
