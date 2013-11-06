import java.util.*;
import java.io.*;

public class Encounter {
    
    public boolean encounter (Character p1, Character p2) {
	boolean playmore = true;
	if (p2.getDexterity() > p1.getDexterity()) {
	    return encounter (p2, p1);
	}
        while (true) {
	    playmore =  p1.encounter(p2);
	    if (!playmore)
		return playmore;
	    playmore = p2.encounter(p1);
	    if (!playmore)
		return playmore;
	    System.out.println(p1 + "'s health: " + p1.getHp());
	    System.out.println(p2 + "'s health: " + p2.getHp());
	}
    }
}