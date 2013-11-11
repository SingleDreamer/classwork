import java.io.*;
import java.util.*;

public class Wizard extends Character {
    
    protected int mana;

    public Wizard (String name){
	super(name);
	mana = 50;
    }

    public int attack(Character other){
	int oph = other.health;

	System.out.println("Choose your attack:");
	System.out.println("Press 1 to unleash FIREBALL");
	System.out.println("Press 2 to unleash ICE STORM");
	System.out.println("Press 3 to unleash EARTHSHAKER");

	Scanner sc = new Scanner(System.in);
	int answer = sc.nextInt();

	System.out.println (roll()); 
	
 	   
	if (answer == 1){
	    if (roll() >= this.dexterity) {
		if (mana >= 8){
		    other.takedamage(8);
		    mana = mana - 8;
		    say (this.name + " has unleashed a FIREBALL upon " + other.name);
		    say (other + " has lost " + "8" + " health points and has "+other.getHealth()+" health points left");
		    //return super.attack(other);
		}		
		else{
		    System.out.println("You don't have enough mana!");
		}
	    }
	}
	else if (answer == 2){
	    if (roll() >= this.dexterity) {
		if (mana >= 3){
		    other.takedamage(3);
		    mana = mana - 3;
		    say (this.name + " has unleashed an ICESTORM upon " + other.name);
		    say (other + " has lost " + "3" + " health points and has "+other.getHealth()+" health points left");
		}
		else{
		    System.out.println("You don't have enough mana!");
		}
	    }
	}
	else if (answer == 3){
	    if (roll() >= this.dexterity) {
		if (mana >= 5){
		    other.takedamage(5);
		    mana = mana - 5;
		    say (this.name + " has unleashed an EARTHSHAKER upon " + other.name);
		    say (other + " has lost 5 health points and has "+other.getHealth()+" health points left.");
		}
		else {
		    System.out.println("You don't have enough mana!");
		}
	    }
	}
	else{
	    say ("Your attack missed!");
	    this.attack(other);
	}
	/*if (this.health <= 5){
		if (this.flee(other)){
		    return 0;
		}
	    }
	    if (other.health <= 5){
		if (other.flee(this)){
		    return 1;
		}
		}*/
    
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
