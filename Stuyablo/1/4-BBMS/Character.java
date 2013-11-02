public class Character {
	protected int health, maxhealth, attribute1, attribute2, attribute3, attribute4, experience, level;
	protected String name, characterClass;
	
	public Character() {
		health = maxhealth = 1;
		attribute1 = attribute2 = attribute3 = attribute4 = 0;
		experience = level = 0;
		name = "No Name";
		characterClass = "No class";
	}
	
	//write them all, just in case
	public int getHealth() {return health;}
	public int getMaxhealth() {return maxhealth;}
	public int getAttribute1() {return attribute1;}
	public int getAttribute2() {return attribute2;}
	public int getAttribute3() {return attribute3;}
	public int getAttribute4() {return attribute4;}
	public int getExperience() {return experience;}
	public int getLevel() {return level;}
	public String getName() {return name;}
	public String getCharacterClass() {return characterClass;}
	
	public void setHealth(int health) {this.health = health;;}
	public void setMaxhealth(int maxhealth) {this.maxhealth = maxhealth;}
	public void setAttribute1(int attribute1) {this.attribute1 = attribute1;}
	public void setAttribute2(int attribute2) {this.attribute2 = attribute2;}
	public void setAttribute3(int attribute3) {this.attribute3 = attribute3;}
	public void setAttribute4(int attribute4) {this.attribute4 = attribute4;}
	public void setExperience(int experience) {this.experience = experience;}
	public void setLevel(int level) {this.level = level;}
	public void setName(String name) {this.name = name;}
	public void setCharacterClass(String characterClass) {this.characterClass = characterClass;}
	
	public String toString() {
		return name + ", Level " + level + " " + characterClass + ", " + health + "/" + maxhealth + " HP, " + experience + " EXP, " + 
			   "Attribute 1: " + attribute1 + ", Attribute 2: " + attribute2 + ", Attribute 3: " + attribute3 + ", Attribute 4: " + attribute4;
	}
}
