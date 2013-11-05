import java.util.*;
import java.io.*;


public class Driver {
    public static void main(String[] args) {
	Wizard w = new Wizard();
        playerCharacter p1 = new playerCharacter();

	w.setCharacter(p1);
	
	/*
       	NPC A = new NPC("Inimicus");
	NPC B = new NPC("Flib");
	Boolean play = true;
	Scanner s = new Scanner(System.in);
	while (play){
	    if (math.abs(p1.x - A.x) == 1 || math.abs(p1.y - A.y) == 1){
		while (p1.hp >= 0 && A.hp >=0){
		    if (p1.dex >= A.dex){
			System.out.println("your turn");
			p1.turn(s.next());
			A.turn();
		    }
		    else {
			A.turn();
			System.out.println("your turn");
			p1.turn(s.next());
		    }
		}
	    }
	    else if (s.hasnext()){
		if (s.next().upper().equals("W") && p1.y<8){
		    p1.y = p1.y + 1;
		}
		else if (s.next().upper().equals("A") && p1.x>0){
		    p1.x = p1.x - 1;
		}
		else if (s.next().upper().equals("S") && p1.y>0){
		    p1.y = p1.y - 1;
		}
		else if (s.next().upper().equals("D") && p1.x<8){
		    p1.x = p1.x + 1;
		}
		else if (s.next().upper().equals("QUIT") && p1.x<8){
		    play = false;
		}
		else if (s.next().upper().equals("HELP") && p1.x<8){
		    System.out.println("Press W to go up");
		    System.out.println("Press A to go left");
		    System.out.println("Press S to go down");
		    System.out.println("Press D to go right");
		    System.out.println("Type QUIT to stop playing");
		    System.out.println("After typing anything, press enter");
		    System.out.println("Type HELP to see this message again");
		}
	    }
	}
	*/

	System.out.println(" ");

	System.out.println(p1);
	System.out.println(p1.getStr());

	System.out.println(p1.getDex());
	System.out.println(p1.getInt());
	System.out.println(p1.getRole());
	System.out.println(p1.getHP());
    }

}
