import java.util.*;
import java.io.*;

public class Character {
    protected int health, maxhealth; // health will regenerate over time
    protected int defense; // effects ability to parry blows
    protected int dexterity; // effects ability to run away
    protected int strength; // effects strength of hits
    protected int charm; // effects who goes attempts to hit first in a battle
    protected String name;
    protected String charType;
    protected String winner;

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

    public Character(String n, String c, int s, int dex, int def, int ch){
	init(n, c, s, dex, def, ch);
    }
	
    
    public Character(){
	System.out.println("Mr. Moran begins strong, but quite slow due to his low dexterity. This makes it harder to run away from opponents. He also has the lowest possible charm, meaning you will probably go last");
        
        try {
            Thread.sleep(2000); // pauses for 2 seconds
        }
        catch (Exception a){
            // intentionally empty...nothing happens
        }

        System.out.println("A wizard can easily runaway, and its high maximum health means that health can reach (and starts at) a high level. However, low defense makes it harder to defend blows of strong opponents");

        try {
            Thread.sleep(2000); // pauses for 2 seconds
        }
        catch (Exception a){
            // intentionally empty...nothing happens
        }

        System.out.println("Ms. Zhang has very weak dexterity, but her defenses are top notch. She has a high charm, increasing the chances of going first in an attack bout");

        try {
            Thread.sleep(2000); // pauses for 2 seconds
        }
        catch (Exception a){
            // intentionally empty...nothing happens
        }
	System.out.println("Warriors have high strength and good defense, but low dexterity. As for students... you'll have to guess the stats.");
	int s, dex, def, mh, ch;
	Scanner sc = new Scanner (System.in);
	System.out.println("Enter your name: ");
	name = sc.next();
	System.out.println("Choose your class. 1-Moran, 2-Wizard, 3-Zhang, 4- Warrior, Any other number- Student ");
	int cl = sc.nextInt();
	
	if (cl == 1){
	    charType="Moran";
	    s = 12;
	    dex = 8;
	    def = 12;
	    mh = s;
	    ch = 0;
	}
	else if (cl == 2){
	    charType="Wizard";
	    s = 11;
	    dex = 13;
	    def = 8;
	    mh = s;
	    ch = 1;
	}
	else if (cl == 3){
	    charType="Zhang";
	    s = 11;
	    dex = 8;
	    def = 13;
	    mh = s;
	    ch = 2;
	}
	else if (cl == 3){
	    charType="Warrior";
	    s = 13;
	    dex = 8;
	    def = 11;
	    mh = s;
	    ch = 1;
	}
	else {
	    charType="Student";
	    s = 10;
	    dex = 12;
	    def = 12;
	    mh = s;
	    ch = 2;
	}
	init(name, charType, s, dex, def, ch);
	Scanner scanner = new Scanner (System.in);
	
	int i = 8;

	String inputs = "";
	
	while (i > 0){
	    System.out.println("\n Right now you have:");
	    System.out.println("\n Strength: " + strength);
	    System.out.println("\n Dexterity: " + dexterity);
	    System.out.println("\n Defense: " + defense);
	    System.out.println("\n Maximum Health: " + strength);
	    System.out.println("\n Charm: " + charm);
	    
	    System.out.println("Select one to increment: 0 - Strength, 1 - Dexterity, 2 - Defense, 3 - Charm, 4 - Random");

	    inputs = (scanner.nextLine());

	    if (inputs.equals("0")){
		    strength += 1;
		    maxhealth += 1;
		    health += 1;
		}

	    else if (inputs.equals("1")){
		    dexterity += 1;
		}

	    else if (inputs.equals("2")){
		    defense += 1;
		}

	    else if (inputs.equals("3")){
		    charm += 1;
		}

	    else if (inputs.equals("4")){
		 Random r1 = new Random();
		 int k = r1.nextInt(4);
		 if (k==0){
		     strength += 1;
		     maxhealth += 1;
		     health += 1;
		 }

		 else if (k == 1){
		     dexterity += 1;
		 }

		 else if (k==2){
		     defense += 1;
		 }
		 else{
		     charm += 1;
		 }
	    }
	     else {
		 System.out.println("You can't do that.");
		 i = i + 1;
	     }
	      i = i - 1;
	}
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
    public void setStrength(int s){
	strength = s;
    }
    public void setDefense(int d){
	defense = d;
    }

    public boolean flee(Character other){
	if (this.getDexterity() > other.getDexterity()){
	    this.setDexterity(this.getDexterity()+1);
	    System.out.println("You fled successfully, and gained dexterity.");
	    return true;
	    // you are capable of running away, should cut out of current interaction
	    // leave your interaction with the current enemy
	}

	else {
	    System.out.println("Your enemy has outwilled you. No running away!. He has also inflicted 1 damage upon you.");
	    this.setHealth(this.getHealth()-1);
	    this.encounter(other);
	    return false;
	}
    }

    public void attack(Character other){
	int damage = (this.getStrength()/4 - other.getDefense()/4);
	Random r = new Random();
	int luck = (r.nextInt(6) + r.nextInt(6) + r.nextInt(6)); //3 6-sided die
 // can potentially give random bonuses
		if (luck > dexterity){
		    System.out.println("You missed.");
		}
		    else if (luck == dexterity -1){ 
		    damage = this.getStrength() - other.getDefense()/4;
		    if (damage > 0){
			    other.setHealth(other.getHealth()-damage);
			    System.out.println("You hit with a four times bonus, dealing " + damage + " damage to your opponent.");
			}
		    else {
			System.out.println("You hit but did not deal enough power to damage your opponent");
			    }
	   }

	   else if (luck == dexterity - 2){ // potential random bonus
		    damage = this.getStrength()*2 - other.getDefense()/4;
		    if (damage > 0){
			    other.setHealth(other.getHealth()-damage);
			    System.out.println("You hit with a eight times bonus, dealing " + damage + " damage to your opponent.");
			}
		    else {
			System.out.println("You hit but did not deal enough power to damage your opponent");
			    }
	   }

	   else if (luck == dexterity - 3) {
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

    public void attackm(Character other){
	int damage = (this.getStrength()/4 - other.getDefense()/4);
	Random r = new Random();
	int luck = (r.nextInt(6) + r.nextInt(6) + r.nextInt(6)); //3 6-sided die
 // can potentially give random bonuses
		if (luck > dexterity){
		    System.out.println("Your opponent missed.");
		}
		    else if (luck == dexterity -1){ 
		    damage = this.getStrength() - other.getDefense()/4;
		    if (damage > 0){
			    other.setHealth(other.getHealth()-damage);
			    System.out.println("Your opponent hit you with a four times bonus, dealing " + damage + " damage to you.");
			}
		    else {
			System.out.println("Your opponent hit but did not deal enough power to damage you");
			    }
	   }

	   else if (luck == dexterity - 2){ // potential random bonus
		    damage = this.getStrength()*2 - other.getDefense()/4;
		    if (damage > 0){
			    other.setHealth(other.getHealth()-damage);
			    System.out.println("Your opponent hit with a eight times bonus, dealing " + damage + " damage to you.");
			}
		    else {
			System.out.println("Your oppponent hit but did not deal enough power to damage you");
			    }
	   }

	   else if (luck == dexterity - 3) {
		    System.out.println("Your opponent missed you, and ended up accidently curing a disease you had");
		    other.setHealth(other.getHealth()+1);
		}

	    else {
		    if (damage > 0) {
			other.setHealth(other.getHealth()-damage);
			System.out.println("Your opponent hit with  no bonus, dealing " + damage + " damage to you.");
			}
		    else {
			System.out.println("Your opponent hit but did not have enough power to damage you");
		    }
	    }
    }

     public void Battle(Character other){
	int r = 20;
        while (r>0 && this.getHealth()>0 && other.getHealth()>0){
	    this.attack(other);
	    if (other.getHealth()>0){
		    other.attackm(this);}
	    r +=1;
		}
     }
    public void encounter(Character other) {
	System.out.println("" + other.getStatus());
	System.out.println("Enter 1 to flee, 2 to talk, any other number to fight");
            Scanner sc = new Scanner(System.in);
	int response = sc.nextInt();
	Random x = new Random();
            
	if (x.nextInt(100)>50 && other.flee(this)){ //randomizes if enemy tries to flee
	    System.out.println("Enemy fled.");}
        else if (response==1) {
	    this.flee(other);
	}
	else if (response == 2){
	    System.out.println("Speak your mind: ");
	    Scanner sc1 = new Scanner(System.in);
	   
	    if (sc1.equals("")){
		System.out.println("What are your thoughts!");
	    }
	    else{
		System.out.println("Your words will be ignored! Don't even try.  How dare you try to negotiate, this is not the UN"); // this will be printed no matter what, because they have no time to enter something to say
	    this.encounter(other);
	    }
	
	}
        else{
	    this.Battle(other);
		if (this.getHealth()<=0){
		    System.out.println("You died.");
		}
		else{
		    System.out.println("You triumphed.");
		    Random a = new Random();
		    if (other.getStrength()>this.getStrength()){
			this.setStrength(this.getStrength() + ((other.getStrength()/10)+1));
		    }
		    if (other.getDexterity()>this.getDexterity())
		    {
			this.setDexterity(this.getDexterity()+((other.getDexterity()/10)+1));
		    }
		    if (other.getDefense()>this.getDefense()){
			this.setDefense(this.getDefense()+((other.getDefense()/10)+1));
		    }
		    this.setHealth(this.getHealth()+2);
		    if (this.getHealth()>this.getMaxHealth()){
			this.setHealth(this.getMaxHealth());
		    }
		    System.out.println(this.getStatus());
		}
	    }
    }   

     public String getStatus() {
        String attrib1=String.format("Str: %d Dex: %d Def: %d Chr: %d",
                                     strength, dexterity, defense, charm);
        String attrib2=String.format("Health: %d of %d",
                                     health,maxhealth);
        String whole=String.format("%s\n%s\n%s\n",
                                   name,attrib1,attrib2);
        return whole;
    }


    public String toString() {
        return name;
    }

}
