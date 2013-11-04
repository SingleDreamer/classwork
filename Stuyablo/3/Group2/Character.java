import java.util*;


public class Character {
    protected int hp, level, dexterity, strength;
    protected String name;

    public Character() {
	name = "Hans Gruber";
	hp = 8;
	dexterity = 8;
	strength = 8;
	level = 1;
    }

    public Character(String name) {
	this.name = name;
	this.hp = 8;
	dexterity = 8;
	strength = 8;
	level = 1;
	
    }
    public boolean roll(){
	die1 = math.round(math.random()*5)+1;
	die2 = math.round(math.random()*5)+1;
	die3 = math.round(math.random()*5)+1;
	total = die1+die2+die3;
	if (dexterity>total){
	    return true;
	}
	else{
	    return false;
	}
    }

    public String toString() {
	return name;
    }
    public String attack() {
	return "Generic attack";
    }

    
}
