import java.util.*;
import java.io.*;

public class Player extends Character {
    private int level;
    private int cooldown;

    public void attack(Nonplayer c){
	Scanner s = new Scanner (System.in);
	System.out.print ("How would you like to fight?" + "\n" + "1 : Basic Attack, 2: Special Attack 1, 3: Special Attack 2");
	int attack = s.nextInt();
	if (attack == 1){
	    basicattack(c);
	}
	else if (attack == 2){
	    if (cooldown > 0){
		System.out.println("You do not have the energy for that");
		attack(Nonplayer c);
	    }
	    else
		specialattack1(c);
	}
	else if (attack == 3){
	    if (cooldown > 0){
		System.out.println("You do not have the energy for that");
	    }
	    else
		specialattack2(c);
	}
	else {
	    System.out.print ("That is not an attack. ");
	    attack(c);
	}
    }

    public void loseHealth(int n){
	health = health - n;
    }
    public void gainHealth(int n){
	health = health + n;
    }

    public void gainGold(int n){
	gold = gold + n;
    }

    public void loseGold(int n){
	gold = gold - n;
    }

    public void gainExp(int n){
	experience = experience + n;
    }

    public void levelUp(){
	experience = 0;
	level = level + 1;
	gold = gold + 1000;
	maxhealth = maxhealth + 100;
	health = maxhealth;
	System.out.print("Congratulations! You have leveled up!" + "\n");
	System.out.print("Here are three stat points to use. \n");
	int points = 3;
	points = setStrength (points);
	System.out.print ("\n" + "There are " + points + " points left");
        if (points > 0){
	    points = setDexterity (points);
	    System.out.print ("\n" + "There are " + points + " points left");
	}
	if (points > 0){
	    points = setIntelligence (points);
	    System.out.print ("\n" + "There are " + points + " points left");
	}
	if (points > 0){
	    System.out.print ("\n" + "Due to failure to use all your points, they are now gone. -poof-" + "\n");
	}	
    }

    public Player (){
        Scanner n = new Scanner (System.in);
	System.out.print("Enter your name: ");
	name = n.nextLine();
	System.out.print("Welcome to StuyabloII, " + name + "\n");
    }

    public void basicattack(Nonplayer c){
	Random r = new Random();
	int damage = 0;
	String aname = "Basic Attack";
	if (charClass == "Warrior"){
	    damage = strength - 2 + r.nextInt(5);
	}
	else {
	    damage = intelligence - 2 + r.nextInt(5);
	}
	if (cooldown > 0){
	    cooldown = cooldown - 1;
	}
	if (hit()){
	    c.loseHealth(damage);
	    System.out.println (name + " has attacked " + c + " with " + aname + "and did " + damage + " damage!\n");
	}
	else {
	    System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
	}
    }

    public void specialattack1(Nonplayer c){
	int damage = 0;
	String aname = "";
	if (cooldown == 0){
	    if (charClass == "Warrior"){
		damage = strength + 10;
		aname = "Sword Spin";
	    }
	    else {
		damage = intelligence + 10;
		aname = "Fire Blast";
	    }
	    cooldown = 1;
	}
	if (hit()){
	    c.loseHealth(damage);
	    System.out.println (name + " has attacked " + c + " with " + aname + "and did " + damage + " damage!\n");
	}
	else {
	    System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
	}
    }

    public void specialattack2(Nonplayer c){
	int damage = 0;
	String aname = "";
	if (cooldown == 0){
	    if (charClass == "Warrior"){
		damage = strength + 20;
		aname = "Sword Lunge";
	    }
	    else {
		damage = intelligence + 20;
		aname = "Electric Strike";
	    }
	    cooldown = 3;
	}
	if (hit()){
	    c.loseHealth(damage);
	    System.out.println (name + " has attacked " + c + " with " + aname + "and did " + damage + " damage!\n");
	}
	else {
	    System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
	}
    }

    public boolean hit(){
	Random r = new Random();
        int dice1, dice2, dice3;
	dice1 = r.nextInt(6)+ 1;
	dice2 = r.nextInt(6)+ 1;
	dice3 = r.nextInt(6)+ 1;
	int sum = dice1 + dice2 + dice3;
	return (sum <= dexterity);
    }
	

}
