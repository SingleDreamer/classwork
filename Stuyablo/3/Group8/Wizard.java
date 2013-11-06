import java.util.*;
import java.io.*;

public class Wizard extends Character {

    private Scanner sc = new Scanner(System.in);
    
    public Wizard () {
	System.out.println("Your name is:");
	Name = sc.nextLine();
	Level = 1
	Health = 10;
	Intelligence = 8;
	Dexterity = 10;
	Mana = 12;
    }

    public void attack (Character other) {
	int hit = 1;
	//this hit should take into account weapon choice
	boolean damage = true;
	Random r = new Random();
	if (r.nextInt() < 0.5) {
	    damage = true;
	} else {
	    damage = false;
	}
	if (damage==true)
	    other.Health = other.Health - hit;
	this.experience();
    }

    public void encounter {
	Random r = new Random();
	if (r.nextInt() < 0.5) {
	    this.attack(other);
	} else {
	    System.out.println("You attacked" + other.toString());
    }

}
