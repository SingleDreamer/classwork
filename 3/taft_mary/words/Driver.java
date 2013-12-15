import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args){
	
	NewWordSearch w = new NewWordSearch();
	w.fillWithWords();
	w.fillSpaces();
	System.out.println(w);

    }
}
