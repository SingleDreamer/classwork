import java.util.*;

public class Character {
    private int waittime = 2000; // This is for Thread.sleep in ms - why did we even implement this? This is a bad idea =/
    protected int health, maxhealth, strength, intelligence, dexterity, experience, level;
    protected String name, characterClass;
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
	try {
	    Thread.sleep (waittime); //how many millisecond to pause
	} catch (Exception e) {

	    // do nothing here -nada. Did you hear me? NOTHING.

	}

	System.out.println ("You have 8 points to assign among your three attributes: Strength, Dexterity and Intelligence." + "\n");

	try {
	    Thread.sleep (waittime); //how many millisecond to pause
	} catch (Exception e) {
	    
	    // do nothing here -nada. Did you hear me? NOTHING.
	    
	}
	
        System.out.println ("Strength will be your warrior's and theives attack stat, while Intelligence defines your Wizard's prowess in battle." + "\n");
	
	try {
	    Thread.sleep (waittime); //how many millisecond to pause
	} catch (Exception e) {
	    
	    // do nothing here -nada. Did you hear me? NOTHING.
	    
	}
	
	System.out.println ("On the other hand, if you want to hit your opponent, then it might be worth investing in Dexterity." + "\n");
	
	try {
	    Thread.sleep (4000); //how many millisecond to pause
	} catch (Exception e) {
	    
	    // do nothing here -nada. Did you hear me? NOTHING.
	    
	}
        
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
    
    
    public void attack(Character other) { //just basic attacking, implementing the basic physical attack that every class has, by default
	//Assume attribute1 is vitality, attribute2 is strength, attribute3 is magic and attribute4 is attribute4
	int damage = strength; //equation subject to change
	if ((dexterity >= other.getDexterity()) || ((dexterity < other.getDexterity()) && (random.nextDouble() > 0.5))) { //hit rate subject to change
	    other.setHealth(other.getHealth() - damage);
	    System.out.println("Hit! " + damage + " damage.");}
	else {System.out.println("Miss!");}
    }
    
    
    /*    public void attack(Character other){
	  int damage = strength;
	  while (this.getHealth() > 0 && other.getHealth() > 0){ //the hits and battle continue until one character's health reaches zero
	  if (this.getDexterity() > other.getDexterity()){ // I am allowing the player with the higher dexterity to attempt to hit first
	  int one = random.nextInt(6) + 1; //this represents the number of the first dice that is rolled
	  int two = random.nextInt(6) + 1; //this represents the number of the second dice that is rolled
	  int three = random.nextInt(6) + 1; //this represents the number of the third dice that is rolled
	  int sum = one + two + three; // this represents the sum of the results of the three di
	  if (sum == 4){
	  other.setHealth(other.getHealth() - (2 * damage)); // a roll of 4 is an auto hit with double the damage
	  System.out.println(this.getName() + "hit" + other.getName());
	  }
	  else if (sum == 3){
	  other.setHealth(other.getHealth() - (3 * damage)); // a roll of 3 is an auto hit with triple the damage
	  System.out.println(this.getName() + "hit" + other.getName());
	  }
	  else if (sum <= 5){
	  other.setHealth(other.getHealth() - damage); // a roll of 5 or less is an auto hit
	  System.out.println(this.getName() + "hit" + other.getName());
	  }
	  else if (sum >= 16){
	  System.out.println(this.getName() + "missed the hit"); // a roll of 16 or more is an auto miss
	  }
	  else if (sum <= this.dexterity){ //the character needs to roll an amount equivalent or less than the dexterity to hit
	  int four = random.nextInt(2); // but because no auto hit I use a one half probablity to see if there will be a hit or not
	  if (four == 1){
	  other.setHealth(other.getHealth() - damage); 
	  System.out.println(this.getName() + "hit" + other.getName());
	  }
	  else{ 
	  System.out.println(this.getName() + "missed the hit");
	  }
	  }
	  else { //I'm not sure what happens because the rules don't specify, in the case where the role is greater than the dexterity but less than sixteen
	  System.out.println("something");
	  }
	  }
	  else if (other.getDexterity() > this.getDexterity()){
	  int one = random.nextInt(6) + 1; //this represents the number of the first dice that is rolled
	  int two = random.nextInt(6) + 1; //this represents the number of the second dice that is rolled
	  int three = random.nextInt(6) + 1; //this represents the number of the third dice that is rolled
	  int sum = one + two + three; // this represents the sum of the results of the three di
	  if (sum == 4){
	  this.setHealth(this.getHealth() - (2 * damage)); // a roll of 4 is an auto hit with double the damage
	  System.out.println(other.getName() + "hit" + this.getName());
	  }
	  else if (sum == 3){
	  this.setHealth(other.this() - (3 * damage)); // a roll of 3 is an auto hit with triple the damage
	  System.out.println(other.getName() + "hit" + this.getName());
	  }
	  else if (sum <= 5){
	  this.setHealth(this.getHealth() - damage); // a roll of 5 or less is an auto hit
	  System.out.println(other.getName() + "hit" + this.getName());
	  }
	  else if (sum >= 16){
	  System.out.println(other.getName() + "missed the hit"); // a roll of 16 or more is an auto miss
	  }
	  else if (sum <= other.getDexterity()){ //the character needs to roll an amount equivalent or less than the dexterity to hit
	  int four = random.nextInt(2); // but because no auto hit uses a one half probablity to see if there will be a hit or not
	  if (four == 1){
	  this.setHealth(other.getHealth() - damage); 
	  System.out.println(other.getName() + "hit" + this.getName());
	  }
	  else{ 
	  System.out.println(other.getName() + "missed the hit");
	  }
	  }
	  else { //I'm not sure what happens because the rules don't specify, in the case where the role is greater than the dexterity but less than sixteen
	  System.out.println("something");
	  }
	  }
	  else{ // in the case if the two dexterity's are the same this one half probability will determine who should have the greater dexterity
	  int five = random.nextInt(2);
	  if (five == 1){
	  this.getDexterity() = this.getDexterity() + 1;
	  }
	  else{
	  other.getDexterity() = other.getDexterity() + 1;
	  }
	  }
	  }
	  if (this.getHealth() == 0){
	  System.out.println(this.getName() + "has been defeated by" + other.getName()); // maybe you guys would rather have the winner's name first as opposed to the loser's name first
	  other.setExperience(other.getExperience() + 10); // the experience points are subject to change
	  }
	  else{
	  System.out.println(other.getName() + "has been defeated by" + this.getName());
	  this.setExperience(this.getExperience() + 10); 
	  }
	  }
    */
    
    // I'm not sure how to code the leveling up based on the experience points
    //Also the code rules mention that characters play with weapons and those determine the damage. I just left out weapons and dealth with strength because that seemed easier.
    //Also I did not know how to use distance for fighting battles because even if each character has a coordinate for x and a coordinate for y 
    //well it makes sense they the x and y values have to have a certain distance between them for attack to work and we can easily add that
    //I just don't know as the character progresses throughout the game how the x and y coordinates are suppose to adjust to his/her position   
}
