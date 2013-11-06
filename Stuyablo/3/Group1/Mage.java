import java.io.*;
import java.util.*;

//Something is wrong here, I can't compile this
//oh yeah also change stat names in here please

public class Mage extends Character {
	protected String[] Spells = {"Bolt", "Frost"};
	
	//basically Cast the spell that is in the array, e.g. Cast(Spells[0], target) will cast Bolt.
	public boolean Cast(String spell, Character other) {
		if (spell.equals("Bolt")) {
			return Bolt(other);
		}
		if (spell.equals("Frost")) {
			return Frost(other);
		}
	}
	
	public boolean Bolt(Character other) { //cost: 2, dmg: 4
		if (this.effStr <= 2) {
			System.out.println("Spell failed! Insufficient cost");
			return false;
		}
		else {
			int roll = roll(3, 6);
			System.out.println("Bolt: cost 1 Strength");
			this.effStr = this.effStr - 2;
			
			System.out.println(this.getName() + " rolled " + roll);
			System.out.print(this.getName() + "'s effInt + 1: ");
			System.out.println(effInt+1);
			if (roll < this.effInt+1){ 
				other.setHealth(other.getHealth()- 4);
				System.out.println("Spell successful");
				System.out.println("*");
			}
        }
		return true;
	}
	
	public boolean Frost(Character other) { //cost: 2, dmg: 1, target effDex-5
		if (this.effStr <= 1) {
			System.out.println("Spell failed! Insufficient cost");
			return false;
		}
		else {
			int roll = roll(3, 6);
			System.out.println("Bolt: cost 1 Strength");
			this.effStr = this.effStr - 1;
			
			System.out.println(this.getName() + " rolled " + roll);
			System.out.print(this.getName() + "'s effInt + 1: ");
			System.out.println(effInt+1);
			if (roll < this.effInt+1){ 
				other.setHealth(other.getHealth()- 1);
				other.seteffDex(other.geteffDex() - 5);
				System.out.println("Spell successful");
				System.out.println("*");
			}
        }
		return true;
	}
	
}