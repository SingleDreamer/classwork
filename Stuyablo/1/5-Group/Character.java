import java.io.*;
import java.util.*;

public class Character {
    protected int hp, maxhp, xp, str, dex, intl, def;
    protected String name;
    private Random r = new Random();

    protected void init(String name, int s) {
	this.name = name;
	this.hp = s;
    }

    public Character () {
	init("No Name", str);
    }
    
    public Character (String name) {
	init(name, str);
    }

    public String attack () {
	return "Generic attack";
    }

    public String toString () {
	return name;
    }
    
    public void subHealth (int x) {
	hp = hp - x;
    }

    public String levelUp(String stat) {
	String result;
	System.out.println("Congratulations, you've leveled up! Please input str, dex, intl, or def to level up a stat");
	if (stat == "str") {
	    str = str + 1;
	    hp = hp + 1;
	    result  = "Leveled up str and hp. str and hp = " + str;
	}
	else if (stat == "dex") {
	    dex = dex + 1;
	    result  = "Leveled up dex. dex= " + dex;
	}
	else if (stat == "intl"){
	    intl = intl+ 1;
	    result  = "Leveled up intl. intl = " + intl;
	}
	else if (stat == "def") {
	    def = def + 1;
	    result  = "Leveled up def. def = " + def;
	}
	else {
	    result = "Unable to level up a stat. Please input one of the following stats to level up: 'str', 'dex', 'intl', or 'def'."; }
	return result;
    }
    /*
    public String  equipWeapon(String weapon) {
	String result = "";
	if( weapon.equals("Hammer")){
	    str = str + 5;
	    result = name + " has sucessfully equipped a " + weapon + ".";
	}
	else if( weapon.equals("Sword")){
	    str = str + 20;
	    result = name + " has sucessfully equipped a " + weapon + ".";
	}
	else if( weapon.equals("Wand")){
	    intl = intl + 5;
	    result = name + " has sucessfully equipped a " + weapon + ".";
	}
	else if( weapon.equals("Staff")){
	    intl = intl + 20;
	    result = name + " has sucessfully equipped a " + weapon + ".";
	}
	else {
	    result =  "Unable to equip weapon. Please select a weapon from the list.";
	}
	return result;
    }
    */
}
