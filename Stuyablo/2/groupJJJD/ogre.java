public class ogre extends Character{
    
    public ogre(String name,int strClass,int dexClass,int intClass){
	super(name,strClass,dexClass,intClass);
	
}
    
    public String toString(){
	return super.toString() + " the Ogre";

	public void attack(Character other) {
	    rollDice();
	    if (roll > this.dexterity) {
		
		other.health = other.health - (this.dmg + 1);
		//Ogre picks up random tree, does more damage
		System.out.println(this.toString() + "'s Health: " + this.health);
		System.out.println(other.toString() + "'s Health: " + other.health);
		System.out.println(this.toString() + "'s Damage: " + this.dmg);
		System.out.println(other.toString() + "'s Damage: " + other.dmg);
	    }
		
	}
    }
    
    
}
