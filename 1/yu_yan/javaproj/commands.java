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
    public ArrayList<String> words = new ArrayList<String>();
    public String verb, noun1, prepo2, noun2;
    public String inMouth = "";
    public ArrayList<String> thingToOpen = new ArrayList<String>();

    public ArrayList<String> verbs = new ArrayList<String>();
    public ArrayList<String[]> itemPairs = new ArrayList<String[]>();

    public commands(String s){
	verbs.add("open");
	verbs.add("use");
	verbs.add("look");
	verbs.add("take");
	verbs.add("go");
    }
    /*
    public void sortWords(){
	Scanner sc = new Scanner(s);
	while (sc.hasNext()){
	    words.add(sc.next());
	    numWords = numWords+1;
	}
	boolean cont = true;
	while (cont){
	    cont = cont && verbCheck(words[0]);
	    verb = words[0];

	    if 
    */
   
    public boolean verbCheck(String s){
	return verbs.contains(s);
    }
    
    public boolean nounCheck(String s, ArrayList i){
	return i.contains(s);
    }
   
    public boolean itemInMouth() { 
	if (inMouth.equals("")) { 
	    return false;
	}
	else {
	    return true;
	}
    }
   
    public boolean open(String n){
	if (thingToOpen.contains(n)) { 
	    return true;
	}
	else { 
	    return false;
	}
    }
   

    public boolean use(String n1, String n2){
	for (int i=0;i<itemPairs.size();i++) { 
	    String[] itemList = itemPairs.get(i);
	    if (itemList[0].equals(n1) && itemList[1].equals(n2)) { 
		System.out.println(itemList[2]);
		return true;
	    }
	}
	return false;
    }	

    /*
    public boolean look(String n){
    }
    */

    public boolean pickUp(String item){
	if(itemInMouth()) { 
	    return false;
	}
	else {
	    inMouth = item;
	    return true;
	}
    }
    /* public boolean go(String n){
    }
    */
}
