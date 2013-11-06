import java.io.*;
import java.util.*;

public class Wizard extends Character{
    protected int mana;

    public Wizard(String Name) {
	name = Name;
	setStat();
	health = strength;
	mana = intelligence;
	System.out.println("Strength: " + strength);
	System.out.println("Dexterity: " + dexterity);
	System.out.println("Intelligence: " + intelligence);
    }

    public void basic(Character other) {
	    if(hit()==true)
	    {
		    System.out.println("You hit the " + other.getName() + " for " + 2 + " damage!");
		    other.takeDamage(2);
	    }
	    else
	    {
		    System.out.println("You swing at the " + other.getName() + " but miss!");
	    }
    }
    
    public void throwFireball(Character other) {
	    if(mana >= 2)
	    {
		    mana -= 2;

		    if(hit()==true)
		    {
			    System.out.println("You cast an orb of flame at the " + other.getName() + " for " + 6 + " damage!");
			    other.takeDamage(6);
		    }
		    else
		    {
			    System.out.println("Your fireball sputters out before you can throw it.");
		    }
		    System.out.printf("You have %d mana left",mana);
	    }
	    else
	    	System.out.println("You don't have enough mana");
    }

    public void heal()
    {
	    if(mana >= 1)	    
	    {
		    mana -= 1;
		    if(hit()==true)
		    {
			    System.out.println("You heal yourself");
			    health += 3;
			    if(health > strength) health = strength;
			    System.out.println("You now have " + health + "health");
		    }
		    else
			    System.out.println("You try to heal yourself, but fail");
	    }
	    else
		    System.out.println("You have no mana");



    }

    public void attack(Character c) {
	Scanner s = new Scanner(System.in);	
	System.out.println("You can:\n  1:Whack it with your staff\n  2:Throw a fireball\n  3: Cast 'heal'\n  4:  Flee");
	switch(s.nextInt()){
			case 1:
				basic(c);
				
			case 2:
				throwFireball(c);
				
			case 3:
				heal();
			case 4:
				flee();
				
			default:
				System.out.println("Invalid command, try again");
	}
    }
}
