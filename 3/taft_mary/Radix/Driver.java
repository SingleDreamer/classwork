import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
	Radix r = new Radix(100,4);
	System.out.println("Original array:\n"+r);
	System.out.println();
	r.sort();
	System.out.println("Sorted array:\n"+r);
    }

}
