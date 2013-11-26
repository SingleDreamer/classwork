import java.util.*;
import java.io.*;

public class AddRemoveTest{
        
    public static void main(String[] args){
    
	long ticker = System.currentTimeMillis();
	
	ArrayList testAList = new ArrayList();
	
	for (int NumberAdd = 0;
	     NumberAdd < 51;
	     NumberAdd++){
	    
	    testAList.add(5);

	}

	System.out.println(testAList);

	long tocker = System.currentTimeMillis();
	
	System.out.println(tocker - ticker);
	
	
	
    }}
	
	
    