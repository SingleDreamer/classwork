import java.util.*;

public class Character {
        protected int health, maxhealth, strength, intelligence, dexterity, experience, level;
	protected String name, characterClass;
	public static Random random = new Random(); //it's not really necessary to make this random number generator private or protected nor to create an instance of the Random class for each character
	
	public Character() {
		health = maxhealth = 1;
		strength = intelligence = dexterity = 0;
		experience = 0;
		level = 1;
		name = "No Name";
		characterClass = "No class";
	}
	
    public Character (String name, String characterClass) {
	this.characterClass = characterClass;
	System.out.println ("You are a " + getCharacterClass() + "\n");
	this.name = name;
	this.strength = this.intelligence = this.dexterity = 8;
	Scanner scanner2 = new Scanner (System.in);
	System.out.println ("\n" + "Now it's time to pick your attributes!" + "\n");
	
	try {
	    Thread.sleep (2000); //how many millisecond to pause
	} catch (Exception e) {

	    // do nothing here -nada. Did you hear me? NOTHING.

	}

	System.out.println ("You have 8 points to assign among your three attributes: Strength, Dexterity and Intelligence." + "\n");

	try {
	    Thread.sleep (3000); //how many millisecond to pause
	} catch (Exception e) {

	    // do nothing here -nada. Did you hear me? NOTHING.

	}

        System.out.println ("Strength will be your warrior's and theives attack stat, while Intelligence defines your Wizard's prowess in battle." + "\n");

	try {
	    Thread.sleep (3500); //how many millisecond to pause
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
		    
			strength = random.nextInt (9) + 8;
			intelligence = random.nextInt (17 - strength) + 8;
			dexterity = ( (24 - strength) - intelligence ) + 8;
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
	
}
