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
	attackRange = 5;
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
	int dice = DieRoll();
		//If the distance is greater than the attack range, move closer by one
		if (attackRange < distance) {
			distance = distance - 1;
			}
		else {
			//If thief roles less than its dexterity, it hits the attack!
			if (dice <= dexterity) {
				System.out.println ("You just got attacked by the thief!");
				experience = experience + 1;
				other.health = other.health - 1;
				}
			//If thief roles more than its dexterity, it misses the attack!
			else {
					System.out.println ("The theif tried attacking you but missed!");
			}
		}
}

public String getName() {
	return "thief";
}


}