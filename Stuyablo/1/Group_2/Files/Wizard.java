public class Wizard extends Character{

    protected int mana, health;
    
    public Wizard() {
	mana = 100;
	health = 40;
    }

    public Wizard(String name) {
	super(name);
	mana = 100;
	health = 40;
    }
    public Wizard(String name, int mana) {
	super(name);
	this.mana = mana;
	health = 40;
    }

    public Wizard(String name, int mana, int h){
	super(name);
	this.mana = mana;
	this.health = health;
    }    
    
}
