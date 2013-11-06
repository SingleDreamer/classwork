import java.util.*;
import java.io.*;

public class Goblin extends Character {
  


    public Goblin(String nameGob){
	//this is a constructor that sets up stats for gargoyle, a NPC! (randomly, of course)
	Random r = new Random();
	int strengthAdd = r.nextInt(3);
	int dexAdd = 4 - strengthAdd;
	strength = 4 + strengthAdd;
	dexterity = 4 + dexAdd;
	maxhealth = strength;
	health = maxhealth;
	experience = 0;
	name = nameGob;
    }

	   
}
