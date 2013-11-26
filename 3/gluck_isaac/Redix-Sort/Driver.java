import java.util.*;
import java.io.*;

public class Driver {
	public static void main(String[] args){
		Redix r = new Redix();
		r.generate();
		System.out.println("before: "+r);
		r.sort();
		System.out.println("after: "+r);
	}