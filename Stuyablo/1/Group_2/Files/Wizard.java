public class Wizard extends Character{

    private int mana, health;
    
    public Wizard(String name) {
	super(name);
    }
    public Wizard(String name, int mana) {
	super(name);
	this.mana = mana;
    }

    public Wizard(String name, int mana, int h){
	super(name);
	this.mana = mana;
	this.health = health;
    }

    public String toString() {
	return super.toString()+" the elderly";
    }
    public int getHealth() {
	return health;
    }
    
    
}
