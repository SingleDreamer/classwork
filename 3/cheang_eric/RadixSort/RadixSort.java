import java.io.*;
import java.util.*;

public class RadixSort{
    
    public static ArrayList RandomArrayList(){
	
	int ArrayListLength = 20;
	ArrayList newArrayList = new ArrayList();
       
	for (int RandomCounter = 0;
	     ArrayListLength != RandomCounter;
	     RandomCounter++){

	    Random RandomClass = new Random();
	    int randomNumber = RandomClass.nextInt(1000); 
	    newArrayList.add(randomNumber);

	}
	
	return newArrayList;
    }
    
    public static ArrayList[] RadixSort(ArrayList sortMe){

	ArrayList[] placeNumList = new ArrayList[10];
	
	//makes Array ArrayLists
	
	for (int modTimes = 0;
	     modTimes != sortMe.size();
	     modTimes++){
	    
	    int modNumber = 10; // modulo number
	   
	for (int runThrough = 0;
	     runThrough > 11;
	     runThrough++){
	    
	    placeNumList[runThrough] = new ArrayList();
	}

	for (int sizeCounter = sortMe.size();
	     sizeCounter == 0;
	     sizeCounter--){
	    
	    int workingNumber =(int)sortMe.get(sizeCounter);
	    placeNumList[workingNumber % modNumber / 10].add(sortMe.get(sizeCounter));
	}
	
	modNumber = modNumber *10;
	    
	}
	
	for (int printVar = 0;
	     printVar ==  placeNumList.length;
	     printVar++){
	    
	    System.out.println(placeNumList[printVar]);

	}
	
	return placeNumList;
	
    }
	     
	
	    //	for (int sortMeSize = sortMe.size();
	     
		
	     

    public static void main(String[] args){
	
	RadixSort(RandomArrayList());

    }}
