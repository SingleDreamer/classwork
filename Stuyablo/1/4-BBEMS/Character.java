import java.util.*;

public class Character {
    static int waittime = 2000; // This is for Thread.sleep in ms - why did we even implement this? This is a bad idea =/
    protected int health, maxhealth,intelligence, strength, dexterity, experience, level, opponentsDefeated, freezecount;
    protected String name, characterClass;
    public static Random random = new Random(); //it's not really necessary to make this random number generator private or protected nor to create an instance of the Random class for each character
    // Constructors

    public Character() {
	int freezecount = 0;
	if (random.nextInt (5) < 4) {
	    strength = random.nextInt (20);
	    health = maxhealth = strength;
	    intelligence = random.nextInt (20);
	    dexterity = random.nextInt (10);
	    experience = 0;level = 1;name = "ANGRY ENEMY";characterClass = "No class";
	} else {
	    strength = random.nextInt (20) + 10;
	    health = maxhealth = strength + 10;
	    intelligence = random.nextInt (20) + 10;
	    dexterity = random.nextInt (9) + 10;
	    experience = 0;level = 1;name = "SUPER ANGRY ENEMY";characterClass = "No class";
	}
    }
    // Important constructor - includes scanner functions to prompt for configuration
    public Character (String name, String characterClass) {
	int freezecount = 0;
	this.opponentsDefeated = -1;
	this.characterClass = characterClass;
	System.out.println ("You are a " + getCharacterClass() + "\n");
	this.name = name;
	if (getCharacterClass().equals ("Warrior")) {this.setAttributes(12,4,8);}
	if (getCharacterClass().equals ("Wizard")) {this.setAttributes(4,12,8);}
	if (getCharacterClass().equals ("Thief")) {this.setAttributes(8,4,12);}
	Scanner scanner2 = new Scanner (System.in);
	System.out.println ("\n" + "Now it's time to pick your attributes!" + "\n");
	delay();
	System.out.println ("You have 8 points to assign among your three attributes: Strength, Dexterity and Intelligence." + "\n");
	delay();
        System.out.println ("Strength will be your warrior's and theives attack stat, while Intelligence defines your Wizard's prowess in battle." + "\n");
	delay();
	System.out.println ("On the other hand, if you want to hit your opponent, then it might be worth investing in Dexterity." + "\n");
	delay();        
	int n = 8;
	String attributer = "";
	boolean input2 = false;
	boolean yes = false;
	while (n > 0) {
	    System.out.println ("Current Stats:");
	    System.out.println ("Strength: " + strength);
	    System.out.println ("Intelligence: " + intelligence);
	    System.out.println ("Dexterity: " + dexterity);
	    System.out.println ("Select an Attribute to raise (0 - Random, 1- Strength, 2 - Intelligence, 3 - Dexterity): ");
	    while (!input2) {
		attributer = (scanner2.nextLine()).trim();
		if ((attributer.equals("0")) || (attributer.equals("1")) || (attributer.equals("2")) || (attributer.equals("3"))) {input2 = true;} //is there a more efficient method to do this line?
	    }
	    if (attributer.equals("0")) {
		strength = random.nextInt (9) + strength;
		intelligence = random.nextInt ( (32 - strength - intelligence - dexterity)) + intelligence;
		dexterity = ( (32 - strength - dexterity - intelligence ) ) + dexterity;
		n = 0; //stops the while loop at the end
	    }
	    if (attributer.equals("1")) {strength = strength + 1;}
	    if (attributer.equals("2")) {intelligence = intelligence + 1;}
	    if (attributer.equals("3")) {dexterity = dexterity + 1;}
	    n = n - 1;
	    attributer = "";
	    input2 = false;
	}
	health=maxhealth=strength;
    }
    //write them all, just in case
    public int getHealth() {return health;}
    public int getMaxhealth() {return maxhealth;}
    public int getStrength() {return strength;}
    public int getIntelligence() {return intelligence;}
    public int getDexterity() {return dexterity;}
    public int getExperience() {return experience;}
    public int getLevel() {return level;}
    public String getName() {return name;}
    public String getCharacterClass() {return characterClass;}
    public int getOpponentsDefeated() {return opponentsDefeated;}
    public void setHealth(int health) {this.health = health;;}
    public void setMaxhealth(int maxhealth) {this.maxhealth = maxhealth;}
    public void setStrength(int attribute1) {this.strength = strength;}
    public void setIntelligence(int attribute2) {this.intelligence = intelligence;}
    public void setDexterity(int attribute3) {this.dexterity = dexterity;}
    public void setExperience(int experience) {this.experience = experience;}
    public void setLevel(int level) {this.level = level;}
    public void setName(String name) {this.name = name;}
    public void setCharacterClass(String characterClass) {this.characterClass = characterClass;}
    public void setAttributes(int strength,int intelligence,int dexterity) {this.strength = strength;this.intelligence = intelligence;this.dexterity = dexterity;}    
    public void setOpponentsDefeated (int n) {this.opponentsDefeated = n;}
    public String toString() {
	 return setGreenBackground + name + ", Level " + level + " " + characterClass + ", " + health + "/" + maxhealth + " HP, " + experience + " EXP, " + 
	    "Strength: " + strength + ", Intelligence: " + intelligence + ", Dexterity: " + dexterity + setPlainText;
    }
    public static void delay() {try {Thread.sleep (waittime);} catch (Exception e) {}} // Why are we using exceptions... We don't even extend them anywhere. In addition, we're only using them to catch any errors the try spits out...

