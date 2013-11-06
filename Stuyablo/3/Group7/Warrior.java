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
	    other.health = other.health -1;
	    if (experience = 15){
		maxhealth = maxhealth + 5;
		experience = 10;
		strength = strength +1;
		dexterity = dexterity +1;
		//kind of like leveling up
	    }
	}
	else {
	    System.out.println(n + " missed!");
	    flee();
		//if the PC is weaker than NPC, PC can flee
		}
    }

    public void flee(Character other){
	Random r = new Random();
	int rollDie = r.nextInt(18) +1;
	if(rollDie <= dexterity){
	    System.out.println(n + " fled. Cowardly actions have decreased EXP.");
	    experience = experience - 1;
	    maxhealth = maxhealth -5;
	}
	else {
	    System.out.println(n + " failed to flee.")
		}
    }

    public int encounter(Character other){
	if (other.flee(this)){
	    experience = experience -1;
	    if(experience == 15){
		maxhealth = maxhealth + 5;
		experience = 10;
		strength = strength +1;
		dexterity = dexterity +1;
	    }
	}
	else if (other.strength>=this.strength || other.health>=this.health) {
            if (flee(other))
                return 1;
                    }
        this.attack(other);
        if (other.health > 0)
            other.attack(this);
        if (health == 0)
            return 2;
        else if (other.health == 0)
            return 3;
        else if (health == 0 && other.health == 0)
            return 4;
        else
            return 5;
    }
}
