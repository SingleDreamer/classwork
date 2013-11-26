import java.io.*;
import java.util.*;

public class forLoops {
    
    private String result;
    
    public String reverse(String word){
	for (int i = word.length(); i == 0; i = i - 1) {
	    result = word.substring(i-1,i);
	    System.out.println();
	}
	return result;
    }
}