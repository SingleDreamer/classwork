import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {

	Warrior w = new Warrior();

	Character c1 = new Character("Character 1");
	Character c2 = new Character("Character 2");

	while (c1.getHealth() > 0 &&c2.getHealth() > 0) {
	    c1.encounter(c2);
	    System.out.println("------------------------");
	    c2.encounter(c1);
	    System.out.println("------------------------");
	}

    }

}
