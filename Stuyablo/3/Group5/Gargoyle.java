import java.util.*;
import java.io.*;

public class Gargoyle extends Character {

    public Gargoyle(){
	Random r = new Random();
	int strengthAdd = r.nextInt(7);
	int dexAdd = 8 - strengthAdd;
	int strength = 8 + strengthAdd;
	int dexAdd = 8 + dexAdd;
    }

}
