import java.util.*;
import java.io.*;
import java.math.*;

public class Character {
    protected int hp, mp, ep, level, dexterity, strength, intellegence;
    protected String name;

    public int getLevel() {
	return level;
    }

    public int getDexterity() {
	return dexterity;
    }
    
    public int getHp() {
	return hp;
    }

    public Character() {
	name = "Hans Gruber";
	dexterity = 8;
	strength = 8;
	intellegence = 8;
	level = 1;
	ep = 0;
	for (int i = 8; i > 0; i--) {
	    Random r = new Random();
	    int number = r.nextInt(2);
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

    public Character(String nm,int ST, int DX, int IQ) {
	name = nm;
	dexterity = DX;
	strength = ST;
	intellegence = IQ;
	level = 1;
	ep = 0;
	hp = strength;
	mp = strength;

    }

    public Character(String nm) {
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

    public String getStats() {
	return name+"'s Stats:\nLevel:"+level+"\nHealth:"+hp+"\nMana:"+mp+"\nExperience:"+ep+"\nDexterity:"+dexterity+"\nStrength:"+strength+"\nIntellegence:"+intellegence+"\n";
    }
    public boolean roll(){
	Random r1 = new Random();
	Random r2 = new Random();
	Random r3 = new Random();
	int die1=r1.nextInt(5)+1;
	int die2=r2.nextInt(5)+1;
	int die3=r3.nextInt(5)+1;
	int total = die1+die2+die3;
	if (dexterity>total){
	    return true;
	}
	else{
	    return false;
	}
    }

    public String toString() {
	return name;
    }

    public boolean encounter(Character other) {
	return attack(other);
    }
    
    
    public boolean die() {
	System.out.println(name + " is dead.");
	return false;
    }
    


    public boolean changeHP(int n) {
	if (hp > n) {
	    hp = hp - n;
	    return true;
	}
	else 
	    return die();
    }
    public boolean attack(Character other) {
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	if (roll()) {
	    System.out.println(name + " deals " + strength/3 + " damage!");
	    return other.changeHP(strength / 3);
	}
	else {
	    System.out.println(name + "'s attack misses!");
	    return true;
	}
    }

    
}
