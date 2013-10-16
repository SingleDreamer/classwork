import java.io.*;
import java.util.*;

public class Driver {
		
	public static void main (String[] args) {
	
	/*
	int i = 9;
	for (int i = 0 ; i < 10 ; i++) {
		System.out.println(i);
	}
		System.out.println(i);
		
	}
	*/ 
		
	
	/* 
	int i = 100;
	for (int i = 0 ; i < 10 ; i++) {
		System.out.println(i);
	}
		System.out.println(i);
		
	}
	*/
	
	//printing a string backwards
	
	//given a string x = "hello" ; returns "olleh" then prints
	
	String x = "hello";
	
	//for each character, append last charac to the end of the new string
	// string = string + nextChar
	
	for (x = "hello" ;  x.length() == 0 ; 
		 x = x.substring(x.length() - 1)) { 
		String f = ""; 
		String p = x.substring( x.length() - 1 , x.length());
		f = f + p;
		System.out.println("String = " + f);
	}
	
	
	
}		
}



