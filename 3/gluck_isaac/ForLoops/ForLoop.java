import java.util.*;
import java.io.*;

public class ForLoop {

    public int isPrime(int n) {
	int test = n-1;
	for (n=n;test > 1;test--) {
	    if (n%test==0)
		return false;
	}
	return true;
    }

}