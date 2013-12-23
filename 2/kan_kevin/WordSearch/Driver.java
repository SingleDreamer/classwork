import java.util.*;

public class Driver {
    public static void main(String[] args) {
	WordSearch w = new WordSearch();
	w.addWordH(3,4, "Hello");
	w.addWordV(3,4, "Hello");
	w.addWordH(4,3, "Beef");
	System.out.println(w);
    }
}
