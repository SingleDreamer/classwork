import java.io.*;
import java.util.*;

public class Wizard extends Character{
    private Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    public Wizard(String name){
	this.name = name;
	strength = 16;
	health = 16;
	experience = 1;
	intelligence = 7;
	gold=100;
	x = 0;
	y=0;
	dexterity = 8;
    }
    public Wizard(){
	name = "Phil";
	strength = 15;
	health = 15;
	experience = 1;
	intelligence = 7;
	gold=100;
	x = 0;
	y=0;
	dexterity = 8;
    }
    public void attack(Character other){
	System.out.print("What is your spell of choice: 1 for Fire, 2 for Water, 3 for Direct Combat");
	String weap = sc.next();
	
	if (weap == "1"){
	    if (this.distance(other) < 5){
		System.out.println(name + "chooses Fire Spell");
		damage= 2;
		super.attack(other);
	    }
	    else{
		System.out.println("You're too far away!");
		System.out.println("Choose Weapon: 1 for Water");
		String weap2 = sc.next();
		while (weap2 != "1"){
		    System.out.println("Choose Weapon: 1 for Water");
		    weap2 = sc.next();
		}
		damage = 1;
		super.attack(other);
	    }
	}
	else{
	    damage = 1;
	    super.attack(other);
	}
    }
}
