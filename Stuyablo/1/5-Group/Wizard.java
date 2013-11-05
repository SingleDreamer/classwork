import java.util.*;
import java.io.*;

public class Wizard extends playerCharacter {
    private Random rand = new Random();

    public void basicAttack (Character c){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	if (x < dex) {
	    c.subHealth(1);
	}
    }

    public void Fireball (Character c) {
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	int y = str;

	if (x < dex && y > 0) {
	    if (rand.nextInt(5)>0) {
		c.subHealth(intl-rand.nextInt(5)-3);
	    }
	    else {
		y = y - 1;
	    }
	}
    }

    public void Lightning (Character c) {
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	int y = str;

	if (x < dex && y > 0) {
	    if (rand.nextInt(2)>0) {
		c.subHealth(intl-rand.nextInt(3));
	    }
	    else {
		y = y - 1;
	    }
	}
    }
}
