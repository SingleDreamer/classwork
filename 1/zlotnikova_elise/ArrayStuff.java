import java.io.*;
import java.util.*;

public class ArrayStuff {
    public int[] Revfill(int n) { 
	int i;
	int[] array = new int[n];
	for (i=n;i>0;i--) {
	    array[n-i]= i;
	}
	return array;
    }
}