import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {

	Scanner sc=new Scanner(System.in);
	System.out.println("Please enter your name:");
	String name=sc.nextLine();
	System.out.println("Welcome "+name);
	System.out.println("-------------------------");

	Character c = new Character(name);
	Character c2 = new Character("Bob");

	System.out.println("Choose your character's class:\n");

	System.out.println(c.getStatus());
	c.encounter(c2);
    }
}
