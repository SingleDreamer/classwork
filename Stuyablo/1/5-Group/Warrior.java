import java.io.*;
import java.util.*;

public class Warrior extends playerCharacter{

    public void basicAttack (Character c){
	int x = 3 + r.nextint(6) + r.nextint(6) + r.nextint(6);
	if (x < dex) {
	    c. subhealth(1);
	}
    }
    public void critHit (character c){
	int x = 3 + r.nextint(6) + r.nextint(6) + r.nextint(6);
	if (x < dex) {
	    c. subhealth(1);
	    if (x < dex - 5) {
			c. subhealth(1);
			System.out.println ("Critical hit! + 1 damage");
	    }
	}
    }

public void tripleStrike (Character c){
	int x = 3 + r.nextint(6) + r.nextint(6) + r.nextint(6);
	if (x < dex) {
	    c.subhealth(r.nextint(2));
	    if (r.nextint(1) > 0){
		System.out.println ("Hit!");
	    }
	    c.subhealth(r.nextint(2));
	    if (r.nextint(1) > 0){
		System.out.println ("Hit!");
	    }
	    c.subhealth(r.nextint(2));
	    if (r.nextint(1) > 0){
		System.out.println ("Hit!");
	    }
	}   
}
}
