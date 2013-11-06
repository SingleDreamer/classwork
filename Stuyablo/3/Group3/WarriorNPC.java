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
	attackRange = 5;
	experience = 4;
}


public void attack(Character other){
<<<<<<< HEAD
        int dice = DieRoll();
                //If the distance is greater than the attack range, move closer by one
                if (attackRange < distance) {
                        distance = distance - 1;
                        }
                else {
                        //If warrior roles less than its strength, it hits the attack!
                        if (dieRoll <= strength) {
                                System.out.println ("You just got attacked by the warrior!");
                                experience = experience + 1;
                                other.health = other.health - 1;
                                }
                        //If warrior roles more than its strength, it misses the attack!
                        else {
                                System.out.println ("The warrior tried attacking you but missed!");
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
			//If warrior roles less than its strength, it hits the attack!
			if (dieRoll <= strength) {
				System.out.println ("You just got attacked by the warrior!");
				experience = experience + 1;
				other.health = other.health - 1;
				}
			//If warrior roles more than its strength, it misses the attack!
			else {
				System.out.println ("The warrior tried attacking you but missed!");
			}
		}
}
>>>>>>> 3e98ff56985fd5fcca2bf7a00f578a824ad077ac

public String getName() {
	return "warrior";
}


}
