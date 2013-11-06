import java.io.*;
import java.util.*;

public class OgrePC  extends Character {

protected int distance;
protected int dieRoll;
protected int attackRange;

/* Constructor for OgrePC */
public OgrePC() {
	strength = 15;
	health = strength;
	maxhealth = health;
	dexterity = 4;
	attackRange = 5;
	experience = 0;
	distance = generator.nextInt(10) + 1;
}

Random generator = new Random();


public int getDistance(){
	return distance;
}

public void attack(Character other){
<<<<<<< HEAD
        int dice = DieRoll();
                if (attackRange < distance) {
                        distance = distance - 1;
                        }
                else {
                        
                        if (dice <= dexterity) {
                                System.out.println ("You successfully attacked!");
                                experience = experience + 1;
                                other.health = other.health - 1;
                                }
                
                        else {
                                System.out.println ("you missed!");
                        }
                }
=======
	int dice = DieRoll();
	
		if (attackRange < distance) {
			distance = distance - 1;
			}
		else {
			
			if (dice <= dexterity) {
				System.out.println ("You successfully attacked!");
				experience = experience + 1;
				other.health = other.health - 1;
				}
		
			else {
					System.out.println ("you missed!");
			}
		}
>>>>>>> 3e98ff56985fd5fcca2bf7a00f578a824ad077ac
}

}
