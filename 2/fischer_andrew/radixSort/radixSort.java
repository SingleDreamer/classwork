import java.util.*;
import java.io.*;

public class radixSort{

	Random r = new Random();
	int[] nums = new int[10];


    public void radSort(){

	ArrayList[] buckets = new ArrayList[10];
	for(int i = 0; i<10; i++){ 
	    buckets[i] = new ArrayList();
	}
	
	for (int j = 0; j < nums.length; j++) {
	    nums[j] = r.nextInt(10000);
	}

	for (int n = 1; n < 5; n++) {
	    for (int k = 0; k < 10; k++) {
		buckets.add(nums[k], (nums[k] % Math.pow(10, n)));
	    }
	    for (int m = 0; m < 10; m++) {
		for (int p = 0; p < (Integer)buckets.get(p).length; p++){
		    nums[p] = (Integer)(buckets.get(m)).get(p);
		}
	    }
	}
    }
}