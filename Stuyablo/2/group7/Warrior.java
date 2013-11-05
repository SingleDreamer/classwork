import java.io.*;
import java.util.*;

public class Warrior extends Character {
	public Warrior(String name) {
		this.name = name;
		distributeStats();
		maxhealth = strength * 10;
		health = maxhealth;
    }
    public void distributeStats() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(name + ", choose your stats:\n\nStrength affects health and the damage done by melee characters.\nDexterity affects accuracy.\nIntelligence affects the chance of fleeing and the damage done by magic users.\n\nWarriors start off with 10 strength, 6 dexterity, and 8 intelligence. You have 8 more points to allocate.");
    	System.out.println("\nHow many points do you want to add to strength?");
    	System.out.print(">");
    	int str = sc.nextInt();
		System.out.println("\nHow many points do you want to add to dexterity?");
		System.out.print(">");
    	int dex = sc.nextInt();
		System.out.println("\nHow many points do you want to add to intelligence?");
		System.out.print(">");
    	int intel = sc.nextInt();
		this.name = name;
		strength = 10 + str;
		dexterity = 6 + dex;
		intelligence = 8 + intel;
		System.out.println(String.format("\nStr: %d Dex: %d Int: %d\n\n",
				     				strength, dexterity, intelligence));
		if (dexterity + strength + intelligence > 32) {
			System.out.println("You have added too many points, please try again.\n\n");
			distributeStats();
		}
    }
    public void attack(Character other) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int dex = dexterity;
        int mult = 1;
        int x = r.nextInt(6) + 1, y = r.nextInt(6) + 1, z = r.nextInt(6) + 1;
        System.out.println("\nChoose your weapon:\n1 - Axe\n2 - Sword");
        System.out.print(">");
        int weapon = sc.nextInt();
        if (weapon == 1) {
        	dex = dexterity - 1;
        	mult = 3;
        }
        else if (weapon == 2) {
        	dex = dexterity + 2;
        	mult = 2;
        }
        if (x+y+z <= dex) {
            int dmg = damageDone(other, mult);
            other.loseHealth(dmg);
            System.out.println("\n" + name + " did " + dmg + " damage to " + other + "!");
            }
        else {
            System.out.println("\n" + name + " missed!");
        }
    }
}