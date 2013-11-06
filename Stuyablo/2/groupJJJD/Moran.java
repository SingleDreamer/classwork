import java.io.*;
import java.util.*;

public class Moran extends Character{
    public Moran (String name, int strClass, int dexClass, int intClass){
	super(name, strClass, dexClass, intClass);

    }

    public String toString(){
	return super.toString() + " the Moran";

    }

 public void attack(Character other2){
	rollDice();
	if (roll > this.dexterity) {
	    
	    other2.health = other2.health - ((int)this.dmg+2);
	//Warriors do more dmg
	    System.out.println(this.toString() + " rages at " + other2.name + " and steals his phone");
	    }
	
}}
