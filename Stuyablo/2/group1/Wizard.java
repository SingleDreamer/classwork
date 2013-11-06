import java.io.*;
import java.util.*;

public class Wizard extends Character{
    protected int mana;

    public Wizard(String Name)
    {
	super();
	name = Name;
	mana = intelligence;
    }

    /* You have to provide other needed get/set methods */


    public void attack(Character other) {
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


   
    /*
      this routine will decide first ask if other tries to flee. If
      so, and if it's succesful it should adjust experience and or
      gold as needed and return a 0.

      Then, it should decide if this character tries to flee. 
      If so and it's succesful, return a 1;
      
      Otherwise, call attack on both sides:
      this.attack(other);
      if (other.health>0) 
        other.attack(this);

      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead.

    */
    public void attack(Character c) {
	Scanner sc = new Scanner(System.in);	
	System.out.println("You can:\n  1:Whack it with your staff\n  2:Throw a fireball\n  3: Cast 'heal'\n  4:  Flee");
	switch(s.nextInt())
			case 1:
				attack(other);
				return aliveState(other);
			case 2:
				throwFireball(other);
				return aliveState(other);
			case 3:
				return aliveState(other);
			case 4:
				if(flee(other))
					return 1;
				
			default:
				System.out.println("Invalid command, try again");
		}
	}
    }

}
