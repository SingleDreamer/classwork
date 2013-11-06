public class ogre extends Character{
    
    public ogre(){
	Random r = new Random();
        a = r.nextInt(2) + 5;
	strength = a;
	health= strength;
	maxhealth=strength;
	dexterity= 8;
	// This ogre exercises, he has amazing coordination
	intelligence = 2;
	
}
    
    public String toString(){
	return super.toString() + " the Ogre";
    }
	public void attack(Character other) {
	    rollDice();
	    if (roll > this.dexterity) {
		
		other.health = other.health - (this.dmgdouble + 1);
		//Ogre picks up random tree, does more damage
		System.out.println(this.toString() + "'s Health: " + this.health);
		System.out.println(other.toString() + "'s Health: " + other.health);
		System.out.println(this.toString() + "'s Damage: " + this.dmgdouble);
		System.out.println(other.toString() + "'s Damage: " + other.dmgdouble);
	    }
		
	}
}
    
    
}
