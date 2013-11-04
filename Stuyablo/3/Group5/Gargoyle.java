import java.util.*;
import java.io.*;

public class Gargoyle extends Character {

    public Gargoyle(){
	//this is a constructor that sets up stats for gargoyle, a NPC! (randomly, of course)
	Random r = new Random();
	int strengthAdd = r.nextInt(7);
	int dexAdd = 8 - strengthAdd;
	int strength = 8 + strengthAdd;
	int dexterity = 8 + dexAdd;
    }

}
