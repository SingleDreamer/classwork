import java.io.*;
import java.util.*;

public class ThiefNPC extends Character {

protected int dieRoll;
protected int attackRange;

/* Constructor for ThiefNPC*/
public ThiefNPC() {
	strength = 6;
	health = strength;
	dexterity = 14;
	attackRange = 4;
	experience = 0;
}

Random generator = new Random();


//Stimulates the rolling of a 3 6-sided dice
public int DieRoll(){
	for (int i=0; i<3; i++){
		dieRoll = dieRoll + generator.nextInt(5) + 1;
	}
	return dieRoll;
}


public void attack(Character other){
		DieRoll();
		//If warrior roles less than its strength, it hits the attack!
		if (dieRoll <= dexterity) {
			System.out.println ("You just got attacked by the thief!");
			health = health + 1;
			experience = experience + 1;
			other.health = other.health - 1;
		}
		//If warrior roles more than its strength, it misses the attack!
		else {
			System.out.println ("The theif tried attacking you but missed!");
			other.experience = other.experience + 1;
		}
}

public String getName() {
	return "thief";
}


}