import java.util.*;

public class Character {
    private int waittime = 2000; // This is for Thread.sleep in ms - why did we even implement this? This is a bad idea =/
    protected int health, maxhealth, strength, intelligence, dexterity, experience, level;
    protected String name, characterClass, condition;
    public static Random random = new Random(); //it's not really necessary to make this random number generator private or protected nor to create an instance of the Random class for each character
    
    // Constructors
    // This constructor is barebones and doesn't do jack. Someone just put it here to method overload the inherent version. I've one-lined it to clean it.
    public Character() {health = maxhealth = 1;strength = intelligence = dexterity = 0;experience = 0;level = 1;name = "No Name";characterClass = "No class";}
    // Important constructor - includes scanner functions to prompt for configuration
    public Character (String name, String characterClass) {
	this.characterClass = characterClass;
	System.out.println ("You are a " + getCharacterClass() + "\n");
	this.name = name;
	if (getCharacterClass().equals ("Warrior")) {this.setAttributes(12,4,8);}
	if (getCharacterClass().equals ("Wizard")) {this.setAttributes(4,12,8);}
	if (getCharacterClass().equals ("Thief")) {this.setAttributes(8,4,12);}
	Scanner scanner2 = new Scanner (System.in);
	System.out.println ("\n" + "Now it's time to pick your attributes!" + "\n");
	try {Thread.sleep (waittime);} catch (Exception e) {} // Why are we using exceptions... We don't even extend them anywhere. In addition, we're only using them to catch any errors the try spits out...
	System.out.println ("You have 8 points to assign among your three attributes: Strength, Dexterity and Intelligence." + "\n");
	try {Thread.sleep (waittime);} catch (Exception e) {} // Why are we using exceptions... We don't even extend them anywhere. In addition, we're only using them to catch any errors the try spits out...
        System.out.println ("Strength will be your warrior's and theives attack stat, while Intelligence defines your Wizard's prowess in battle." + "\n");
	try {Thread.sleep (waittime);} catch (Exception e) {} // Why are we using exceptions... We don't even extend them anywhere. In addition, we're only using them to catch any errors the try spits out...
	System.out.println ("On the other hand, if you want to hit your opponent, then it might be worth investing in Dexterity." + "\n");
	try {Thread.sleep (waittime);} catch (Exception e) {} // Why are we using exceptions... We don't even extend them anywhere. In addition, we're only using them to catch any errors the try spits out...
        
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
		intelligence = random.nextInt (17 - strength) + intelligence;
		dexterity = ( (24 - strength) - intelligence ) + dexterity;
		n = 1; //You're subtracting 1 at the end so it will set n to 0.
		
	    }
	    
	    
	    if (attributer.equals("1")) {
		strength = strength + 1;
	    }
	    if (attributer.equals("2")) {
		intelligence = intelligence + 1;
	    }
	    if (attributer.equals("3")) {
		dexterity = dexterity + 1;
	    }
	    
