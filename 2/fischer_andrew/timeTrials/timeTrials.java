import java.io.*;
import java.util.*;


public class timeTrials{
    public static void main (String[] args){

	ArrayList<Integer> a = new ArrayList<Integer>();
	Random r = new Random();

	for(int i = 0; i < 1001; i++){
	    a.add(r.nextInt(9999));
	}

	long start = System.currentTimeMillis();
	a.add(1);
	long stop = System.currentTimeMillis();
	System.out.println("a.add took " + stop-start + "ms.");

	long start2 = System.currentTimeMillis();
	a.add(0,1);
	long stop2 = System.currentTimeMillis();
	System.out.println("a.add at end took " + stop2-start2 + " ms.");

	long start3 = System.currentTimeMillis();
	a.remove(0);
	long stop3 = System.currentTimeMillis();
	System.out.println("a.remove(0) took " + stop3-start3 + " ms.");

	long start4 = System.currentTimeMillis();
	a.remove(a.size()-1);
	long stop4 = System.currentTimeMillis();
	System.out.println("a.remove at end took " + stop4-start4 + " ms.");

    }
}
