public class Warrior  extends Character {

    private int health;

    public Warrior(String name) {
	super(name,8);
	health = 100;
    }
    public Warrior() {
	super();
	}
    public String toString (){
	return super.toString();
    }
    public int attack (int type, Character other){
	if (type == 1) {
	    System.out.println(this.name + " slashes " + other.name + " with a sword");
	    return super.attack(other,2,6,"physical"); }
	else if (type == 2) {
	    System.out.println(this.name + " stabs " + other.name + " with a spear");
    	    return super.attack(other,3,4,"physical"); }
	else if (type == 3) {
	    System.out.println(this.name + " shoots an arrow at " + other.name);
	    return super.attack(other,10,1,"physical"); }
	else
		return super.attack(0,other);
	//These are different types of attacks that a player would input based on selection (scanner). a nonplayer is randomized
    }

}
