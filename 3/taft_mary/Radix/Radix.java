import java.io.*;
import java.util.*;

public class Radix {

    private ArrayList[] buckets = new ArrayList[10];
    private int[] IDs;
    private int arrayLength, numDigits;
    private int currentDigit = 0;

    public Radix(int l, int d) {
	arrayLength = l;
	numDigits = d;
	IDs = new int[l];
	for(int i=0; i<buckets.length; i++)
	    buckets[i] = new ArrayList<Integer>();
	Random r = new Random();
	int power = (int)(Math.pow(10,d));
	for(int i=0; i<l; i++)
	    IDs[i] = r.nextInt(power);
    }

    public void sort() {
	while (currentDigit < numDigits) {
	    for(int i=0; i<IDs.length; i++) {
		int sortDigit = (IDs[i]/(int)(Math.pow(10,currentDigit)))%10;
		buckets[sortDigit].add(IDs[i]);
	    }
	    int index = 0;		
	    for(int i=0; i<buckets.length; i++) {
		for(int j=0; j<buckets[i].size(); j++) {
		    IDs[index] = (Integer)(buckets[i].get(j));
		    index++;
		}
		buckets[i].clear();
	    }
	    currentDigit++;
	}
	currentDigit = 0;
    }

    public String toString() {
	return Arrays.toString(IDs);
    } 

}
