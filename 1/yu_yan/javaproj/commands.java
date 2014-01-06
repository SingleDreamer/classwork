import java.io.*;
import java.util.*;

public class commands{
    /*
      open (the) blank (probably door)
      use (the) blank with/on (the) blank
      eat? (the) blank
      look at (the) blank
          "at" and "the" not possible if blank is around
      take (the) blank
      go to (the) blank (probably door)
    */
    public int numWords = 0;
    public ArrayList words, verbs;
    public String verb, prepo1, noun1, prepo2, noun2;

    public commands(String s){
	Scanner sc = new Scanner(s);
	while (sc.hasNext()){
	    words.add(sc.next());
	    numWords = numWords+1;
	}

	verbs = new ArrayList();
	verbs.add("open");
	verbs.add("use");
	verbs.add("look");
	verbs.add("take");
	verbs.add("go");
    }
    
    public boolean verbCheck(String s){
	return verbs.contains(s);
    }
    
    public boolean nounCheck(String s, ArrayList i){
	return i.contains(s);
    }
    
    
    /*
    public boolean open(String n){
    }
    public boolean use(String n1, String n2){
    }
    public boolean look(String n){
    }
    public boolean pickUp(String n){
    }
    public boolean go(String n){
    }
    */
}
