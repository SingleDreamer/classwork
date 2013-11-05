import java.io.*;
import java.util.*;

public class Wizard extends Character {
    
    public Wizard (String name){
	super(name);
    }

    public int attack(Character other){
	int[] dice = {1,2,3,4,5,6};

	System.out.println("Choose your attack:");
	System.out.println("Press 1 to unleash FIREBALL");
	System.out.println("Press 2 to unleash ICE STORM");
	System.out.println("Press 3 to unleash EARTHSHAKER");

	Scanner sc = new Scanner(System.in);
	int answer = sc.nextInt();

	Random r = new Random();
	int d1 = dice[r.nextInt(dice.length)];
	int d2 = dice[r.nextInt(dice.length)];
	int d3 = dice[r.nextInt(dice.length)];
    }
}