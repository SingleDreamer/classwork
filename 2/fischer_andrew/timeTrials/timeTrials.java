import java.io.*;
import java.util.*;


public class timeTrials{
    public static void main (String[] args){

	ArrayList<Integer> a = new ArrayList<Integer>();
	Random r = new Random();

	for(int i = 0; i < 1000000; i++){
	    a.add(r.nextInt(9999));
	}


	long start = System.currentTimeMillis();
	a.add(1);
	long stop = System.currentTimeMillis()-start;
	System.out.println("a.add took " + stop + "ms.");

	long start2 = System.currentTimeMillis();
	a.add(0,1);
	long stop2 = System.currentTimeMillis()-start2;
	System.out.println("a.add at end took " + stop2 + " ms.");

	long start3 = System.currentTimeMillis();
	a.remove(0);
	long stop3 = System.currentTimeMillis()-start3;
	System.out.println("a.remove(0) took " + stop3 + " ms.");

	long start4 = System.currentTimeMillis();
	a.remove(a.size()-1);
	long stop4 = System.currentTimeMillis()-start4;
	System.out.println("a.remove at end took " + stop4 + " ms.");

    }
}
