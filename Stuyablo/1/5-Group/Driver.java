import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        playerCharacter p1 = new playerCharacter();
	Kracken A = new Kracken("Flib",p1.lvl);
	A.x = 3;
	
	//NPC B = new Necromancer("Inimicus");
	Boolean play = true;
	Scanner s = new Scanner(System.in);

	////STARTUP:
	//name
	System.out.print("\nWELCOME TO THE GAME!\n\n");
	System.out.print("Please enter your Desired Name: ");
	p1.name = s.nextLine();
	System.out.println("");
	//character type
	System.out.println(" Warrior");
	System.out.println(" Wizard");
	System.out.print("Which class would you like to be? ");
	int n = 1;
	while (n>0){
	    if (s.next().toUpperCase().equals("WARRIOR")) {
		p1 = new Warrior();
		n = n-1;
	    }
	    else if (s.next().toUpperCase().equals("WIZARD")){
		p1 = new Wizard();
		n = n-1;
	    }
	    else if (s.hasNext()){
		System.out.println("The computer doesn't understand, please type something that looks like 'warrior' or 'wizard'");
	    }
	}
	//stats
	System.out.print("Do you wish to allocate your skill points Manually or Randomly? ");
	String a = s.next();
	System.out.println("");
	Boolean done = false;
	while (!done){
	    if (a.toUpperCase().equals("MANUALLY")) {
		int x = 8;
		while (x>0){
		    System.out.println("");
		    System.out.println("You have " + x + " attribute points left");
		
		    System.out.println("1. Strength");
		    System.out.println("2. Dexterity");
		    System.out.println("3. Intelligence");
		    System.out.println("4. Defense");
		    System.out.print("Select the number of the Attribute you would like to increase: ");
		    int attIncrease = s.nextInt();
		    if (attIncrease == 1) {
			p1.str = p1.str + 1;
			p1.maxhp = p1.maxhp + 1;
			p1.hp = p1.maxhp;
		    }
		    else if (attIncrease == 2) {
			p1.dex = p1.dex + 1;
		    }
		    else if (attIncrease == 3) {
			p1.intl = p1.intl + 1;
		    }
		    else if (attIncrease == 4){
			p1.def = p1.def + 1;
		    }
		    else {
			System.out.println("please just type 1, 2, 3, or 4");
		    }

		    x = x - 1;
		}
		done = true;
	    }
	    else if (a.toUpperCase().equals("RANDOMLY")){
		Random f = new Random();
		for(int x=8; x>0; x--) {
		    int y = f.nextInt(3);
		    if (y==1) {
			p1.str = p1.str + 1;
			p1.maxhp = p1.maxhp + 1;
		    }
		    else if (y==2) {
			p1.dex = p1.dex + 1;
		    }
		    else if (y==3) {
			p1.intl = p1.intl + 1;
		    }
		    else {
			p1.def = p1.def + 1;
		    }
		}
		done = true;
	    }
	    else if (s.hasNext()){
		System.out.println("Please input either 'Manually' or 'Randomly'");
	    }
	}
	System.out.println(p1.x + ", " + p1.y);
	////GAMEPLAY
	while (play){

	    //encounter
	    if (Math.abs(p1.x - A.x) == 1 && Math.abs(p1.y - A.y) == 1){
		System.out.print("ENCOUNTER!" + "\n");
		while (p1.hp >= 0 && A.hp >=0){
		    if (p1.dex >= A.dex){
			System.out.println("your turn");
			System.out.print("-attack\n-flee\n");
			p1.turn(s.next(),A);
			A.turn(p1);
			System.out.println("\nyour hp is now: " + p1.hp);
		    }
		    else {
			A.turn(p1);
			System.out.println("\nyour hp is now: " + p1.hp);
			if (p1.hp >= 0){
			    System.out.println("your turn:");
			    System.out.print("-attack\n-flee\n");
			    p1.turn(s.next(),A);
			}
		    }
		}
		if (p1.hp <= 0){
		    System.out.println("You have died.");
		    play = false;
		}
		if (A.hp <= 0){
		    System.out.println("You defeated " + A.name + "!");
		}	
	    }
	
	    //moving around
	    else if (s.hasNext()){
		String in = s.next().toUpperCase();
		if (in.equals("W") && p1.y<8){
		    p1.y = p1.y + 1;
		    System.out.println (p1.x + ", " + p1.y);
		}
		else if (in.equals("A") && p1.x>0){
		    p1.x = p1.x - 1;
		    System.out.println (p1.x + ", " + p1.y);
		}
		else if (in.equals("S") && p1.y>0){
		    p1.y = p1.y - 1;
		    System.out.println (p1.x + ", " + p1.y);
		}
		else if (in.equals("D") && p1.x<8){
		    p1.x = p1.x + 1;
		    System.out.println (p1.x + ", " + p1.y);
		}
		else if (in.equals("QUIT") && p1.x<8){
		    play = false;
		}
		else if (in.equals("HELP") && p1.x<8){
		    System.out.println("Press W to go up");
		    System.out.println("Press A to go left");
		    System.out.println("Press S to go down");
		    System.out.println("Press D to go right");
		    System.out.println("Type QUIT to stop playing");
		    System.out.println("Type HELP to see this message again");
		}
		else {
		    System.out.println("not a valid input, type HELP for valid inputs");
		}
	    }
	}
	/*

	System.out.println(" ");

	System.out.println(p1);
	System.out.println(p1.getStr());

	System.out.println(p1.getDex());
	System.out.println(p1.getInt());
	System.out.println(p1.getRole());
	System.out.println(p1.getHP());
	*/
    }
}

