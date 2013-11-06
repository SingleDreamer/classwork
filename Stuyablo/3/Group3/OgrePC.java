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

//Stimulates the rolling of a 3 6-sided dice
public int DieRoll(){
	for (int i=0; i<3; i++){
		dieRoll = dieRoll + generator.nextInt(5) + 1;
	}
	return dieRoll;
}



public void attack(Character other){
		DieRoll();
		Random rnd = new Random();
		rnd.nextInt(strength);
		
		//If Ogre roles less than its strength, it hits the attack!
		if (dieRoll <= rnd) {
			System.out.println ("You successfully attacked!");
			other.health = other.health - 1;
			experience = experience + 1;
		}
		//If Ogre roles more than its strength, it !
		else {
			System.out.println ("You missed!");
		}
}


}
