import java.io.*;
import java.util.*;

public class sort {
    private int[] ran = new int[10];
    private ArrayList[] buckets = new ArrayList[10];

    public void generate() {
	Random r = new Random();
	for(int i = 0; i < 10; i++) {
 	    ran[i] = r.nextInt(9999);
	}
    }

    public String toString() {
	String s = "[ ";
	for(int i =0; i< ran.length; i++) {
	    s = s + ran[i] + " ";
	}
	s = s + "]";
	return s;
    }

    public void radixSort(){
	for(int i = 0; i < 4; i++) {
	    for(int newi = 0; newi<10; newi++){
		buckets[newi] = new ArrayList();
	    }

	    for(int j = 0; j <10; j++) {
		int n = ran[j]/((int)(Math.pow(10,i)))%10;
		buckets[n].add(ran[j]);
	    }
	    
	    int herp = 0;
	    for(int k = 0; k<10; k++) {
		for(int l = 0; l<buckets[k].size(); l++) {
		    int z = (Integer)(buckets[k].get(l));
		    ran[herp] = z;
		    herp++;
		}
	    }
	    
	}
    }

    public static void main(String[] args) {
	sort s = new sort();
	s.generate();
	System.out.println("Before " + s);
	s.radixSort();
	System.out.println("After " + s);

    }
} 