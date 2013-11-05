import java.util.*;
import java.io.*;

public class Character2 {
    protected int health, maxhealth; // health will regenerate over time
    protected int defense; // effects ability to parry blows
    protected int dexterity; // effects ability to run away
    protected int strength; // effects strength of hits
    protected int charm; // effects who goes attempts to hit first in a battle
    protected String name;
    protected String charType; // Moran, Zhang, or a Wizard

    protected void init(String n, String c, int s, int dex, int def, int ch){
	name = n;
	charType = c;
	strength = s;
	dexterity = dex;
	defense = def;
	health = s;
	maxhealth = s;
	charm = ch;
    }
    
    public Character2(){
	init ("M Zams", "Moran", 12, 8, 12, 0);
    }

    public Character2(String name, String charType){
	int s = 0;
	 int dex = 0;
	 int def = 0;
	 int mh = 0;
	 int ch = 0;

	if (charType.equals("Moran")){
		 s = 12;
		 dex = 8;
		 def = 12;
		 mh = s;
		 ch = 0;
	    }

	if (charType.equals("Wizard")){
		 s = 11;
		 dex = 13;
		 def = 8;
		 mh = s;
		 ch = 1;
	    }
	
	if (charType.equals("Zhang")){
	     s = 11;
	     dex = 8;
	     def = 13;
	     mh = s;
	     ch = 2;
	}

	Scanner scanner = new Scanner (System.in);
	System.out.println("You may now choose certain apsects of your atributes");
	try {
	    Thread.sleep(2000); // pauses for 2 seconds
	}
	catch (Exception a){
	    // intentionally empty...nothing happens
	}

	System.out.println("\n Mr. Moran begins strong, but quite slow due to his low dexterity. This makes it harder to run away from opponents. He also has the lowest possible charm, meaning you will probably go last");
	
	try {
	    Thread.sleep(2000); // pauses for 2 seconds
	}
	catch (Exception a){
	    // intentionally empty...nothing happens
	}

	System.out.println("\n A wizard can easily runaway, and its high maximum health means that health can reach (and starts at) a high level. However, low defense makes it harder to defend blows of strong opponents");

	try {
	    Thread.sleep(2000); // pauses for 2 seconds
	}
	catch (Exception a){
	    // intentionally empty...nothing happens
	}

	System.out.println("\n Ms. Zhang has very weak dexterity, but her defenses are top notch. \n Now you have 8 points. You can either make certain attributes amazing, or balance them out to create a more well rounded character. She has a high charm, increasing the chances of going first in an attack bout");

	try {
	    Thread.sleep(3000); // pauses for 3 seconds
	}
	catch (Exception a){
	    // intentionally empty...nothing happens
	}

	int i = 8;

	String inputs = "";
	
	while (i > 0){
	    System.out.println("\n Right now you have:");
	    System.out.println("\n Strength: " + s);
	    System.out.println("\n Dexterity: " + dex);
	    System.out.println("\n Defense: " + def);
	    System.out.println("\n Maximum Health: " + s);
	    System.out.println("\n Charm: " + ch);
	    
	    System.out.println("Select one to increment: 0 - Strength, 1 - Dexterity, 2 - Defense, 3 - Charm, 4 - Random");

	    inputs = (scanner.nextLine());

	    if (inputs.equals("0")){
		    s += 1;
		    mh += 1;
		}

	    if (inputs.equals("1")){
		    dex += 1;
		}

	    if (inputs.equals("2")){
		    def += 1;
		}

	    if (inputs.equals("3")){
		    ch += 1;
		}

	     if (inputs.equals("4")){
		 Random r1 = new Random();
		 int k = r1.nextInt(4);
		 if (k==0){
		     s += 1;
		     mh += 1;
		 }

		 if (k == 1){
		     dex += 1;
		 }

		 if (k==2){
		     def += 2;
		 }
		 if (k == 3){
		     ch += 1;
		 }
	     }
	     
	      i = i - 1;
	}
	init(name, charType, s, dex, def, ch);
    }

    public int getHealthPer(){
	return Math.round((health/maxhealth)*100);
    }

    public int getHealth(){
	return health;
    }

    public int getMaxHealth(){
	return maxhealth;
    }

    public int getDexterity(){
	return dexterity;
    }

    public int getStrength(){
	return strength;
    }

    public int getDefense(){
	return defense;
    }
    
    public String getType(){
	return charType;
    }

    public String getName(){
	return name;
    }

    public void setHealth(int h){
	health = h;
    }

    public void setDexterity(int d){
	dexterity = d;
    }

    public boolean flee(Character2 other){
	if (this.getDexterity() > other.getDexterity()){
	    System.out.println("You have run away. Your dexterity will be upgraded due to this success");
	    this.setDexterity(this.getDexterity()+1);
	    return true;
	    // you are capable of running away, should cut out of current interaction
	    // leave your interaction with the current enemy
	}

	else {
	    System.out.println("Your enemy has outwiled you. No running away!. He has also uninflicted 1 damage upon you.");
	    this.setHealth(this.getHealth()-1);
	    return false;
	}
    }

    public void attack(Character2 other){
	int damage = (this.getStrength() - other.getDefense());
	while ((this.getHealth() > 0) && (other.getHealth() > 0)){
	    Random r = new Random();
	    int x = (this.getDexterity() + r.nextInt(3));
	    int y = (other.getDexterity() + r.nextInt(3));
	    if (x > y){
		int luck = (r.nextInt(6) + r.nextInt(6) + r.nextInt(6)); //3 6-sided die
 // can potentially give random bonuses
		if (luck == 0){ 
		    damage = this.getStrength()*4 - other.getDefense();
		    if (damage > 0){
			    other.setHealth(other.getHealth()-damage);
			    System.out.println("You hit with a four times bonus, dealing " + damage + " damage to your oponent.");
			}
		    else {
			System.out.println("You hit but did not deal enough power to damage your opponent");
			    }
		}

		if (luck == 1){ // potential random bonus
		    damage = this.getStrength()*2 - other.getDefense();
		    if (damage > 0){
			    other.setHealth(other.getHealth()-damage);
			    System.out.println("You hit with a two times bonus, dealing " + damage + " damage to your oponent.");
			}
		    else {
			System.out.println("You hit but did not deal enough power to damage your opponent");
			    }
		}

		if (luck == 3) {
		    System.out.println("You missed your attack, and ended up accidently curing a disease your opponent had");
		    other.setHealth(other.getHealth()+1);
		}

		else {
		    if (damage > 0) {
			other.setHealth(other.getHealth()-damage);
			System.out.println("You hit with a no bonus, dealing " + damage + " damage to your oponent.");
			}
		    else {
			System.out.println("You hit but did not have enough power to damage your opponent");
		    }
		}
	    }
	}
    }
}
