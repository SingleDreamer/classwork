import java.io.*;
import java.util.*;

public class bucketSort{

    private ArrayList[] buckets = new ArrayList[10];
    private int[] rand4DigitNums = new int[15];
    
    public bucketSort(){
	for (int i = 0; i < 10; i++){
	    buckets[i] = new ArrayList();
	}
	Random r = new Random();
	for (int j = 0; j<rand4DigitNums.length; j++){
	    rand4DigitNums[j] = r.nextInt(10000);
	}
    }
    public String get(){
	return Arrays.toString(rand4DigitNums);
    }
    
    public int[] get4Digit(){
	return rand4DigitNums;
    }
    public ArrayList[] sort(){
      
	for (int i = 0; i < 10; i++){
	    buckets[i] = new ArrayList();
	}
	for (int n = 0; n < 4; n++){
	    for (int i = 0; i < rand4DigitNums.length; i++){
		int exp = (int)(Math.pow(10,n));
		int place=((rand4DigitNums[i]/exp)% 10);
		buckets[place].add(rand4DigitNums[i]);
		System.out.println(buckets[place]);
		System.out.println(place);
	    }
	}
	    	
	return buckets;
    }  
}