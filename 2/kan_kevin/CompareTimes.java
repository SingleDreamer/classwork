import java.io.*;
import java.util.*;

public class CompareTimes{
    public static void main(String args[]){
	ArrayList<String> a = new ArrayList<String>();

	long time1 = System.currentTimeMillis();
	for (int i = 0; i < 1000000; i++){
	    a.add("apples");
	}
	System.out.println(System.currentTimeMillis() - time1);
	//	a.add(0, "x");

	//	a.remove(0);
	//	a.remove(a.size() -1);

    }
}
	