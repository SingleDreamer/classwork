import java.io.*;
import java.util.*;

public class Warrior extends PC {
    
    public Warrior() {
	super();
    }
    
    public void attack(Character other) {
	super.attack();
	System.out.println("You swing mightily with your sword and it slices through the enemy's flesh");
    }
}
