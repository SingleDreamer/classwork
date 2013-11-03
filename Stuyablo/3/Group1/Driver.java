import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Stuyablo II\nWhat's your name?");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name);
	Character c = new Character(name);
	System.out.println(c.getStatus());
    }
}
