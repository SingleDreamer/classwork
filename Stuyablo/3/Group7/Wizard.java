import java.io.*;
import java.util.*;

public class Wizard extends Character {

    public Wizard(String n) {
	Random r = new Random();
	name = n;
	dexterity = 8;
	strength = 8;
	intelligence = 8;
        maxhealth = 50;
	experience = 0;
	for (int i = 0; i < 8; i++){
	    int a = r.nextInt(3);
	    if (a == 0)
		strength = strength + 1;
	    else if (a == 1)
		dexterity = dexterity + 1;
	    else
		intelligence = intelligence + 1;
	}
	health = strength;
    }

    public void attack(Character other) {
	Random r = new Random();
	int rollDie = r.nextInt(18) + 1;
	if (rollDie <= dexterity) {
	    System.out.println(name + " hit enemy with a basic spell!");
	    strength = strength - 1;
	    other.health = other.health - 1;
	    experience = experience + 1;
	    if (experience == 10) {
		Random random = new Random();
		int a = random.nextInt(3);
		if (a == 0)
		    strength = strength + 1;
		else if (a == 1)
		    dexterity = dexterity + 1;
		else
		    intelligence = intelligence + 1;
		experience = 0;
	    }
	}
	else {
	    System.out.println(name + " has missed the enemy!");
	    strength = strength - 1;
	}
    }

    public boolean flee(Character other) {
	Random r = new Random();
	int rollDie = r.nextInt(18) + 1;
	if (rollDie <= dexterity)
	    return true;
	else
	    return false;
    }

    public int encounter(Character other) {
	if (other.flee(this)) {
	    experience = experience + 1;
	    if (experience == 10) {
		Random r = new Random();
		int a = r.nextInt(3);
		if (a == 0) 
		    strength = strength + 1;
		else if (a == 1)
		    dexterity = dexterity + 1;
		else
		    intelligence = intelligence + 1;
		experience = 0;
	    }
	    return 0;
	}
	else if (other.strength>=this.strength || other.health>=this.health) {
	    if (flee(other))
		return 1;
		    }
	this.attack(other);
	if (other.health > 0)
	    other.attack(this);
	if (health == 0)
	    return 2;
	else if (other.health == 0)
	    return 3;
	else if (health == 0 && other.health == 0)
	    return 4;
	else
	    return 5;
    }
}