import java.util.*;
import java.io.*;
import java.math.*;

public class Npc extends Character {

    public Npc(String nm, int lv) {
	name = nm;
	dexterity = 8;
	strength = 4;
	intellegence = 4;
	level = lv;
	ep = 30 + 20*lv;
	for (int i = 3 + lv; i > 0; i--) {
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

    public boolean die() {
        System.out.println(name + " is dead.");
	return false;
    }
}
