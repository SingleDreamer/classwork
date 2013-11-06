import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Character player,enemy;
	Random r = new Random();
	/*Character a,b;
	a = new Character();
	b = new Character();
	a.attack(b);
	*/
	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII. \n Enter your name: ");
	String name = sc.nextLine();
	System.out.println("Hello " + name);
	System.out.println("-------------------------------");
	
	if (r.nextDouble() > 0.5){
	    player = new Warrior();}
	else{
	    player = new Wizard();}
	if (r.nextDouble() > 0.5){
	    enemy = new Ogre();}
	else{
	    enemy = new Undead();}
	

	System.out.println("-------------------------------");
	System.out.println("It's "+ enemy.toString() +"! \n What will you do?: ");
	while (enemy.getHealth() > 0 && player.getHealth() > 0){
	    System.out.print("Fight/Flee\n");
	    String input = sc.nextLine();
	    if (input.equalsIgnoreCase("Fight")){
		player.attack(enemy);
		}
	    else if (input.equalsIgnoreCase("Flee")){
		System.out.println("You coward...");
	    }
	    else
		System.out.println("Invalid choice");
	    System.out.println("Your Health: " + player.getHealth());
	    System.out.println("Enemy Health: " + enemy.getHealth());
	    System.out.println("-------------------------------");
	}
	System.out.println("Someone died...");
    }
}
	       
	
