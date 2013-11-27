import java.util.*;
import java.io.*;

public class Redix {
    private ArrayList[] buckets = new ArrayList[10];
    private int[] ran;

    public Redix(){
		for (int i=0;i<10;i++)
			buckets[i]=new ArrayList();
	}
	
	public void generate(){
		Random r = new Random();
		for (int i=0;i<10;i++)
		    ran[i] = r.nextInt(9999);
	}
	
   	public void redixSort(int[] a){
		for (int i=0;i<4;i++){
			for (int j=0;j<10;j++){
			  	int n = ran[j]/((int)(Math.pow(10,i)))%10;
			  	buckets[n].add(ran[j]);
		      }
		      
		    int x=0;
		    for (int k=0;k<10;k++){
				for (int b=0;b<buckets[k].size();b++){
			  	    ran[x] = buckets[k].get(b);
			      	x++;
			  	}
		    }
		}
    }

    public String toString(){
    	String r= "";
    	for (int i=0;i<ran.length;i++){
    		if (i!=ran.length-1)
    			r += ran[i] + ", ";
    		else
    			r+= ran[i];
    	}
    	return r;
    }
}