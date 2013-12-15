import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args){
	
	WordSearch w = new WordSearch();
	w.fillWithWords();
	w.fillSpaces();
	System.out.println(w);

    }
}
