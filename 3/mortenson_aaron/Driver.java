import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String args[]) {
	/*	
a.add(s) time for 100000:11
a.add(0,s) time for 100000:7
a.add(s) time for 20000000:220
a.add(0,s) time for 20000000:567

a.remove(0) time for 10000:17
a.remove(a.length) time for 10000:0
a.remove(0) time for 100000:933
a.remove(a.length) time for 100000:0

	*/
	ArrayList <Integer> a = new ArrayList<Integer>();
	for (int i=0;i<100;i++)
	    a.add(i);
	System.out.println(a);
	for (int i=0;i<a.size()/2;i++) {
	    int temp = a.get(i);
	    a.set(i,a.get((a.size()-(1+i))));
	    a.set((a.size()-(1+i)),temp);
	}
	System.out.println(a);
    }

}