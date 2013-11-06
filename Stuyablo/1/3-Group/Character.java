import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth; 
    protected int dexterity, strength, intelligence;
    //determined through npc and pc constructors
    protected int experience = 0;
    protected int gold = 0;
    protected double x,y,distance;
    //determined at start of battle
    protected String name;
    //constructors
    protected String charClass;
    
    public int getHealth() {
	return health;
    }
    public int getDex() {
	return dexterity;
    }
    public int getStr() {
	return strength;
    }
    public int getInt() {
	return intelligence;
    }
    public int getExp(){
	return experience;
    }

    public void attack(Character other) {
	//nothing so far
    }
    
    
    public void encounter(NPC other) {
        Random r = new Random();
	x = r.nextInt(8);
	y = r.nextInt(8);
	other.x = r.nextInt(8);
	other.y = r.nextInt(8);
	while ((other.x == x) && (other.y == y)){
	    other.x = r.nextInt(8);
	    other.y = r.nextInt(8);
	}

        while (health > 0 && other.health > 0){
	    if (dexterity >= other.dexterity) {
		PCturn(other);
		other.NPCturn(this);
	    }
	    else {
		other.NPCturn(this);
		PCturn(other);
	    }
	}	
		    
    }

    public boolean adjacentCheck(Character other){
	boolean o = false;
	if (x == other.x && ((y + 1 == other.y) || (y - 1 == other.y)))
	    o = true;
	if (y == other.y && ((x + 1 == other.x) || (x - 1 == other.x)))
	    o = true;
	return o;
    }
    
    public void NPCturn(Character other){
	int move = 2;
	while (move > 0 && !adjacentCheck(other)){ // while there are still moves and pc isn't next to npc
	    Random r = new Random();
	    int z = r.nextInt(2);
	    if (z == 0 && (x != other.x)){
		if (other.x > x)
		    x = x + 1;
		else
		    x = x - 1;
	    }
	    if (z == 1 && (y != other.y)){
		if (other.y > y)
		    y = y + 1;
		else
		    y = y - 1;
	    }
	}

	if (adjacentCheck(other)){
		attack(other);
	    }
    }

    public void PCturn(Character other){
    }

    public String getStatus() {
	String attrib1=String.format("Str: %d Dex: %d Int: %d",
				     strength, dexterity, intelligence);
	String attrib2=String.format("Exp: %d Health: %d of %d",
				     experience,health,maxhealth);
	String locale = String.format("x: %5.2f y: %5.2f",x,y);
	String whole=String.format("%s\n%s\n%s\n%s\n",
				   name,attrib1,attrib2,locale);
	return whole;
    }

    public String toString() {
	return name;
    }
    
}
