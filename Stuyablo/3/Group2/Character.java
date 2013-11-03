public class Character {
    protected int hp, level, dexterity, strength;
    protected String name;

    public Character() {
	name = "Hans Gruber";
	hp = 8;
	dexterity = 8;
	strength = 8;
	level = 1;
    }

    public Character(String name) {
	this.name = name;
	this.hp = 8;
	dexterity = 8;
	strength = 8;
	level = 1;
	
    }
    public int roll(){
    }

    public String toString() {
	return name;
    }
    public String attack() {
	return "Generic attack";
    }

    
}
