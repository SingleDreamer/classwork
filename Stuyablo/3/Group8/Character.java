import java.io.*;
import java.util.*;

public class Character {
    protected String Name;
    protected int Health;
    protected int Mana;
    protected int Strength;
    protected int Intelligence;
    protected int Dexterity;
    protected int Level;

    public Character(String name, int Level) {
	Name = name;
	Level = level;
	Strength = 8;
	Intelligence = 8;
	Dexterity = 8;
	Health = 16;
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

    public int getHealth() {
        return health;
    }

    public void encounter (Character other) {
	if (this.flee == true)
	    this.experience();
	else {
	    Random r = new Random();
	    int Dice = r.nextInt(18);
	    if (Dice <= this.Dexterity) {
		this.attack(other);
		System.out.println("You attacked" + other.toString() + "!");
	    }
	}
}
	
