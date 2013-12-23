import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args){
	WordSearch w=new WordSearch();
	w.addWordV(19,8,"emily");
	w.addWordV(13,6,"ames");
	w.addWordV(12,6,"games");

	System.out.println(w.toString());
    }
}