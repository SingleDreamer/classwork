import java.io.*;
import java.util.*;

public class Warrior extends Character{
    private Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    public Warrior(){
	super();
    }
    public void attack(Character other){
	System.out.print("What is your weapon of choice: 1 for Sword, 2 for Arrow, 3 for Direct Combat");
	int weap = sc.next();
	
	if (weap == 1){
	    if (this.distance(other) < 5){
		System.out.println(name + "chooses Sword");
		super.attack(other);
	    }
	    else{
		System.out.println("You're too far away!");
		System.out.println("Choose Weapon: 1 for Arrow");
		int ans = sc.next();
		while (int != 1){
		    System.out.println("Choose Weapon: 1 for Arrow");
		    int ans = sc.next();
		}
		super.attack(other);
	    }
	}
	else{
	    super.attack(other);
	}
    }
}
	    
		    
	    
