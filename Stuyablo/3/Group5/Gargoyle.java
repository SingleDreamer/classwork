import java.util.*;
import java.io.*;

public class Goblin extends Character {
  


    public Goblin(){
	//this is a constructor that sets up stats for gargoyle, a NPC! (randomly, of course)
	Random r = new Random();
	int strengthAdd = r.nextInt(3);
	int dexAdd = 4 - strengthAdd;
	int strength = 4 + strengthAdd;
	int dexterity = 4 + dexAdd;
    }

    public boolean attack(){
	Random rand = new Random();
	int dexRoll = rand.nextInt(18);
	if (dexterity < = dexRoll){
	    System.out.println("Goblin"+ 





}
