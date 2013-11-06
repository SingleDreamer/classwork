import java.io.*;
import java.util.*;

public class Warrior extends Character {
    private int exp=0,lvl=1;

    public void attack(NPC c) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Choose your attack!\n" + "(1) Basic, (2) Special Attacks");
	int atk = s.nextInt();

	if (atk == 1) {
	    basic(c);
	}
	else if (atk == 2) {
	    if (charclass.equals("Warrior")) {
		wSpecial(c);
	    }
	}
	else {
	    System.out.println("Silly " + name + ", you can't kiss them");
	    attack(c);
	}
    }
		
    public boolean hit() {
	Random r = new Random();
	int d1,d2,d3,sum;
	d1 = r.nextInt(6) + 1;
	d2 = r.nextInt(6) + 1;
	d3 = r.nextInt(6) + 1;
	sum = d1 + d2 + d3;
	return (sum <= dexterity);
    }

    public void defend(int dmg) {
	health = health - dmg;
    }

}
