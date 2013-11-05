import java.io.*;
import java.util.*;

public class Ogre extends Character {

    public Ogre(String name) {
	this.name = name;
	Random r = new Random();
	int str, dex, intel;
	str = r.nextInt(8);
	dex = r.nextInt(8 - str);
	intel = 7 - str - dex;
	strength = 10 + str;
	dexterity = 6 + dex;
	intelligence = 4 + intel;
	maxhealth = strength * 10;
	health = maxhealth;
    }



}
