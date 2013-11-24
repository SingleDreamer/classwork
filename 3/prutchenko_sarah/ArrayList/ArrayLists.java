import java.util.*;

public class ArrayLists{
    public static void main(String[] args) {
	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();
    
	long start = System.currentTimeMillis();
	for (int i=0; i<10000; i++){
	    al1.add(0);
	}
	long stop = System.currentTimeMillis();
	System.out.println(stop-start);
	
	long start2 = System.currentTimeMillis();
    }
    

    
}