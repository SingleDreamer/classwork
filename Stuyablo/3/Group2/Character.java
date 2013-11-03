public class Character {
    protected int health;
    protected String name;

    public Character() {
	name = "Hans Gruber";
    }

    public Character(String name) {
	this.name = name;
	this.health = 20;
    }

    public String toString() {
	return name;
    }
    public String attack() {
	return "Generic attack";
    }

    
}
