import java.io.*;
import java.util.*;

public class Moran extends Character{
    public Moran (Strinf name, int strClass, int dexClass, int intClass){
	super(name, strClass, dexClass, intClass);

    }

    public String toString(){
	return super.toString() + " the Terrifying";
    }

}
