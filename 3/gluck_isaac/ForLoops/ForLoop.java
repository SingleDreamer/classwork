import java.util.*;
import java.io.*;

public class ForLoop {

    public boolean isPrime(int n) {
	int test = n-1;
	for (test = n-1;test > 1;test--) {
	    if (n%test==0)
		return false;
	}
	return true;
    }

    public String reverse(String s) {
	int length = s.length();
	String result = "";
	for(int i = length -1; i>=0; i--)
	    result = result + s.substring(i, i+1);
	return result;
    }

    public String table(int n, int m) {
	String result = "";
	for(int i=0;i<=n;i++) {
	    result = result + i;
	    for (j=1;j<=i*n;j++)
		result = result + j;
	    
	}
	result = result + "\n";
    }
}