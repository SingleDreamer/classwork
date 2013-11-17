import java.util.*;
import java.io.*;

public class ArrayStuff {

    public void remove(int pos) {
	int[] temp = new int[data.length-1];
	for (int i=0;i < data.length; i++) {
	    if (i!=pos) 
		temp[i] = data[i];
	    else
		i--;
	}
	data = temp;

    }

}