import java.io.*;
import java.util.*;

public class myList {
    private int[] data;
    private int numItems;
    
    public myList() {
        data = new int[5];
        numItems=0;
    }

    public void add(int d) {
        
        if (numItems>=data.length) {
	    System.out.println("Growing from "+data.length+" to "+data.length*1.5);
	    // "grow" the array by creating a new one and copying over
	    int[] tmpArray = new int[data.length+data.length/2];
	    for (int i=0;i<data.length;i++)
                tmpArray[i]=data[i];
	    data = tmpArray;
        }
        data[numItems]=d;
        numItems = numItems + 1;
    }
    
    public String toString() {
        String s = Arrays.toString(data)+" : "+numItems;
        return s;
    }
    
    public void insert(int pos, int d) {
	if (numItems >= data.length) {
	    add(0);
	}
	for (int i = numItems; i > pos; i--) {
	    data[i] = data[i - 1];
	}
	data[pos] = d;
    }  
    
    public void remove(int pos) {		
	for (int i = pos; i < numItems - 1; i++) {
	    data[i] = data[i + 1];
	}
	data[numItems - 1] = 0;
	numItems = numItems - 1;
    }
    
    public int get(int pos) {
	return data[pos];
    }
    
    public void set(int pos, int d) {
	data[pos] = d;
    }
    
    public int size() {
	return numItems;
    }
}