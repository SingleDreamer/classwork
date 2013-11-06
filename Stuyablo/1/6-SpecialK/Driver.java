import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	Character n = new Character();
	System.out.println(n.getStatus());
	Random e = new Random();
	while (n.getHealth()>0){
	    System.out.println("What would you like to do next?...(a)fight the nearest enemy or (b)talk to the nearest NPC? or (c)See your stats? or (d)Quit the game :(");
	    Scanner a = new Scanner(System.in);
	    String choice = a.nextLine();
	    if (choice.equalsIgnoreCase("a")){
		Character p = new Character("Enemy", "Bot", e.nextInt(10), e.nextInt(10), e.nextInt(18), e.nextInt(5));
		n.encounter(p);
	    }
	    else if (choice.equalsIgnoreCase("b")){
		String[] chat = new String[6];
		chat[0] = "Get off the bridge.";
		chat[1] = "Make sure you get at least 24 hours of sleep daily.";
		chat[2] = "You're not allowed on floors 1-10.";
		chat[3] = "Should I confiscate that?...";
		chat[4] = "...";
		chat[5] = "This game is too easy, don't you think?";
		Random num = new Random();
		System.out.println("NPC: " + chat[num.nextInt(6)]);
	    }
	    else if (choice.equalsIgnoreCase("c")){
		System.out.println(n.getStatus());}
	    else if (choice.equalsIgnoreCase("d")){
		System.out.println("Thanks for playing, fool");
		break;}
	    else {
		System.out.println("You can't do that.");
	    }
	}
    }
}
