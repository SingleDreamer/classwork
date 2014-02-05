import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args){
	bucketSort b = new bucketSort();
	System.out.println(b.get());
	ArrayList[] um = b.sort();
	int[] grr = b.get4Digit();
	for (int i = 0; i < um.length; i++){
	    System.out.println(um[i]);
	}
	System.out.println(Math.pow(10,0));
    }
}