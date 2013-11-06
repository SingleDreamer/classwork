import java.io.*;
import java.util.*;
import java.math.*;

public class GoblinMage extends Character {

    public GoblinMage() {
	int rand1 = (int)(Math.random() * 4);
	int leftover = 8-rand1;

	dexterity = 8 + rand1;
	strength = 8 + leftover;
	health = strength;
	intelligence = 13;

	experience = 50;
	gold = 100;
	name = "Goblin Mage";
	charClass = "NPC";
    }
    
    public void die(Character other) {
	other.gold = other.gold + this.gold;
	other.experience = other.experience + this.experience;
	String winmessage = String.format("You have defeated the %s and gained %s experience and %s gold!", this.name, this.experience, this.gold);
	System.out.println(winmessage);
    }

    public void attack(Character other) {
	System.out.println("The " + name + " tried attacking you!");
	if (roll() == false) {
	    //miss
	    System.out.println("The " + name + " stuttered while casting its spell and accidentally summoned a bag of potato chips!");}
	else {
	    //hit
	    System.out.println("The " + name + "showered you in fireballs!");
	    int damage = (int)(this.intelligence/4 + (Math.random() * 3)) - 1;
	    other.health = other.health - damage;
	}
    }
}
