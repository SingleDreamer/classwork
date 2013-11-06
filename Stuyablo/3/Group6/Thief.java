import java.io.*;
import java.util.*;

public class Thief extends Character{
    Scanner sc1 = new Scanner (System.in);
    public Thief (){
	setDexterity(12);
	setIntelligence(8);
	setStrength(6);
	setName("Dovah the Sly");
	setCharClass("Thief");
	setMaxHealth(6);
	setHealth(6);
    }

    public String toString(){
	return name;
    }

    public boolean flee (Character other){
	if(this.dexterity > other.dexterity){
	    return true;
	}else{
	    return false;
	}
    }

    public void attack (Character other){
	System.out.println(this + " tried to attack " + other + ".");
	boolean hitsuccess = this.roll();
	if (hitsuccess == false) {
	    System.out.println("Attack failed.");
	}
	if (hitsuccess == true) {
	    int damage = strength * (2 / 3); // damage is approximately two third that of strength
	    System.out.println("Attack succeeded.");
	    if (other.health <= damage) {
		other.health = 0;
		this.experience += other.experience;
		System.out.println(other + " defeated.  " + this + "'s experience increased by " + other.experience + " points.");
	    }
	    else
		other.setHealth(other.health - damage);
	    System.out.println(other + "'s health has decreased to " + other.getHealth() + ".");
	    this.experience += 1;
	    System.out.println(this + "'s experience increased by 1 point.");
	}
    }

    public int encounter(Character other){
	System.out.println(this + " encounters " + other.name);
	System.out.println("Do you wish to fight or flee? To fight enter true and to flee enter false");
	boolean b = sc1.nextBoolean();
	if (b == false){
	    boolean a = this.flee(other);
	    if(a == true){
		System.out.println(this + " flees away from " + other.name + " successfully.");
		return 1;
	    }
	    if(a == false){
		System.out.println(this + " was unable to flee.");
	    }
	}
	else {
	    this.attack(other);
	    if(other.health == 0)
		return 2;
	    other.attack(this);
	    if(this.health == 0)
		return 3;
	    return 4;
	}
	return 5;
    }
}
