import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	Character n = new Character();
	System.out.println(n.getStatus());
	Random e = new Random();
	while (n.getHealth()>0){
	    System.out.println("What would you like to do next?...(a)fight the nearest enemy or (b)talk to the nearest NPC? or (c)See your stats? or (d) meditate? or (e)Quit the game :(");
	    Scanner a = new Scanner(System.in);
	    String choice = a.nextLine();
	    if (choice.equalsIgnoreCase("a")){
		Random s = new Random();
		int x=s.nextInt(4);
		if (x == 1){ 
		    Character p = new Character("Moron", "Moran", 11 + e.nextInt(5), 8 + e.nextInt(5), 10 + e.nextInt(5), e.nextInt(1));
		    n.encounter(p);
		}

		else if (x==2){
		    Character p = new Character("Gandolf", "Wizard", 10 + e.nextInt(5), 11 + e.nextInt(5), 6 + e.nextInt(5), e.nextInt(2));
		    n.encounter(p);
		}

		else if (x==3){
		    Character p = new Character("Warren", "Warrior", 11 + e.nextInt(5), 6 + e.nextInt(5), 9 + e.nextInt(5), e.nextInt(2));
		    n.encounter(p);
		}

		else if (x==0){
		     Character p = new Character("Jie", "Zhang", 9 + e.nextInt(5), 6 + e.nextInt(5), 11 + e.nextInt(5), e.nextInt(3));
		     n.encounter(p);
		}
		else{
		     Character p = new Character("Boss Moron", "Boss Moran", 15 + e.nextInt(5), 10 + e.nextInt(5), 14 + e.nextInt(5), e.nextInt(5));
		     n.encounter(p);
		}
	    }
	    else if (choice.equalsIgnoreCase("b")){
		String[] chat = new String[8];
		chat[0] = "Get off the bridge.";
		chat[1] = "Make sure you get at least 24 hours of sleep daily.";
		chat[2] = "You're not allowed on floors 1-10.";
		chat[3] = "Should I confiscate that?...";
		chat[4] = "...";
		chat[5] = "This game is too easy, don't you think?";
		chat[6] = "I heard that you might heal if you meditate..";
		chat[7] = "Have you ever seen a cow before? I wish I could.";
		Random num = new Random();
		System.out.println("NPC: " + chat[num.nextInt(8)]);
	    }
	    else if (choice.equalsIgnoreCase("c")){
		System.out.println(n.getStatus());
	    }
	    else if (choice.equalsIgnoreCase("d")){
		System.out.println("You healed a little while resting.");
	        Random tempr = new Random();
		n.setHealth(n.getHealth()+ tempr.nextInt(4) + 1);
		if (n.getHealth() > n.getMaxHealth()){
		    n.setHealth(n.getMaxHealth());
		}
	    }
	    else if (choice.equalsIgnoreCase("e")){
		System.out.println("Thanks for playing, fool");
		break;
	    }
	    else {
		System.out.println("You can't do that.");
	    }
	}
    }
}
