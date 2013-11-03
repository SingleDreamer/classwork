import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;

    public Character(String n){
	name=n;
	strength=toChance+100;
	dexterity=((int)((toChance/100)*5))+15;
	health=((int)((toChance/100)*1000))+5000;
	maxhealth=((int)((toChance/100)*1000))+5000;
    }

    public Character(){
	name="Ogre";
	strength=toChance+100;
	dexterity=((int)((toChance/100)*5))+15;
	health=((int)((toChance/100)*1000))+5000;
	maxhealth=((int)((toChance/100)*1000))+5000;
    }


    public int toChance{){
	double r = Math.random();
	int answer = (int)(r*100);
	return answer;}
    
    public String toString() {
	return name;}
    
}
