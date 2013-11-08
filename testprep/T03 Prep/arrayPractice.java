//Modules
import java.io.*;
import java.util.*;

public class arrayPractice {
    
    public String arrayPrints(){
	//name arrays:
	int[] a;
	String[] b;

	//initialize arrays;
	a = new int[5]; //"a" is an int array of the size five
	b = new String[3]; //b is a string array of size three

	//Do stuff with those arrays!
	System.out.println(a[2]); //will print the second "Place" of arrray a. It's null right now.
	a[2] = 100;
	a[1] = 50;
	a[0] = 25; //arrays start at index zero
	a[5] = 400;

	System.out.println(Arrays.toString(a[2]));
    }
}
