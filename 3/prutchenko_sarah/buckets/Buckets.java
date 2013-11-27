import java.util.*;
import java.io.*;

public class Buckets{
	ArrayList[] buckets= new ArrayList[10];
    Random r = new Random();
    public Buckets(){
	for (int i=0; i<10; i++){
	    buckets[i] = r.nextInt(10000);
	}
    }

    public void sort(){
	for(int n=0; n<4; n++){
	    ArrayList[] temp= new ArrayList[10];
	    for (int j=0; j<10; j++){
		int exp=(int)Math.pow(10,n);
		temp.add((buckets[j]/exp%10), buckets[j] );
	    }
	    buckets=temp;
	}
    }
}