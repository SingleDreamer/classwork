import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	Wizard w = new Wizard();
	Character a = new Character();
	
	for(int turn = 1;w.Health>0 && a.Health>0;turn++) {
	    System.out.println("Round " + turn);
	    w.encounter(a);
	    System.out.println("----------------------");
	}
	if (w.Health==0) {
	    System.out.println("The enemy won!");
	}else if (a.Health == 0){
	    System.out.println("You win this fight!");
	}else{
	    System.out.println("Game over, you both died...");
	}
    }
}
