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
	strength=toChance()+100;
	dexterity=((int)((toChance()*.01)*5))+15;
	health=((int)((toChance()/100)*1000))+5000;
	maxhealth=health;
    }

    public Character(){
	name="Ogre";
	strength=toChance()+100;
	dexterity=((int)((toChance()*.01)*5))+15;
	health=((int)((toChance()*.01)*1000))+5000;
	maxhealth=health;
    }
    
    public int toChance(){
	double r = Math.random();
	int answer = (int)(r*100);
	return answer;}

    public String toStats(){
	String answer="";
	answer=answer+"Name: "+name+"\n";
	answer=answer+"Strength: "+strength+"\n";
	answer=answer+"Dexterity: "+dexterity+"\n";
	answer=answer+"Health: "+health+"\n";
	answer=answer+"MaxHealth: "+maxhealth;
	return answer;
    }

    public String toString() {
	return toStats();}
}
