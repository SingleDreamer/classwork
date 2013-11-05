import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {

	Character c1 = new Character();
	Character c2 = new Character();

	while (c1.getHealth() > 0 &&c2.getHealth() > 0) {
	    System.out.println(c1.encounter(c2));
	    System.out.println(c2.encounter(c1));
	}

    }

}
