import java.util.*;
import java.io.*;

public class Player extends Character {
    private int level;

    public void attack(){
	//stuff
    }

    public void loseHealth(int n){
	health = health - n;
    }
    public void gainHealth(int n){
	health = health + n;
    }
    public void battle(){
	if (health == 0){
	}
	else
	    attack();
    }
    public void gainExp(int n){
	experience = experience + n;
    }

    public void addStrenth(){
	strength = strength + 1;
    }

    public void addDexterity(){
	dexterity = dexterity + 1;
    }

    public void levelUp(){
	// if (exp >= 100)
	//insert scanner stuff here
    }

    public Player (){
        Scanner n = new Scanner (System.in);
	System.out.print("Enter your name: ");
	name = n.nextLine();
	System.out.print("Welcome, " + name);
    }

}
