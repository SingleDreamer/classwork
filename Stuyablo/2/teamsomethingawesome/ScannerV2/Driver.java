import java.util.*;

public class Driver {
    public static void main(String[] args) {
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
	System.out.println("\nWelcome bold adventure " + nameInput);
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
    
	System.out.println("You have encountered a burly ogre!");

	Ogre o = new Ogre();
	String fightInput = "";
	while ((w.getHealth() > 0) && (o.getHealth() > 0)){
	    System.out.println("\n");
	    System.out.println(w.getStatus());
	    System.out.println("What will you do?: Attack Flee");
	    fightInput = sc.nextLine();
	    if (fightInput.equals("Attack")){
		System.out.println("---------------------------------------------------------------");
		if (w.getDex()>o.getDex()){
		    w.attack(o);
		    if (o.getHealth() > 0)
			o.attack(w);
		}
		else{
		    o.attack(w);
		    if (w.getHealth() > 0)
			w.attack(o);
		}
	    }
	    else{}
	    if (o.getHealth() <= 0){
		System.out.println("You have slain the ogre!");
		w.setExp(o.getExp());
		w.setGold(o.getGold());
	    }
	    if (w.getHealth() <= 0){
		System.out.println("Your adventure ends here...");
	    }
	}
	System.out.println("\n");
    }
}


