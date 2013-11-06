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
	other.gold = other.gold + gold;
	other.experience = other.experience + experience;
	String winmessage = String.format("You have defeated the %s and gained %s experience and %s gold!", name, experience, gold);
	System.out.println(winmessage);
    }

    public void attack(Character other) {
	int die1 = (int)(Math.random() * 7);
	int die2 = (int)(Math.random() * 7);
	int die3 = (int)(Math.random() * 7);
	int roll = die1 + die2 + die3;
	System.out.println("The " + name + " tried attacking you!");
	
	if (roll > dexterity) {
	    //miss
	    System.out.println("The " + name + " stuttered while casting its spell and accidentally summoned a bag of potato chips!");}
	else {
	    //hit
	    System.out.println("The " + name + "showered you in fireballs!");
	    int damage = (int)(intelligence/4 + (Math.random() * 3)) - 1;
	    other.health = other.health - damage;
	}
    }
}
