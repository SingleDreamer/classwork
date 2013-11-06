import java.io.*;
import java.util.*;
public class Driver {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	NonPlayer n = new NonPlayer();
	NonPlayer n2 = new NonPlayer("Elmo");
	Wizard wi = new Wizard();
	Character c = new Character();
	System.out.print("Enter name:");
	String name = sc.next();
	System.out.print("Choose character (Warrior or Wizard): ");
	String charClass = sc.next().toUpperCase();
	if (charClass== "WARRIOR"){
	    c = new Warrior (name);
	}

	else if(charClass == "WIZARD"){
	    c = new Wizard(name);
	}
	else{
	    System.out.print("Please Choose character (Warrior or Wizard): ");
	    charClass = sc.next().toUpperCase();
	    if (charClass== "WARRIOR"){
		c = new Warrior (name);
	    }

	    else if(charClass == "WIZARD"){
		c = new Wizard(name);
	    }
	}
	System.out.println("---------------------------------/nPlayer vs. Player");
	c.Battle(30,wi);
	System.out.println("---------------------------------/nPlayer v. nonPlayer");
	c.Battle(30,n);
	System.out.println("---------------------------------/nNPC vs. NPC");
	n.Battle(30,n2);
    }
}
