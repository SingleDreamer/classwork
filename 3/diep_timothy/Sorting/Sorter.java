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

    public void arrange(){
	for (int n = 0;n<4; i++){
	    for (int i=0; i<10; i++)
		buckets[i] = new ArrayList();
	    for (int j = 0; j<nums.length; j++){
		int m = nums[i];
	        for (int w=n; w>0; w--)
		    m = nums[i]/10;
		m = m%10;
		buckets[m] = buckets[m].add(nums[i]);
	    }
	}
    }


}




}
