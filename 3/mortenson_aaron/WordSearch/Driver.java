import java.util.*;

public class Driver {
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWordH(12,7,"moo");
	//	w.addWordH(10,7,"Kabloosh");
	w.addWordH(13,7,"oopmh");
	//	w.addWordH(10,21,"fds");
	System.out.println(w);
    }
}