import java.io.*;
import java.util.*;

public class Kracken extends NPC {
    private int intim;
    private Random rand = new Random();
    
    public Kracken (String name, int intim, int Pstr, int Pdex, int Pintl, int Pdef) {
	super(name, Pstr, Pdex, Pintl, Pdef);
`	this.intim = intim;
    }

    public Kracken (String name, int lvl){
	super(name, 0.5, 0.55, 0.6, 1.0);
	this.intim = 8;
    }

    public void tentaSmack(Character other){
	int x = 3 + rand.nextInt(6) + rand.nextInt(6) + rand.nextInt(6);
	x = x - other.def;
	other.hp = other.hp -x;
	System.out.print(name + "just used tentaSmack" + "\n" + other.name + "'s health is now " + other.hp + ".");
    }

    public void glare (Character other) {
	int x = intim;
	x = x - other.dex;
	other.dex = other.dex - x;
	System.out.print(name + "just used glare." +  other.name + "'s dex is now " + other.dex + ".");
    }

    public void turn(Character other){
	if (r.nextDouble() < 0.5){
	    attack(other,"melee");
	}
	else if (r.nextDouble() < 0.8){
	    tentaSmack(other);
	}
	else {
	    glare(other);
	}

}
