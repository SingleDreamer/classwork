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
	Random r = new Random(); 
	int tempStrength = strength - r.nextInt(5);
	if(hit()==true)
	    {
		System.out.println("\nYou hit the " + other.getName() + " for " + tempStrength + " damage!");
		other.takeDamage(tempStrength);
	    }
	    else
	    {
		    System.out.println("\nYou swing at the " + other.getName() + " but miss!");
	    }
    }
    
    public void throwFireball(Character other) {
	    if(mana >= 2)
	    {
		    mana -= 2;

		    if(hit()==true)
		    {
			    System.out.println("\nYou cast an orb of flame at the " + other.getName() + " for " + 6 + " damage!");
			    other.takeDamage(6);
		    }
		    else
		    {
			    System.out.println("\nYour fireball sputters out before you can throw it.");
		    }
		    System.out.printf("\nYou have %d mana left",mana);
	    }
	    else
	    	System.out.println("\nYou don't have enough mana");
    }

    public void heal()
    {
	    if(mana >= 1)	    
	    {
		    mana -= 1;
		    if(hit()==true)
		    {
			    System.out.println("\nYou heal yourself");
			    health += 3;
			    if(health > strength) health = strength;
			    System.out.println("\nYou now have " + health + " health");
		    }
		    else
			    System.out.println("\nYou try to heal yourself, but fail");
	    }
	    else
		    System.out.println("\nYou have no mana");



    }

    public void attack(Character c) {
	Scanner sc = new Scanner(System.in);	
	System.out.println("\nYou can:\n  1: Whack it with your staff\n  2: Throw a fireball\n  3: Cast 'heal'");
	String input = sc.nextLine();
	if (input.equals("1"))
	    basic(c);
	else if (input.equals("2"))
	    throwFireball(c);
	else if (input.equals("3"))
	    heal();
	else
	    System.out.println("Invalid command, try again");

	    
	/*switch(s.nextInt()){
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
	*/
    }
}

