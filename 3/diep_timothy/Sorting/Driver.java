import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("*-* Testing class Sorter *-*");
        System.out.println();

	Sorter s = new Sorter();

	System.out.println("Original Int Array:");
	System.out.println(s);
	s.arrange();
	System.out.println("Sorted Int Array:");
	System.out.println(s);
	System.out.println();

	Sorter t = new Sorter(9,5);
	System.out.println("Original Int Array:");
	System.out.println(t);
	t.arrange();
	System.out.println("Sorted Int Array:");
	System.out.println(t);
	System.out.println();

    }
}