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
	maxhealth = 10;
	dexterity = 4;
	attackRange = 5;
	experience = 6;
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

public boolean flee(Character other){
		DieRoll();
		//if Ogre rolls less that dexterity, it gets away!!
		if (dieRoll <= dexterity) {
			System.out.println("The Ogre just fled");
			dexterity = dexterity + 1;
			experience = experience + 1;
			return true;
			isHere = false;
		}
		else {
			System.out.println("The enamy tried to flee but wasn't fast enough!");
			dexterity = dexterity - 1;
			return false;
		}
}



public void attack(Character other){
		DieRoll();
		Random rnd = new Random();
		rnd.nextInt(strength);
		
		//If Ogre roles less than its strength, it hits the attack!
		if (dieRoll <= rnd) {
			System.out.println ("You tried to attack, but failed!");
			experience = experience - 1;
			other.strength = other.strength + 1;
			other.health = other.health + 1;
			other.dexterity = other.dexterity + 1;
		}
		//If Ogre roles more than its strength, it !
		else {
			System.out.println ("You succesfully attakced!");
			experience = experience + 1;
			strength = strength + 1; 
			dexterity = dexterity + 1;
		}
}


}
