<<<<<<< HEAD
import java.io.*;
=======
>>>>>>> dd4f6f582c78680c989f01aa577b91eebc842a02
import java.util.*;

public class Driver {
    public static void main(String[] args) {
<<<<<<< HEAD
	Scanner sc = new Scanner(System.in);
	int strengthAdd, intellAdd, dexAdd;
	strengthAdd = 0;
	intellAdd= 0;
	dexAdd=0;
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, "+name);
        System.out.print("What class would you like to be? \n Classes and their key bindings:\n~Warrior-1\n~Thief-2\n ");
        int cc = sc.nextInt();
	if (cc ==1) {
	    System.out.println("Welcome, warrior " + name+ ".");
		}
	else if(cc==2) {
	    System.out.println("Welcome, thief " + name + ".");
		}
	int attributePoints=8;
	System.out.println("\nIMPORTANT:In this game there are three attributes: Strength, which corresponds to health, intelligence which corresponds to mana and ability power, and dexterity which corresponds to speed and accuracy (if you're a thief, it also corresponds to accuracy).Each attribute starts at a base value of 8. You are allotted 8 extra points to add to the base value at your discretion.\n");
	while (attributePoints>0){
	    System.out.println("What attribute would you like to give points to?\n~Strength-1\n~Intelligence-2\n~Dexterity-3") ;
	    int att = sc.nextInt();
	    if (att==1) {
		System.out.println("You have " +attributePoints+ " extra point(s) left. How many points would you like to add to your strength?");
		int strAdd=sc.nextInt();
		if (strAdd >= 0 && strAdd <=attributePoints){
		    attributePoints=attributePoints-strAdd;
		    strengthAdd = strAdd;
		}
		else {
		    System.out.println("Try again, with an integer between 0 and however many attributes points you have left.");
		}
	    }
	    else if (att==2) {
                System.out.println("You have " +attributePoints+ " extra point(s) left. How many points would you like to add to your intelligence?");
                int intAdd=sc.nextInt();
                if (intAdd >= 0 && intAdd <=attributePoints){
                    attributePoints=attributePoints-intAdd;
		    intellAdd=intAdd;
                }
                else {
                    System.out.println("Try again, with an integer between 1 and however many attribute points you have left.");
                }
            }
	    if (att==3) {
                System.out.println("You have " +attributePoints+ " extra point(s) left. How many points would you like to add to your dexterity?");
                int dexterAdd=sc.nextInt();
                if (dexterAdd >= 0 && dexterAdd <=attributePoints){
                    attributePoints=attributePoints-dexterAdd;
		    dexAdd=dexterAdd;
                }
                else {
                    System.out.println("Try again, with an integer between 1 and however many attribute points you have left.");
                }
            }	
	/* Character c = new Character();
	System.out.println(c.getStatus());*/
	}
	System.out.println("You added " + strengthAdd+ " points to your base strength value of 8.");
	System.out.println("You added " + intellAdd+ " points to your base intelligence value of 8.");
	System.out.println("You added " + dexAdd+ " points to your base dexterity value of 8.\n");
	if (cc==1) {
	    Warrior player=new Warrior(name, strengthAdd, intellAdd, dexAdd);
	    System.out.println("You have survived setup. Prepare yourself, warrior " +name+ " for the trials that await you. Your attributes are:\n~Strength="+player.getStrength()+"\n~Intelligence="+player.getIntelligence()+"\n~Dexterity="+player.getDexterity()+"");
	}
	else if (cc==2){
	    Thief player= new Thief(name, strengthAdd, intellAdd, dexAdd) ;
	    System.out.println("You have survived setup. Prepare yourself, thief " +name+ " for the trials that await you. Your attributes are:\n~Strength="+player.getStrength()+"\n~Intelligence="+player.getIntelligence()+"\n~Dexterity="+player.getDexterity()+"");

	}

		 
=======
	//Character c = new Character(); Zamnaksy's
	//System.out.println(c.getStatus()); Zamansky's

	//PLEASE KEEP INPUT=The user input and PROMPT=What we print out
	Helper h = new Helper();
	Warrior w = new Warrior();
	//System.out.println(w.getStatus()); Testing
	Scanner sc = new Scanner(System.in);
	System.out.print("Whatst isst thoust's namest: ");
	String nameInput = sc.nextLine();
	h.pause();
	System.out.println("Welcome bold adventure " + nameInput);
	w.setName(nameInput);
	int bonusAttributes = 8;
	System.out.print("You have 8 bonus attributes!\nWhat would you like to invest them in?\nType S for Str, D for Dex and I for Int:\n");
	String attributesPrompt = "Points left: ", attributesInput;
	while (bonusAttributes > 0){
	    System.out.println(attributesPrompt + bonusAttributes);
	    attributesInput = sc.nextLine();
	    if (attributesInput.equals("S") || attributesInput.equals("D") || attributesInput.equals("I")){
		bonusAttributes = bonusAttributes - 1;
		if (attributesInput.equals("S")){
		    w.setStr(1);
		    System.out.println("Your strength grows!");
		}
		else if (attributesInput.equals("D")){
		    w.setDex(1);
		    System.out.println("Your dexterity grows!");
		}
		else{
		    w.setInt(1);
		    System.out.println("Your intelligence grows!");
		}
	    }
	    else{
		System.out.println("What thoust sayst?");
	    }
	}
	System.out.println(w.getStatus());
>>>>>>> dd4f6f582c78680c989f01aa577b91eebc842a02
    }
}
