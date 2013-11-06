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
	System.out.println("It's "+ enemy +"! \n What will you do?: ");
	player.encounter(enemy);
	System.out.println("Someone died...");
    }
}
	       
	
