import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String args[]) {
	Player p1 = new Player();
	Character c1 = new Npc("Evil Bob", p1.getLevel());
	Encounter e = new Encounter();
	System.out.println(c1.getStats());
	System.out.println(p1.getStats());
	e.encounter(p1,c1);
    }
}
