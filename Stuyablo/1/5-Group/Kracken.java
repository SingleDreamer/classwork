import java.io.*;
import java.util.*;

public class Kracken extends Character {
    private int scariness;
    private Random rand = new Random();
    
    public Kracken (int scariness, int maxhealth,int dexterity, int  strength, int  intelligence, int  experience) {
	super(maxhealth,dexterity,strength,intelligence,experience);
`	scariness = this.scariness;
    }

    public void tailWhip(Character other){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	x = x - other.defense;
	other.health = other.health -x;
	System.out.print(name + "just used tailWhip" +  other.name + "'s health is now " + other.health + ".");
    }
	    

    public void glare (Character other) {
	int x = scariness;
	x = x - other.dexterity;
	other.dexterity = other.dexterity - x;
	System.out.print(name + "just used glare." +  other.name + "'s dexterity is now " + other.dexterity + ".");

    }

}
