import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Character player,enemy;
	player = new Character();
	enemy = new Character();
	Random r = new Random();

	Scanner sc = new Scanner(System.in);
	System.out.print("Welcome to StuyabloII. \nEnter your name: ");
	String name = sc.nextLine();
	System.out.println("Hello " + name);
	System.out.println("-------------------------------");
	
	player.setChar();

	while (true) {
	    player.turn();
	}
    }
}
	       
	
