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


public void attack(Character other){
<<<<<<< HEAD
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
=======
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
>>>>>>> 3e98ff56985fd5fcca2bf7a00f578a824ad077ac

public String getName() {
	return "thief";
}


}
