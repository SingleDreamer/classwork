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
	System.out.print("Welcome to StuyabloII. \n Enter your name: ");
	String name = sc.nextLine();
	System.out.println("Hello " + name);
	
	Character player = new Warrior();

	Character enemy = new Ogre();
	System.out.println("It's an ogre! \n What will you do?: fight/flee");
	while (enemy.getHealth() > 0 && player.getHealth() > 0){ 
	    if (sc.nextLine().equals("fight")){
		    player.attack(enemy);
		}
	    System.out.println(enemy.getHealth());
	}
	System.out.println("Someone died...");
    }
}
	       
	
