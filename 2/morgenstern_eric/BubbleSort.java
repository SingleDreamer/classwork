import java.io.*;
import java.util.*;

public class BubbleSort{
    public String sort(int[] a){
	int temp=0;
	int numSorts=0;
	int sortsPerFor=0;
	int numIfs=0;
	for(int j=0;j<a.length-1;j++){
	    for(int i=0;i<a.length-2;i++){
		if(a[i]<a[i+1]){
		    numIfs=numIfs+1;
		    numSorts=numSorts+1;
		    sortsPerFor=sortsPerFor+1;
		    temp=a[i];
		    a[i]=a[i+1];
		    a[i+1]=temp;
		}
	    }
	    if(sortsPerFor==0)
		return Arrays.toString(a);
	    sortsPerFor=0;
	}
	return Arrays.toString(a);
    }
    public static void main(String[] args){
	BubbleSort b = new BubbleSort();
	System.out.println(b.sort({1,3,5,4,7}));
    }
}