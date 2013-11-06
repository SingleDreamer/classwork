import java.io.*;
import java.util.*;

public class WarriorNPC extends Character {

protected int dieRoll;
protected int attackRange;

/* Constructor for WarriorNPC */
public WarriorNPC() {
	strength = 10;
	health = strength;
	maxhealth = health;
	dexterity = 6;
	attackRange = 7;
	experience = 4;
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
		if (dieRoll <= strength) {
			System.out.println ("You just got attacked by the warrior!");
			health = health + 1;
			experience = experience + 1;
			other.health = other.health - 1;
		}
		//If warrior roles more than its strength, it misses the attack!
		else {
			System.out.println ("The warrior tried attacking you but missed!");
			other.experience = other.experience + 1;
		}
}

public String getName() {
	return "warrior";
}


}
