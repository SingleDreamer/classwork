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
    
    public static ArrayList RadixSort(ArrayList sortMe){
	
	int sortMeIndex = 0;
	ArrayList[] placeNumList = new ArrayList[10];
	
	for (int runThrough = 0;
	     runThrough > 11;
	     runThrough++){
	    
	    placeNumList[runThrough] = new ArrayList();
	}
    
	for (int placenumber = 10;
	     placenumber != 10000;
	     placenumber++){
	    
	    int sortMeUnit = sortMe.get(sortMeIndex);
	    
	    
	}
	
    }
	     
	
	    //	for (int sortMeSize = sortMe.size();
	     
		
	     

    public static void main(String[] args){
	
	RadixSort(RandomArrayList());

    }}