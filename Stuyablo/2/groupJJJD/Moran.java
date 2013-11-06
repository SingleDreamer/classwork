import java.io.*;
import java.util.*;

public class Moran extends Character{

    public Moran (String s, int i, int j, int k){
        Random r = new Random();
        int a = r.nextInt(2) + 5;
        strength = a;
        health= strength;
        maxhealth=strength;
        dexterity= 4;
        intelligence = 8;
        
    }
    
    public String toString(){
        return super.toString() + " the Mister";
    }

    public void attack(Character other) {
	rollDice();
	if (roll > this.dexterity) {
	    other.health = other.health - (this.dmg + 1);
	    System.out.println("Mr. Moran descends to interrogate!");
	    System.out.println(this.toString() + "'s Health: " + this.health);
	    System.out.println(other.toString() + "'s Health: " + other.health);
	    System.out.println(this.toString() + "'s Damage: " + this.dmg);
	    System.out.println(other.toString() + "'s Damage: " + other.dmg);
	}
                
    }
}
