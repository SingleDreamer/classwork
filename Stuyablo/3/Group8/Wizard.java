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
	Strength = 8;
	Dexterity = 10;
	Mana = 12;
    }

    public void experience () {
	experience = experience + 5;
	if (experience == 100) {
	    Level = Level + 1;
	    Health = Health + 3;
	    Mana = Mana + 2;
	    Dexterity = Dexterity + 1;
	    Intelligence = Intelligence + 1;
	}
    }
}
