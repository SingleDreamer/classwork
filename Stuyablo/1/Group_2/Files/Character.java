import java.util.*;
import java.io.*;

public class Character {
    protected int health;
    protected int maxHealth;
    protected int intelligence;
    protected int dexterity;
    protected int strength;
    protected int experience;
    protected String name;
    protected double x;
    protected double y;

    private Random r = new Random();

    protected void init(String name, int health, int m, int i, int d, int s, int e, double x, double y) {
	this.name = name;
	this.health=health;
	maxHealth = m;
	intelligence = i;
	dexterity = d;
	strength = s;
	experience = e;
	this.x = x;
	this.y = y;
    }
    
    public Character() {
	init("No Name",50,100,8,8,8,0,0,0);
    } 
    public Character(String name) {
	init(name,50,100,8,8,8,0,0,0);
    }
    public Character(String name,int di,int dd,int ds) {
	init(name,50,100,di+8,dd+8,ds+8,0,0,0);

    }

    public double distance(Character other){
	return Math.sqrt(((other.x - x)*(other.x - x))+((other.y - y)*(other.y - y)));
    }

    public String battle() {
	return "Generic battle";
    }
    //fight called in battle
    public void fight(int weapon, double dist){

    }
    //flee called in battle
    public boolean flee(Character other){
	if ((r.nextInt(6)+1)*distance(other)>10){
	    return true;
	}
	return false;
    }

    public String talk(){
	return "Generic talk";
    }



    public String toString() {
	return name;
    }

}
