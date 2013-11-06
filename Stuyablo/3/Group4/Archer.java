import java.io.*;
import java.util.*;

public class Archer extends Character {
	//Wonder if this constructor will work in asking to initialize character.
	public Archer() {
		charClass = "Archer";
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		x = r.nextInt(8);
		y = r.nextInt(14);

		System.out.println("Enter your Character name: ");
		name = s.nextLine();
		//inputs character name

		System.out.println("Would you like to distribute ability points? \n1. Yes \n2. I will let the machine decide");
		int i = s.nextInt();
		if (i !=1) {
			int a = r.nextInt(8);
			int b = r.nextInt(8-a);
			int c = 8-a-b;
			strength = strength + a;
			dexterity = dexterity + b;
			intelligence = intelligence + c;
		} else {
			System.out.println("Strength? 8 point(s) left");
			int x = s.nextInt();
			if (x < 8 && x > -1) {
				strength = strength + x;
				int x1 = 8 - x;
				System.out.println("Dex? " + x1 + " point(s) left");
				int y = s.nextInt();
				if (y < x1 && x1 > -1) {
					dexterity = dexterity + y;
					intelligence = intelligence + x1 - y;
				}
				else
					dexterity = dexterity + x1;
			}
		}
		maxhealth = 8*strength;
		health = maxhealth;
	}
}
