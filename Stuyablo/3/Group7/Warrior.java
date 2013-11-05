import java.util.*;
import java.io.*;

public class Warrior extends Character {
    String name = new String();
    Scanner sc = new Scanner(System.in);
    //is this right??

    public Warrior(String n){
	name = n;
	dexterity = 10;
	strength = 15;
	//health = 10;
	maxhealth = 50;
	experience = 10;
	//temporary values; might need to add new variables
    }

    public void attack(Character other){
	Random r = new Random();
	int rollDie = r.nextInt(18)+1;
	//rolling a die method

	if (rollDie <= dexterity){
	    //might include weapons later
	    //basically, the chacter will be able to attack
	    System.out.println(n + " attacked and hit the enemy!");
	    experience = experience + 1;
	    if (experience = 15){
		maxhealth = maxhealth + 5;
		experience = 10;
		//kind of like leveling up
	    }
	    else {
	    }
	}
	else {
	    System.out.println(n + " missed!");
	    flee();
		//if the PC is weaker than NPC, PC can flee
		}

	public void flee(Character other){
	    System.out.println(n + " fled. Cowardly actions have decreased EXP.");
	    experience = experience - 1;
	    maxhealth = maxhealth -1;
	}

	public int encounter(Character other){
	    if (strength + dexterity > other.strength + other.dexterity){
		if (flee(other)){
		    System.out.println("Enemy fled!");
		}
		else {
		    this.attack(other);
		}
	    }
	    else {
		flee();

	
