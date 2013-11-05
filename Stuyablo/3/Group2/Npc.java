import java.util.*;
import java.io.*;
import java.math.*;

public class Npc extends Character {

public Npc(String nm) {
	name = nm;
	dexterity = 8;
	strength = 8;
	intellegence = 8;
	level = 1;
	ep = 0;
	for (int i = 8; i > 0; i--) {
	    Random r = new Random();
	    int number = r.nextInt(3);
	    if (number == 2)
		dexterity++;
	    else if (number == 1)
		strength++;
	    else
		intellegence++;
		}
	hp = strength;
	mp = strength;		
    }

    public void die() {
	System.out.println(name + " is dead.");
    }
}