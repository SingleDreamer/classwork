import java.util.*;
import java.io.*;

public class Wizard extends Character {

    private Scanner sc = new Scanner(System.in);
    
    public Wizard () {
	System.out.println("Your name is:");
	Name = sc.nextLine();
	Level = 1
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
