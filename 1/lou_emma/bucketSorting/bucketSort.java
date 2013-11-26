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
    
    public int[] sort(int[] stuff){
	int n = 0;
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
    
    public int[] sort(int[] stuff){
	int n = 0;
	for (int i = 0; i < 10; i++){
	    buckets[i] = new ArrayList();
	}
	for (int i = 0; i < stuff.length; i++){
	    (stuff[i]/10^n)% 10;
	}
    }  
}