    public final String setPlainText = "\033[0;0m"; //Removes all Font Changes
    public final String setBoldText = "\033[0;1m"; //Makes Font Bold
    public final String setMagenta = "\033[0;35m"; //Makes Font Magenta Colored
    public final String setCyan = "\033[0;36m"; //Makes Font Cyan Colored
    public final String setGreenBackground = "\033[0;42m"; //Sets Background to Green
	
    /* public void attack(Character other) { //just basic attacking, implementing the basic physical attack that every class has, by default
	//Assume attribute1 is vitality, attribute2 is strength, attribute3 is magic and attribute4 is attribute4
	int damage = strength; //equation subject to change
	if ((dexterity >= other.getDexterity()) || ((dexterity < other.getDexterity()) && (random.nextDouble() > 0.5))) { //hit rate subject to change
	    other.setHealth(other.getHealth() - damage);
	    System.out.println("Hit! " + damage + " damage.");}
	else {System.out.println("Miss!");}
    }
    */

    public void attack(Character other){


	System.out.println ("Type 'Attack' to strike and defend your honor!");
	boolean input3 = false;
	String attackSignal = "";
	Scanner scanner3 = new Scanner (System.in);
	while (!input3) {
	    attackSignal = scanner3.nextLine ().trim ();
	    if (attackSignal.equals ("Attack") || attackSignal.equals ("attack") )  {

		    input3 = true;

		}

		}

	    
	
	int damage = 0;
	int otherDamage = 0;
	String firstHit = "";
	// set the damage that is done by this character
	if (getCharacterClass().equals("Wizard")){
	    damage = intelligence - random.nextInt(10);
	}
	else if ((getCharacterClass().equals("Warrior")) || (getCharacterClass().equals("Thief"))){
	    damage = strength - random.nextInt (10);
	}
	// set the damage done by other character
	if (other.getCharacterClass().equals("Wizard")){
	    otherDamage = other.getIntelligence() - random.nextInt (10);
	}
	else if ((other.getCharacterClass().equals("Warrior")) || (other.getCharacterClass().equals("Thief"))){
	    otherDamage = other.getStrength() - random.nextInt (10);
	}

	if (this.getDexterity() == other.getDexterity()){ // in case the dexterity's of the two characters are equal we randomly increase one by 1 so we can determine who will hit first. Ben: Smart addition.
	  int prob = random.nextInt(2);
	  if (prob == 1){
	      this.setDexterity(this.getDexterity() + 1);
	  }
	  else{
	      other.setDexterity(other.getDexterity() + 1);
	  }
	}
	if (this.getDexterity() > other.getDexterity()){ // I am allowing the player with the higher dexterity to attempt to hit first
	    firstHit = this.getName();
	}
	else if (other.getDexterity() > this.getDexterity()){
	    firstHit = other.getName();
	}
	while (this.getHealth() > 0 && other.getHealth() > 0){ //the hits and battle continue until one character's health reaches zero
	    if (firstHit.equals(this.getName())){ // if this character has the higher dexterity he hits first
		int one = random.nextInt(6) + 1; //this represents the number of the first dice that is rolled by this character
		int two = random.nextInt(6) + 1; //this represents the number of the second dice that is rolled by this character
		int three = random.nextInt(6) + 1; //this represents the number of the third dice that is rolled by this character
		int sum = one + two + three; // this represents the sum of the results of the three die
		if (sum <= this.getDexterity() /* && this.freezecount == 0 */){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    other.setHealth(other.getHealth() - damage); 
		    System.out.println(setBoldText + this.getName() + " hit " + other.getName() + "!" + setPlainText);
		}
		else{ 
		    System.out.println(setBoldText + this.getName() + " missed the hit!" + setPlainText);
		}
		//now it is other character's chance to hit
		int four = random.nextInt(6) + 1; // this represents the number of the first dice that is rolled by other character
		int five = random.nextInt(6) + 1; // this represents the number of the second dice that is rolled by other character
		int six = random.nextInt(6) + 1; // this represents the number of the third dice that is rolled by other character
		int sum2 = four + five + six; // this represents the sum of the three dice
		if (sum2 <= other.getDexterity() /*&& other.freezecount == 0*/){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    this.setHealth(this.getHealth() - otherDamage); 
		    System.out.println(setBoldText + other.getName() + " hit " + this.getName() + "!" + setPlainText);
		}
		else{ 
		    System.out.println(setBoldText + other.getName() + " missed the hit!" + setPlainText);
		}
	    }
	    else{ // if other character has the higher dexterity he hits first
		int one = random.nextInt(6) + 1; //this represents the number of the first dice that is rolled by other character
		int two = random.nextInt(6) + 1; //this represents the number of the second dice that is rolled by other character
		int three = random.nextInt(6) + 1; //this represents the number of the third dice that is rolled by other character
		int sum = one + two + three; // this represents the sum of the results of the three di
		if (sum <= other.getDexterity() /* && other.freezecount == 0*/){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    this.setHealth(this.getHealth() - otherDamage); 
		    System.out.println(setBoldText + other.getName() + " hit " + this.getName() + "!" + setPlainText);
		}
		else{ 
		    System.out.println(setBoldText + other.getName() + " missed the hit!" + setPlainText);
		}
		//now it is this character's chance to hit
		int four = random.nextInt(6) + 1; // this represents the number of the first dice that is rolled by this character
		int five = random.nextInt(6) + 1; // this represents the number of the second dice that is rolled by this character
		int six = random.nextInt(6) + 1; // this represents the number of the third dice that is rolled by this character
		int sum2 = four + five + six; // this represents the sum of the three di
		if (sum2 <= this.getDexterity() /*&& other.freezecount == 0*/){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    other.setHealth(other.getHealth() - damage); 
		    System.out.println(setBoldText + this.getName() + " hit " + other.getName() +"!" + setPlainText);
		}
		else{ 
		    System.out.println(setBoldText + this.getName() + " missed the hit!" + setPlainText);
		}
	    }

	    delay ();

	    //Ben's idea
	    //after every hit we show the stats for both Character's even though the only one as of now that is changing every so often if health
	    System.out.println ("\n");
	    System.out.println(setMagenta + this.getName() + setPlainText +"'s" + " Current Stats:");
	    System.out.println("Health: " + this.getHealth());
	    System.out.println("Strength: " + this.getStrength());
	    System.out.println("Intelligence: " + this.getIntelligence());
	    System.out.println("Dexterity: " + this.getDexterity());
	    System.out.println("Experience: " + this.getExperience());

	    delay();//Pause for them to read

	    System.out.println ("\n");
	    System.out.println(setCyan + other.getName() + setPlainText +"'s" + " Current Stats:");
	    System.out.println("Health: " + other.getHealth());
	    System.out.println("Strength: " + other.getStrength());
	    System.out.println("Intelligence: " + other.getIntelligence());
	    System.out.println("Dexterity: " + other.getDexterity());
	    System.out.println("Experience: " + other.getExperience());

	    delay(); //Pause for them to read
	   
	    /*if (this.freezecount > 0) {
	      freezecount = freezecount - 1;
	      }*/
	}
	if (this.getHealth() <= 0){
	    System.out.println(setBoldText + this.getName() + " has been defeated by " + other.getName() + "!" + setPlainText); // maybe you guys would rather have the winner's name first as opposed to the loser's name first
	    other.setExperience(other.getExperience() + 50); // the experience points are subject to change
	}
	else{
	    System.out.println(setBoldText + other.getName() + " has been defeated by " + this.getName() + "!" + setPlainText);
	    this.setExperience(this.getExperience() + 50); 
	}
    }
    // I'm not sure how to code the leveling up based on the experience points
    // Also the code rules mention that characters play with weapons and spells and those determine the damage.
    // I wasn't sure how to deal with weapons and spells so for now I just dealth with strength, dexterity, and inteligence as mentioned above in the comments. 
    // Also I did not know how to use distance for fighting battles because even if each character has a coordinate for x and a coordinate for y 
    // well it makes sense they the x and y values have to have a certain distance between them for attack to work and we can easily add that
    // I just don't know as the character progresses throughout the game how the x and y coordinates are suppose to adjust to his/her position       
}
