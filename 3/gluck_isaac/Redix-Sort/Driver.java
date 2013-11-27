import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args){
	 Redix toSort = new Redix();
	 toSort.generate();
	 System.out.println();
	 System.out.println("Before: " + toSort);
	 toSort.redixSort();
	 System.out.println();
	 System.out.println("After: " + toSort);
    }
}