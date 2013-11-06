import java.io.*;
import java.util.*;

public class Archer extends Character{

    public Archer(String name,int strClass,int dexClass, int intClass){
	super(name,strClass,dexClass,intClass);

    }

    public String toString(){
	return super.toString() + "the Archer";
    }
    public void attack(Character other) {
	rollDice();
	if (roll > this.dexterity) {
	    
	    other.health = other.health - this.dmgdouble;
	    other.dexterity = other.dexterity - 1;
	    //Archer vision is too good, he aims at the ankles so his opponents are less mobile.
	    System.out.println(this.toString() + "'s Health: " + this.health);
	    System.out.println(other.toString() + "'s Health: " + other.health);
	    System.out.println(this.toString() + "'s Damage: " + this.dmgdouble);
	    System.out.println(other.toString() + "'s Damage: " + other.dmgdouble);
	}
	
    }
}
