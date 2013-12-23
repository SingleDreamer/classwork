import java.util.*;
import java.io.*;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
	String s;

	ArrayList<String> AL = new ArrayList<String>();
	AL.add("one");
	AL.add("two");
	AL.add("three");
	AL.add("four");
	AL.add("five");
	AL.add("six");
	System.out.println("ArrayList (iterator) "+AL);
	Iterator<String> it = AL.iterator();
	while (it.hasNext()) {
	    s = it.next();
	    System.out.println("AL: "+s);
	}
	System.out.println();

	myList ml = new myList();
	ml.add(20);
	ml.add(50);
	ml.add(12);
	ml.add(13);
	System.out.println(ml);
        Iterator<Integer> mlit = ml.iterator();
	// while loop goes here with next and hasNext

	

    }

}
