import java.io.*;
import jav.util.*;

public class NonPlayer_Warrior extends Warrior {

	private int Health, Strength, Dexterity;
	Health = 0;

	while (Health < 75)
		Health = Math.random() * 100;

	public NonPlayer_Warrior(){
		super("Enemy Warrior", Health);
		Dexterity = Math.sqrt(Health)*10;
		Strength = 100 - Dexterity;
		// Strength for a Warrior is alwas greater than or equal to it dexterity.
	}

	public Attack(){
		int num = Math.random() * 10;
		if (num < 4)
			return super.Attack(1);
		if (num < 8)
			return super.Attack(2);
		if (num < 11)
			return super.Attack(3);
	}

	public int fight(){
		return Strength + Attack();
	}

}
