import java.util.*;
import java.io.*;

public class Diagonal {
    public String diag(int n) {
	String r = "";
	for (int i=0; i<=n; i++) {
	    for (int j=0; j<=i; j++) {
		r = r + " ";
	    }
	    r = r + "*\n";
	}
	return r;
    }

    public String diagword(String s) {
	String r ="";
	int length = s.length()-1;
	for (int i=0; i<=length; i++) {
	    for (int j=0; j<=i; j++) {
		r = r+" ";
	    }
	    r = r + s.substring(i, i+1) + "\n";
	}
	return r;
    }

    public String fence(int height, int width) {
	if (height < 2 || width < 2)
	    return "error height and width must be greater than 2.";
	String r = "";
	for (int i=1;i<=height;i++){
	    if (i==1 || i==height) {
		for (int i=0;i<=width;i++) {
		    /////first and last line
		}
	    }
	}
    }

    public static void main(String[] args) {
	Diagonal d = new Diagonal();
	System.out.println(d.diag(5));
	System.out.println(d.diagword("Hello"));
    }
}   
	    
	