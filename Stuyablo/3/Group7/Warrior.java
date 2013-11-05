import java.util.*;
import java.io.*;

public class Warrior extends Character {
    String name = new String();
    Scanner sc = new Scanner(System.in);
    //is this right??

    public Warrior(String n){
	name = n;
	dexterity = 8;
	strength = 10;
	health = 10;
	maxhealth = 50;
	experience = 8;
	//temporary values; might need to add new variables
    }

    public void attack(Character other){
	Random r = new Random();
	int rollDie = r.nextInt(18);
	//rolling a die method

	if (rollDie < strength){
	    //might include weapons later
	    //basically, the chacter will be able to attack
	    System.out.println(n + " attacked and hit the enemy!");
	    experience = experience + 1;
	    if (experience = 12){
		health = health + 5;
		experience = 0;
		//kind of like leveling up
	    }
	    else {
	    }
	}
	else {
	    flee()
		//if the PC is weaker than NPC, PC can flee
		}

	public void flee(Character other){
	    

	
