import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Character player,enemy;
	player = new Character();
	enemy = new Character();
	Random r = new Random();

	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII. \n Enter your name: ");
	String name = sc.nextLine();
	System.out.println("Hello " + name);
	System.out.println("-------------------------------");
	
	player.setChar();

	if (r.nextDouble() > 0.5){
	    enemy = new Ogre();}
	else{
	    enemy = new Undead();}
	

	System.out.println("-------------------------------");

	System.out.println(player.getHealth());
	System.out.println(enemy.getHealth());
	
	while ((player.alive()) && (enemy.alive())){
	    System.out.println("It's "+ enemy +"! \n What will you do?: ");	    
	    System.out.print("(1)Fight or (2)Flee\n");
	    String input = sc.nextLine();
	    if (input.equals("1")){
		player.attack(enemy);
		enemy.attack(player);
		}
	    else if (input.equals("2")){
		player.flee();
	    }
	    else {
		System.out.println("Invalid choice");
	    }
	    System.out.println("Your Health: " + player.getHealth());
	    System.out.println("Enemy Health: " + enemy.getHealth());
	    System.out.println("-------------------------------");
	}
	System.out.println("Someone died...");
    }
}
	       
	
