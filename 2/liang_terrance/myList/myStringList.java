import java.io.*;
import java.util.*;

public class myStringList {
    private String[] data;
    private int numItems;
	    
    public myStringList() {
	data = new String[5];
	numItems=0;
    }

    public boolean isFull() {
	return numItems >= data.length;
    }

    public void grow() {
	// "grow" the array by creating a new one and copying over
	String[] tmpArray = new String[data.length+data.length/2];
	for (int i=0;i<data.length;i++) 
	    tmpArray[i]=data[i];
	data = tmpArray;
    }

    public void add(String d) {
	if (isFull()){
	    grow();
	}
	data[numItems]=d;
	numItems = numItems + 1;
    }
	    
    public String toString() {
	String s = Arrays.toString(data)+" : "+numItems;
	return s;
    }
	
    public void add(int pos, String d) {
	if (isFull()){
	    String[] newdata = new String[data.length + 1];
	    for (int i = 0; (i < numItems); i++){
		if (i<pos){
		    newdata[i] = data[i];
		}
		else{
		    newdata[i+1]=data[i];
		}
	    }
	    data = newdata;
	}
	else {
	    for (int i = numItems-1;(i >= pos); i --){
	        data[i+1]=data[i];
	    }
	}
	data[pos]=d;
	numItems = numItems + 1;
    }

    public void remove(int pos) {
	for (int i = pos; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[numItems - 1] = null;
        numItems = numItems - 1;
    }


    public int size() {
	return numItems;
    }
    public String get(int pos) {
        return data[pos];
    }
    public void set(int pos, String d) {
	if (data[pos]==null){
	    numItems = numItems+1;
	}
	data[pos]=d;
	
    }

    public int find (String n){
	int index = 0;
	for (index = 0; index < data.length; index ++){
	    if (data[index].equals(n)){
		return index;
	    }
	}
	return -1;
    }

    public void remove2 (String n){
	int a =find (n);
	if (a>0){
	    remove (a);
	}
    }
}
