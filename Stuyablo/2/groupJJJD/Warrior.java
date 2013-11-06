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
    /*    public void attack(){
	rollDice();
	if (roll > this.dexterity) {
	    
	    other.health = other.health - (int)this.dmg;
	    System.out.println("You smacked him in the head with your giant mace");
	    System.out.println(this.toString() + "'s Health: " + this.health);
	    System.out.println(other.toString() + "'s Health: " + other.health);
	    System.out.println(this.toString() + "'s Damage: " + this.dmg);
	    System.out.println(other.toString() + "'s Damage: " + other.dmg);
	}
	}*/
}