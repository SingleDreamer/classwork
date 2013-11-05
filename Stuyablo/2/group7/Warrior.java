import java.io.*;
import java.util.*;

public class Warrior extends Character {
	public Warrior(String name) {
		this.name = name;
		distributeStats();
		maxhealth = strength;
		health = maxhealth;
    }
    public void distributeStats() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(name + ", choose your stats:\n\nStrength affects health and the damage done by melee characters.\nDexterity affects accuracy.\nIntelligence affects the chance of fleeing and the damage done by magic users.\n\nWarriors start off with 10 strength, 6 dexterity, and 8 intelligence. You have 8 more points to allocate.");
    	System.out.println("\nHow many points do you want to add to strength?");
    	int str = sc.nextInt();
		System.out.println("\nHow many points do you want to add to dexterity?");
    	int dex = sc.nextInt();
		System.out.println("\nHow many points do you want to add to intelligence?");
    	int intel = sc.nextInt();
		this.name = name;
		strength = 10 + str;
		dexterity = 6 + dex;
		intelligence = 8 + intel;
		System.out.println(String.format("Str: %d Dex: %d Int: %d\n\n",
				     				strength, dexterity, intelligence));
		if (dexterity + strength + intelligence > 32) {
			System.out.println("You have added too many points, please try again.\n\n");
			distributeStats();
		}
    }
}