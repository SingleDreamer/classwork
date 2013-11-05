import java.io.*;
import java.util.*;

public class Wizard extends Character {
    
    protected int mana;

    public Wizard (String name){
	super(name);
	mana = 50;
    }

    public int attack(Character other){
	int[] dice = {1,2,3,4,5,6};
	int oph = other.health;

	System.out.println("Choose your attack:");
	System.out.println("Press 1 to unleash FIREBALL");
	System.out.println("Press 2 to unleash ICE STORM");
	System.out.println("Press 3 to unleash EARTHSHAKER");

	Scanner sc = new Scanner(System.in);
	int answer = sc.nextInt();

	Random r = new Random();
	int d1 = dice[r.nextInt(dice.length)];
	int d2 = dice[r.nextInt(dice.length)];
	int d3 = dice[r.nextInt(dice.length)];
	hit = d1 + d2 + d3;
	
	if (hit <= this.dexterity){
	    if (answer == 1){
		if (mana >= 8){
		    other.health = oph - (this.strength + 8);
		    mana = mana - 8;
		    System.out.println(this.name + " has unleashed a FIREBALL upon " + other.name);
		}		
		else{
		    System.out.println("You don't have enough mana!");
		}
	    }
	    else if (answer == 2){
		if (mana >= 3){
		    other.health = oph - (this.strength + 3);
		    mana = mana - 3;
		    System.out.println(this.name + " has unleashed an ICESTORM upon " + other.name);
		}
		else{
		    System.out.println("You don't have enough mana!");
		}
	    }
	    else if (answer == 3){
		if (mana >= 5){
		    other.health = oph - (this.strength + 5);
		    mana = mana - 5;
		    System.out.println(this.name + " has unleashed a EARTHSHAKER upon " + other.name);
		}
		else {
		    System.out.println("You don't have enough mana!");
		}
	    }
	}
	
    }
}