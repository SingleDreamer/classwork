import java.io.*;
import java.util.*;

public class Sorter{

    private ArrayList[] buckets = new ArrayList[10];
    private int[] nums;
    Random r = new Random();
    private int digits, size;

    public Sorter(){
	nums = new int[10];
	for (int i = 0; i<10; i++)
	    nums[i] = r.nextInt(10000);
	digits = 4;
	size = 10;
    }

    public Sorter(int d, int s){
	digits = d;
	size = s;
	nums = new int[size];
	int range = 1;
	for (int j = 0; j<digits; j++)
	    range = range * 10;
	for (int i = 0; i<size; i++)
	    nums[i] = r.nextInt(range);
    }

    public String toString() {
        return Arrays.toString(nums);
    }

    public void arrange(){
	for (int a=0; a<10; a++)
	    buckets[a] = new ArrayList();
	for (int b = 0; b<digits;b++){
	    for (int c = 0; c<nums.length; c++){
		int z = nums[c];
		for (int d=b; d>0; d--)
		    z = z/10;
		z = z%10;
		buckets[z].add(nums[c]);
	    }
	    for(int e=0; e<nums.length; e++){
		for (int f=0; f<buckets.length;f++) {
		    if (buckets[f].size() != 0) {
			nums[e] = (Integer) buckets[f].get(0);
			buckets[f].remove(0);
			f = buckets.length;
		    }
		}
	    }
	}
    }


}


