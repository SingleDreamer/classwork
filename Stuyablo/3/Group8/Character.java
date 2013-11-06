import java.io.*;
import java.util.*;

public class Character {
    protected String Name;
    protected int Health;
    protected int Mana;
    protected int Strength;
    protected int Intelligence;
    protected int Dexterity;
    protected int Level = 1;
    protected int experience = 0;

    public String getStatus() {
        String attrib1=String.format("Str: %d Dex: %d Int: %d",
                                     strength, dexterity, intelligence);
        String attrib2=String.format("Exp: %d Health: %d of %d",
                                     experience,health,maxhealth);
        String locale = String.format("x: %5.2f y: %5.2f",x,y);
        String whole=String.format("%s\n%s\n%s\n%s\n",
                                   name,attrib1,attrib2,locale);
        return whole;
    }

    public String toString() {
        return Name;
    }

    public int getHealth() {
        return Health;
    }

    public boolean flee () {
	int Dice = r.nextInt(18);
	if (Dice <= this.Dexterity) {
	    System.out.println("You escaped!");
	    return true;
	} else {
	    return false;}
	return true;
    }

    public void encounter (Character other) {
	if (other.flee() == true){
	    other.experience();
	    return 0;}
	if (this.flee() == true){
	    this.experience();
	    return 1;
	} else {
	    Random r = new Random();
	    int Dice = r.nextInt(18);
	    if (Dice <= this.Dexterity) {
		this.attack(other);
		System.out.println("You attacked" + other.toString() + "!");
		this.experience();
	        if (other.getHealth() > 0) {
		    other.attack(this);
		}
	    } else {
		System.out.println("You missed!");
	    }
	}
	if (this.getHealth() <= 0) return 2;
	else if (other.getHealth() <= 0) return 3;
	else if (this.getHealth() <= 0 && other.Health <= 0) return 4;
	else return 5;
    }

      public void attack (Character other) {
	int hit = 1;
	//this hit should take into account weapon choice
	boolean damage = true;
	Random r = new Random();
	int Dice = r.nextInt(18);
	if (Dice <= this.Dexterity) {
	    damage = true;
	    System.out.println("It's a hit for " + this.toString() + " !");
	} else {
	    damage = false;
	    System.out.println(this.toString() + " Missed!");
	}
	if (damage==true) {
	    other.Health = other.Health - hit;
	}
      }
}
	
