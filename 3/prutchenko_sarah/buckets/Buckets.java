import java.util.*;

public class Buckets{
    
    public class Buckets(){
	ArrayList[] buckets= new ArrayList[10];
	for (int i=0; i<10; i++){
	    buckets[i]= (int)Math.round(Math.random*9999);
	}
    }
	public void sort(){
	    for(int n=0; n<4; n++){
		ArrayList[] temp= new ArrayList[10];
		for (int j=0; j<10; j++){
		    temp.add((buckets[j]/math.pow(10. n)), buckets[j]);
		}
		buckets=temp;
	    }
	}
}