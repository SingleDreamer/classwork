public class Warrior  extends Character {

    private int health;

    public Warrior(String name, int limit) {
	super(name,limit);
	health = 100;
	skills = 3;
    }
    public Warrior() {
	super();
	skills = 3;
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
    public int test (int type, Character other){
	if (type == 1) {
	    return super.test(other,2,6,"physical"); }
	else if (type == 2) {
	    return super.test(other,3,4,"physical"); }
	else if (type == 3) {
	    return super.test(other,10,1,"physical"); }
	else
		return super.test(0,other);
	}


}
