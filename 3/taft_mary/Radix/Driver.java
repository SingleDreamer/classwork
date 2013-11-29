import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
	Radix r = new Radix(100,4);
	System.out.println(r+"\n\n");
	r.sort();
	System.out.println(r);
    }

}