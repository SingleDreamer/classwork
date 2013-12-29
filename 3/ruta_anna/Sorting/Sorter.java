import java.io.*;
import java.util.*;

public class Sorter{

    private ArrayList[] buckets = new ArrayList[10];
    private int[] nums = new int[10];
    Random r = new Random();

    public Sorter(){
        for (int i = 0; i<10; i++)
         nums[i] = r.nextInt(10000);
    }

 	public String toString() {
        return Arrays.toString(nums);
    }


	public int digitValue(int n, int t){
		while (t>0){
			n = n/10;
			t--;
		}
		return n%10;
	}

    public void arrange(){
//Will run loop/arrangment for the number of digits in the numbers
       for (int a=0; a<1; a++){
//Creates 10 new buckets/ArrayLists
        	for (int b=0; b<10; b++)
                buckets[b] = new ArrayList();
//Finds the value of the integer in nums[]
       		for (int c=0; c<nums.length; c++){
               	int z = nums[c];
               	buckets[digitValue(z,a)].add((int)nums[c]);
           }
        //After all of the values are in bucket, rearrange nums[] to be in the correct order
           for (int e=0; e<10; e++){
			   int counter = 0;
			   for (int f=buckets[e].size(); f>0; f--){
           	   		nums[counter] = (Integer)buckets[e].get(0);
           	   		buckets[e].remove(0);
           	   		counter++;
		   		}
	   		}
 		}
  	}

}
