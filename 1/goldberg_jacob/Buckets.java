import java.io.*;
import java.util.*;
//worked with deanna!
public class Buckets {
    Random r = new Random();
    int[] numbers = new int[10];
    public void water(){
	for (int q =0; q<numbers.length; q++){
	numbers[q] = r.nextInt(10000);
    }
    
	ArrayList[] buckets = new ArrayList[10];
    for (int z =0; z<10; z++){
	buckets[z] = new ArrayList();
    }
    int n = 1;
    while (n<5){
	for (int i =0; i<10; i++){	 
	    buckets.add(numbers[i]%(10^n), numbers[i]);
			//.add(numbers[i]));
	}
	for (int x =0; x<10; x++){
	    for (int y = 0; y< buckets.get(x).length; y++){
		numbers[x] = (buckets.get(x)).get(y);
	}
	n++;
    }
    }}
}
