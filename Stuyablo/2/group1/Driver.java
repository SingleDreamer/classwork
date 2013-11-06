import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	/*Character a,b;
	a = new Character();
	b = new Character();
	a.attack(b);
	*/
	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII. \nEnter your name: ");
	String name = sc.nextLine();
	System.out.println("Hello " + name);
	System.out.println("-------------------------------");
	
	Character player = new Warrior();

	Character enemy = new Ogre();
	System.out.println("-------------------------------");
	System.out.println("It's an ogre! \nEnemy health: " + enemy.getHealth() + "\nWhat will you do?: ");
	while (enemy.getHealth() > 0 && player.getHealth() > 0){
	    System.out.print("Fight/Flee\n");
	    String input = sc.nextLine();
	    if (input.equals("Fight")){
		player.attack(enemy);
		}
	    else if (input.equals("Flee")){
		System.out.println("You coward...");
	    }
	    else
		System.out.println("Invalid choice");
	    System.out.println("Enemy health: " + enemy.getHealth());
	    System.out.println("-------------------------------");
	}
	System.out.println("Someone died...");
    }
}
	       
	
