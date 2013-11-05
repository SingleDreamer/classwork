import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String args[]) {
	Player p1 = new Player();
	Npc n1 = new Npc("Evil Bob");
	System.out.println(n1.getStats());
	System.out.println(p1.getStats());
	n1.die();
    }  
}