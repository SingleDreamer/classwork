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

        //don't know if this will work. Did'nt test yet:
        
        String a=c.getCharClass();
       // String b=c2.getCharClass();

        if (a.equals("Warrior")){
            Warrior war = new Warrior(name);
            c=war;
        }
		
     /* 	if (b.equals("Warrior")){
         	Warrior war2 = new Warrior("Bob");
         	c2=war2;

          }
		  */
        else if (a.equals("Wizard")){
            Wizard wiz = new Wizard(name);
            c=wiz;
        }
		
		/*

    	if (b.equals("Wizard")){
    	    Wizard wiz2 = new Wizard(name);
    	    c2=wiz2;
        }
		
		*/
		
		else if (a.equals("Theif")){
			Theif th=new Theif(name);
			c=th;
		}
		
		else {
			Ogre og=new Ogre(name);
			c=og;
		}
       
        //up to here

    
        c.encounter(c2);
    }
}