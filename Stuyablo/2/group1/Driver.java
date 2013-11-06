import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Character player,enemy;
	player = new Character();
	enemy = new Character();
	Random r = new Random();
	boolean escape = false;

	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII. \n Enter your name: ");
	String name = sc.nextLine();
	System.out.println("Hello " + name);
	System.out.println("-------------------------------");
	
	int i = 0;
	while (i == 0){
	    System.out.print("What would you like to be? (1)Warrior? (2)Wizard?\n");
	    String input = sc.nextLine();
	    if (input.equals("1")) {
		System.out.println("Woo, You're a warrior");
		System.out.println("-------------------------------");
		player = new Warrior(name);
		break;
	    }
	    else if (input.equals("2")) {
		System.out.println("Woo, you're a Wizard");
		System.out.println("-------------------------------");
		player = new Wizard(name);
		break;
	    }
	    else {
		System.out.println("Silly you, ponies aren't a choice");
	    }
	}

	if (r.nextDouble() > 0.5){
	    enemy = new Ogre();}
	else{
	    enemy = new Undead();}
	

	System.out.println("-------------------------------");

	System.out.println("Your health: " + player.getHealth());
	System.out.println("Enemy's health: " + enemy.getHealth() + "\n");
	
	while ((player.alive()) && (enemy.alive())){
	    System.out.println("It's "+ enemy +"! \n What will you do?: ");	    
	    System.out.print("(1)Fight or (2)Flee\n");
	    String input = sc.nextLine();
	    if (input.equals("1")){
		player.attack(enemy);
		enemy.attack(player);
		}
	    else if (input.equals("2")){
		if(player.flee() == true){
		    escape = true;
		    break;
		}
	    }
	    else {
		System.out.println("Invalid choice");
	    }
	    System.out.println("Your Health: " + player.getHealth());
	    System.out.println("Enemy Health: " + enemy.getHealth());
	    System.out.println("-------------------------------");
	}
	if (escape == false)
	    System.out.println("Someone died...");
    }
}
	       
	
