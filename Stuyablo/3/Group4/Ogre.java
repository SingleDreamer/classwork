import java.io.*;
import java.util.*;

public class Ogre extends Character {

public Ogre(int level) {
	charClass = "Ogre";
	name = "Some Ogre";
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	x = r.nextInt(8);
	y = r.nextInt(14);
	/*Since humans have 32 base points after distribution, so will ogres, based entirely off their spawn level, so they will gain a point per level.*/
	strength = 18;
	dexterity = 6;
	intelligence = 0;
	this.level = level;
	for(int i = 0;i < (8 + level);i++) {
		/*8 remaining points randomly distributed (like a human), but none in intelligence, because this is an ogre. 1 more point per level.*/
		if (r.nextInt(2) == 0)
			strength = strength + 1;
		else
			dexterity = dexterity + 1;
		}
	maxhealth = strength;
	health = maxhealth;
	}
}

/* We do not need this method, but if we ever do, it will be useful.
public void move() {
	Scanner s = new Scanner(System.in);
	System.out.println("You may move in x-direction: upto 4 steps for Archers");
	int xstep = s.nextInt();
	if (xstep <= -4 && x >=4)
		x = x - 4;
	elseif (xstep <= -4)
		x = 0;
	elseif (xstep >= 4 && x <=4)
		x = x + 4;
	elseif (xstep >=4)
		x = 8;
	else 
		x = x + xstep;

int ystep = s.nextInt();
	if (ystep <= -4 && y >=4)
		y = y - 4;
	elseif (ystep <= -4)
		y = 0;
	elseif (ystep >= 4 && y <=10)
		y = y + 4;
	elseif (ystep >=4)
		y = 14;
	else 
		y = y + ystep;
	}
*/

