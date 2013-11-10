import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	Elf p1 = new Elf();
	Character c1 = new Npc("Evil Bob", p1.getLevel());
	Encounter e = new Encounter();
	System.out.println("How long do you want the game to be? 1: short 2:medium 3:long 4:never ending!");
	int len = sc.nextInt();
	if (len == 1) 
	    len=5;
	else if (len == 2)
	    len=10;
	else if (len == 30)
	    len=20;
	else
	    len=999999999;
	for (;len>0;len--) {
	    c1 = new Npc("Evil Bob", p1.getLevel());
	    System.out.println(c1.getStats());
	    System.out.println(p1.getStats());
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    e.encounter(p1,c1);
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	}
    }
}
