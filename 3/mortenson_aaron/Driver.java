import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String args[]) {
	ArrayList <String> a1 = new ArrayList<String>();
	ArrayList <String> a2 = new ArrayList<String>();
	long start = System.currentTimeMillis();
	for (int i = 0;i<100000;i++) {
	    a1.add("Moo");
	}
	long end = System.currentTimeMillis();
	long time = end-start;
	System.out.print("a.add(s) time for 100000:");
	System.out.println(time);
	start = System.currentTimeMillis();
	for (int i = 0;i<100000;i++) {
	    a2.add("Moo");
	}
	end = System.currentTimeMillis();
	time = end-start;
	System.out.print("a.add(0,s) time for 100000:");
	System.out.println(time);
	start = System.currentTimeMillis();
	for (int i = 0;i<20000000;i++) {
	    a1.add("Moo");
	}
	end = System.currentTimeMillis();
	 time = end-start;
	System.out.print("a.add(s) time for 20000000:");
	System.out.println(time);
	start = System.currentTimeMillis();
	for (int i = 0;i<20000000;i++) {
	    a2.add("Moo");
	}
	end = System.currentTimeMillis();
	time = end-start;
	System.out.print("a.add(0,s) time for 20000000:");
	System.out.println(time);
    }
}