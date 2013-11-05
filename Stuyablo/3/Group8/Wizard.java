import java.util.*;
import java.io.*;

public class Wizard extends Character {
    
    public Wizard () {
	Health = 10;
	Intelligence = 8;
	Dexterity = 10;
	Mana = 12;
    }

    public attack () {
	int hit = Mana - 8;
	//this hit should take into account weapon choice
	boolean damage = true;
	Random r = new Random();
	if (r.nextInt() < 0.5) {
	    damage = true;
	} else {
	    damage = false;
	}
	if (damage==true) {
	    enemy.Health = enemy.Health - hit;
	}

    public void encounter () {
	Random r = new Random();
	if (r.nextInt() > 0.5) {
	    
    }
}
