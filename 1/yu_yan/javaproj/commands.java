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
    public ArrayList thingUse, verbs, thingOpen, thingUsedOn, words;
    public String verb, prepo1, noun1, prepo2, noun2;
    public String inMouth = "";

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
	
	thingOpen = new ArrayList();
	thingOpen.add("box");
	thingOpen.add("door");

	thingUse = new ArrayList();
	thingUse.add("hammer");

	thingUsedOn = new ArrayList();
	thingUsedOn.add("clock");
    }
    
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
	if (thingOpen.contains(n)) { 
	    return true;
	}
	else { 
	    return false;
	}
    }
   

    public boolean use(String n1, String n2){
	if (thingUse.contains(n1) && thingUsedOn.contains(n2)) {
	    return true;
	}
	else { 
	    return false;
	}
	
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
