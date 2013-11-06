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
      public void attack(Character other2){
	rollDice();
	if (roll > this.dexterity) {
	    
	    other2.health = other2.health - ((int)this.dmg+2);
	//Warriors do more dmg
	    System.out.println("You smacked him in the head with your giant mace");
	    System.out.println(this.toString() + "'s Health: " + this.health);
	    System.out.println(other2.toString() + "'s Health: " + other2.health);
	    System.out.println(this.toString() + "'s Damage: " + this.dmg);
	    System.out.println(other2.toString() + "'s Damage: " + other2.dmg);
	}
	}
}