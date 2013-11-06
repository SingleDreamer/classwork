import java.util.*;
import java.io.*;

public class Player extends Character {
    private int level;
    private int cooldown;

    public void attack(){

    }

    public void loseHealth(int n){
	health = health - n;
    }
    public void gainHealth(int n){
	health = health + n;
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

    public void basicattack(){
	int damage = 0;
	if (charClass == "Warrior"){
	    damage = strength - 2 + Random.nextInt(4);
	}
	else {
	    damage = intelligence - 2 + Random.nextInt(4);
	}
	if (cooldown > 0){
	    cooldown = cooldown - 1;
	}
    }

    public void specialattack1(){
	int damage = 0;
	if (cooldown = 0){
	    if (charClass == "Warrior"){
		damage = strength + 10;
	    }
	    else {
		damage = intelligence + 10;
	    }
	    cooldown = 1;
	}
    }

    public void specialattack2(){
	int damage = 0;
	if (cooldown = 0){
	    if (charClass == "Warrior"){
		damage = strength + 20;
	    }
	    else {
		damage = intelligence + 20;
	    }
	    cooldown = 3;
	}

}
