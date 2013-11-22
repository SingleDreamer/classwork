import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args){
	ArrayList<Integer> A = new ArrayList<Integer>();
	for (int i = 1; i < 10000001; i++){
	    A.add(4 * i);
	}
	long start = System.currentTimeMillis();
	A.remove(0);
	long t = System.currentTimeMillis()-start;
	System.out.println(t);
    }
}