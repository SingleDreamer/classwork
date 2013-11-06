import java.io.*;
import java.util.*;

public class Wizard extends Character{
    protected int mana;

    public Wizard()
    {
	super();
	mana = intelligence;
    }

    /* You have to provide other needed get/set methods */


    public void attack(Character other) {
	    Random r = new Random();
	    int sum = 0;

	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    
	    if(sum <= dexterity)
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
	    Random r = new Random();
	    int sum = 0;

	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    
	    if(mana >= 2)
	    {
		    mana -= 2;

		    if(sum <= dexterity)
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
	    Random r = new Random();

	    int sum = 0;

	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    if(mana >= 1)	    
	    {
		    mana -= 1;
		    if(sum <= dexterity)
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


    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
	    Random r = new Random();
	    if(r.nextFloat() > 0.35)
	    {
		    System.out.println("Got away safely");
		    return true;
	    }
	    System.out.println("Failed to escape");
	    return false;
	
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
    public int encounter(Character other) {
	if(!alive())
		return aliveState(other);	

	Scanner s = new Scanner(System.in);
	//while(s.hasNext()){s.next();}//clear the buffer
	
	System.out.println("You encounter a(n) " + other.getName());
	while(true)
	{
		System.out.println("You can:\n  1:Whack it with your staff\n  2:Throw a fireball\n  3: Cast 'heal'\n  4:  Flee");
		switch(s.nextInt())
		{
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
