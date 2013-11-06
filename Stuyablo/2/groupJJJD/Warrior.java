public class Warrior  extends Character{
    protected int mana;
    protected int strength;
    protected int health;
	
    
    public Warrior(String name, int strClass, int dexClass, int intClass) {
	super(name,strClass,dexClass,intClass);

	
    }
    
    public String toString() {
	return super.toString()+" the Warrior";
    }
}
