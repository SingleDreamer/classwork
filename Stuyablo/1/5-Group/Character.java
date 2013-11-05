import java.io.*;
import java.util.*;

public class Character {
    protected int hp, xp, str, dex, intl, def;
    protected String name;
    private Random r = new Random();

    protected void init(String name, int hp) {
	this.name = name;
	this.hp = hp;
    }

    public Character () {
	init("No Name",50);
    }
    
    public Character (String name) {
	init(name, 50);
    }

    public Character (String name, int hp) {
	init(name, hp);
    }

    public String attack () {
	return "Generic attack";
    }

    public String toString () {
	return name;
    }

    public String levelUp(String stat) {
	String result = "Congratulations!";
	if (stat == "maxhp") {
	    maxhp = maxhp + 1;
	    result = "Leveled up maxhp. maxhp = " + maxhp;
	}
	else if (stat == "str") {
	    str = str + 1;
	    result  = "Leveled up str. str = " + str;
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
	    result = "Unable to level up a stat. Please input one of the following stats to level up: 'maxhp','str', 'dex', 'intl', or 'def'."; }
	return result;
    }

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

    public String getStr() {
	return "Your Strength is " + str;
    }
    public String getDex() {
	return "Your Dexterity is " + dex;
    }
    public String getInt() {
	return "Your Intelligence is " + intl;
    }

}
