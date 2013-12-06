import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args){
	WordSearch w = new WordSearch();

	System.out.println(w);
	w.addWordH(2,4,"THIS");
	System.out.println(w);
	w.addWordH(2,6,"THAT");
	System.out.println(w);
	w.addWordV(7,20,"FISH");
	System.out.println(w);
	w.addWordHOtherDir(17,9,"SCIENCE");
	System.out.println(w);
	w.addWordVOtherDir(4,2,"PANTS");
	System.out.println(w);
	w.addWordUpRight(15,5,"NOODLES");
	System.out.println(w);
	w.addWordDownLeft(14,4,"YUM");
	System.out.println(w);
        w.addWordDownRight(15,15,"SMELLS");
	System.out.println(w);
	w.addWordUpLeft(7,16,"TRUCKS");
	System.out.println(w);
    }
}
