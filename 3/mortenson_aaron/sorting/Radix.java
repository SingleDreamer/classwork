import java.io.*;
import java.util.*;

public class Radix {

    public ArrayList Sort(ArrayList<Integer> list,int digits) {
	for (int i=0;i<digits;i++) {
	    ArrayList[] buckets = new ArrayList[10];
	    for (int j=0;j<10;j++)
		buckets[i] = new ArrayList();
	    for (int j=0;j<list.size();j++) {
		int digit=list.get(j);		
		int index = (int) ((digit / Math.pow(10,i)) % 10);
		buckets[index].add(digit);
	    }
	}
	return list;
    }
}