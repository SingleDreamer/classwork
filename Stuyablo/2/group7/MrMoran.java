import java.io.*;
import java.util.*;

public class MrMoran extends Character {
    public MrMoran(String name) {
	this.name = name;
	Random r = new Random();
	int str, dex, intel;
	str = r.nextInt(5);
	dex = r.nextInt(5-str);
	intel = 10 - str - dex;
	strength = 10 + str;
	dexterity = 6 + dex;
	intelligence = 4 + intel;
	maxhealth = strength*10;
	health = maxhealth;
	
    }
}