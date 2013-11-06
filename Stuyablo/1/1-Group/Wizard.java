import java.io.*;
import java.util.*;

public class Wizard extends Character {
    
    protected int mana;

    public Wizard (String name){
	super(name);
	mana = 50;
    }

    public int attack(Character other){
	//int[] dice = {1,2,3,4,5,6};
	int oph = other.health;

	System.out.println("Choose your attack:");
	System.out.println("Press 1 to unleash FIREBALL");
	System.out.println("Press 2 to unleash ICE STORM");
	System.out.println("Press 3 to unleash EARTHSHAKER");

	Scanner sc = new Scanner(System.in);
	int answer = sc.nextInt();

	//Random r = new Random();
	//int d1 = dice[r.nextInt(dice.length)];
	//int d2 = dice[r.nextInt(dice.length)];
	//int d3 = dice[r.nextInt(dice.length)];
	//int hit = d1 + d2 + d3;
	
	//System.out.println (hit);
	
	while (this.health > 0 || other.health > 0){
	    if (hit <= this.dexterity) {
		if (answer == 1){
		    if (mana >= 8){
			other.takedamage(8);
			mana = mana - 8;
			System.out.println(this.name + " has unleashed a FIREBALL upon " + other.name);
			say (other + " has lost " + strength + " health points and has "+other.getHealth()+" health points left");
			//return super.attack(other);
		    }		
		    else{
			System.out.println("You don't have enough mana!");
		    }
		}
		else if (answer == 2){
		    if (mana >= 3){
		        other.takedamage(3);
			mana = mana - 3;
			System.out.println(this.name + " has unleashed an ICESTORM upon " + other.name);
			say (other + " has lost " + strength + " health points and has "+other.getHealth()+" health points left");
		    }
		    else{
			System.out.println("You don't have enough mana!");
		    }
		}
		else if (answer == 3){
		    if (mana >= 5){
		        other.takedamage(5);
			mana = mana - 5;
			System.out.println(this.name + " has unleashed a EARTHSHAKER upon " + other.name);
			say (other + " has lost " + strength + " health points and has "+other.getHealth()+" health points left");
		    }
		    else {
			System.out.println("You don't have enough mana!");
		    }
		}
	    }
	
	    else{
		System.out.println("Your attack missed!");
		this.attack(other);
	    }
	    if (this.health <= 5){
                if (this.flee(other)){
                    return 0;
                }
            }
            if (other.health <= 5){
                if (other.flee(this)){
                    return 1;
                }
            }
	}
	if (this.health <= 0){
            this.die();
            return 2;
        }
        else{
            other.die();
            return 3;
        }
    }
}
