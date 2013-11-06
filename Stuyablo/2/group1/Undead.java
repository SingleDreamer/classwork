import java.io.*;
import java.util.*;

public class Undead extends Character{
    Random r = new Random();

    public Undead(){
	super.setStat();
        name = "The Lich King";
        maxHealth = 6 + r.nextInt(5);
        health = maxHealth
        strength = maxHealth;
        dexterity = 8 - r.nextInt(5);
	intelligence = 8 + r.nextInt(5);
    }
    public void attack(Character other) {
	    int sum = 0;

	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    sum += r.nextInt(6) + 1;
	    
	    if(sum <= dexterity){
		System.out.println("Hit!");
		other.takeDamage(this.strength/2);
	    }
	    else{
	        System.out.println("Just barely missed him!");
	    }
    }
}
