import java.util.*;
import java.io.*;

public class Player extends Character {
    private int level;

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

    public void setClass(){
        Scanner s = new Scanner (System.in);
	System.out.print ("Are you a Wizard or a Warrior? Please type 'Wizard' or 'Warrior'");
	String c = s.nextLine();
	if (c.equals("Wizard")){
	    charClass = "Wizard";
	}
	else if (c.equals("Warrior")){
	    charClass = "Warrior";
	}
	else {
	    System.out.print ("Silly player. That's not a choice. \n");
	    setClass();
	}
    }
}
