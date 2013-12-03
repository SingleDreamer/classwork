//INCOMPLETE

import java.io.*;
import java.util.*;

public class Sorter {

    private ArrayList[] buckets = new ArrayList[10];
    private int[] nums = new int[100];
    private Random r = new Random();
    private int n = 0;

    public Sorter() {
	for(int i=0; i<10; i++)
	    buckets[i] = new ArrayList();
	for(int i=0; i<100; i++)
	    nums[i] = r.nextInt(9999);
    }

    public void sortArray() {
	while (n<4) {
	    for(int i=0; i<nums.length; i++) {
		int nthdigit = ((int)(nums[i]/(Math.pow(10,n))))%10;
		buckets[nthdigit].add(nums[i]);
	    }
	    int temp = 0;
	    for(int i=0;i<buckets.length;i++) {
		for (int j=0;j<buckets[i].size();j++) {
		    if (temp==100) System.out.println("hit 100");
		    else {
			nums[temp] = (Integer)(buckets[i].get(j));
			temp++;
		    }
		}
	    }
	    n++;
	}
    }

    public String toString() {
	String ans = "";
	for(int i=0;i<buckets.length;i++)
	    ans += buckets[i];
	return ans;
    }

}