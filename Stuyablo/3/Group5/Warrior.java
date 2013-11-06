import java.util.*;
import java.io.*;

public class Warrior extends Character{
	
	public Warrior(String name) {
		this.name = name;
		strength = 8;
		dexterity = 8;
		experience = 0;
		level = 1;

		System.out.println("Hello " + name);
		System.out.println("You have 8 points to alot to either strength or dexterity. Please type and number between 0 and 8.");
		System.out.println("This number will be added to your strength. This number subtracted from 8 will be added to dexterity.");
		System.out.println();
		Scanner in = new Scanner(System.in);
		int addToStrength = in.nextInt();
		while (addToStrength>8 || addToStrength<0) {
			System.out.println("Please enter a value between 0 and 8.");
			addToStrength = in.nextInt();
		}

		int addToDex = 8-addToStrength;
		strength = strength + addToStrength;
		dexterity = dexterity + addToDex;

		maxhealth = strength;
		health = maxhealth;
		
		System.out.println();

		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

		System.out.println(this.getStatus());
	}

	public void attack(Character other) {
		int dice = roll();
		int attackDmg =(int) (strength / 3);
		if (dexterity <= dice){
			try {
				Thread.sleep(1500);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

		    System.out.println("You succesfuly attacked " + other.name);

		    if (attackDmg > other.health)
			other.health = 0;
			System.out.println("You killed " + other.name);
		    else
			other.health = other.health - attackDmg;
		}
		else
		    System.out.println("Attack failed.");
		
    }

	public static void main(String[] args) {
		Warrior w = new Warrior("Test");
	}

}