	    n = n -1;
	    attributer = "";
	    input2 = false;
	    
	}
	
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
    public String toString() {
	return name + ", Level " + level + " " + characterClass + ", " + health + "/" + maxhealth + " HP, " + experience + " EXP, " + 
	    "Strength: " + strength + ", Intelligence: " + intelligence + ", Dexterity: " + dexterity;
    }
    
    
    /* public void attack(Character other) { //just basic attacking, implementing the basic physical attack that every class has, by default
	//Assume attribute1 is vitality, attribute2 is strength, attribute3 is magic and attribute4 is attribute4
	int damage = strength; //equation subject to change
	if ((dexterity >= other.getDexterity()) || ((dexterity < other.getDexterity()) && (random.nextDouble() > 0.5))) { //hit rate subject to change
	    other.setHealth(other.getHealth() - damage);
	    System.out.println("Hit! " + damage + " damage.");}
	else {System.out.println("Miss!");}
    }
    */

    public void attack(Character other, int damagesource){
	int damage = 0;
	int otherDamage = 0;
	String firstHit = "";
	// set the damage that is done by this character
	if (getCharacterClass().equals("Wizard")){
	    damage = damagesource;
	}
	else if ((getCharacterClass().equals("Warrior")) || (getCharacterClass().equals("Thief"))){
	    damage = strength;
	}
	// set the damage done by other character
	if (other.getCharacterClass().equals("Wizard")){
	    otherDamage = other.getIntelligence();
	}
	else if ((other.getCharacterClass().equals("Warrior")) || (other.getCharacterClass().equals("Thief"))){
	    otherDamage = other.getStrength();
	}

	if (this.getDexterity() == other.getDexterity()){ // in case the dexterity's of the two characters are equal we randomly increase one by 1 so we can determine who will hit first
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
	    while condition
	    if (firstHit.equals(this.getName())){ // if this character has the higher dexterity he hits first
		int one = random.nextInt(6) + 1; //this represents the number of the first dice that is rolled by this character
		int two = random.nextInt(6) + 1; //this represents the number of the second dice that is rolled by this character
		int three = random.nextInt(6) + 1; //this represents the number of the third dice that is rolled by this character
		int sum = one + two + three; // this represents the sum of the results of the three di
		if (sum <= this.getDexterity()){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    other.setHealth(other.getHealth() - damage); 
		    System.out.println(this.getName() + "hit" + other.getName());
		}
		else{ 
		    System.out.println(this.getName() + "missed the hit");
		}
		//now it is other character's chance to hit
		int four = random.nextInt(6) + 1; // this represents the number of the first dice that is rolled by other character
		int five = random.nextInt(6) + 1; // this represents the number of the second dice that is rolled by other character
		int six = random.nextInt(6) + 1; // this represents the number of the third dice that is rolled by other character
		int sum2 = four + five + six; // this represents the sum of the three di
		if (sum2 <= other.getDexterity()){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    this.setHealth(this.getHealth() - otherDamage); 
		    System.out.println(other.getName() + "hit" + this.getName());
		}
		else{ 
		    System.out.println(other.getName() + "missed the hit");
		}
	    }
	    else{ // if other character has the higher dexterity he hits first
		int one = random.nextInt(6) + 1; //this represents the number of the first dice that is rolled by other character
		int two = random.nextInt(6) + 1; //this represents the number of the second dice that is rolled by other character
		int three = random.nextInt(6) + 1; //this represents the number of the third dice that is rolled by other character
		int sum = one + two + three; // this represents the sum of the results of the three di
		if (sum <= other.getDexterity()){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    this.setHealth(this.getHealth() - otherDamage); 
		    System.out.println(other.getName() + "hit" + this.getName());
		}
		else{ 
		    System.out.println(other.getName() + "missed the hit");
		}
		//now it is this character's chance to hit
		int four = random.nextInt(6) + 1; // this represents the number of the first dice that is rolled by this character
		int five = random.nextInt(6) + 1; // this represents the number of the second dice that is rolled by this character
		int six = random.nextInt(6) + 1; // this represents the number of the third dice that is rolled by this character
		int sum2 = four + five + six; // this represents the sum of the three di
		if (sum2 <= this.getDexterity()){ //the character needs to roll an amount equivalent or less than the dexterity to hit
		    other.setHealth(other.getHealth() - damage); 
		    System.out.println(this.getName() + "hit" + other.getName());
		}
		else{ 
		    System.out.println(this.getName() + "missed the hit");
		}
	    }

	    //Ben's idea
	    //after every hit we show the stats for both Character's even though the only one as of now that is changing every so often if health
	    System.out.println(this.getName());
	    System.out.println("Health: " + this.getHealth());
	    System.out.println("Strength: " + this.getStrength());
	    System.out.println("Intelligence: " + this.getIntelligence());
	    System.out.println("Dexterity: " + this.getDexterity());
	    System.out.println("Experience: " + this.getExperience());

	    System.out.println(other.getName());
	    System.out.println("Health: " + other.getHealth());
	    System.out.println("Strength: " + other.getStrength());
	    System.out.println("Intelligence: " + other.getIntelligence());
	    System.out.println("Dexterity: " + other.getDexterity());
	    System.out.println("Experience: " + other.getExperience());
	}
	if (this.getHealth() == 0){
	    System.out.println(this.getName() + "has been defeated by" + other.getName()); // maybe you guys would rather have the winner's name first as opposed to the loser's name first
	    other.setExperience(other.getExperience() + 50); // the experience points are subject to change
	}
	else{
	    System.out.println(other.getName() + "has been defeated by" + this.getName());
	    this.setExperience(this.getExperience() + 50); 
	}
    }

    
    // I'm not sure how to code the leveling up based on the experience points
    //Also the code rules mention that characters play with weapons and spells and those determine the damage. I wasn't sure how to deal with weapons and spells so for now I just dealth with strength, dexterity, and inteligence as mentioned above in the comments. 
    //Also I did not know how to use distance for fighting battles because even if each character has a coordinate for x and a coordinate for y 
    //well it makes sense they the x and y values have to have a certain distance between them for attack to work and we can easily add that
    //I just don't know as the character progresses throughout the game how the x and y coordinates are suppose to adjust to his/her position   
}
