###TO BE MERGED WITH CHARACTER

import java.io.*;
import java.util.*;

public class Warrior extends Character {


    public Warrior(String n){
	name=n;
	strength=toChance()+100;
	dexterity=((int)((toChance()*.01)*5))+15;
	health=((int)((toChance()/100)*1000))+5000;
	maxhealth=health;
    }

}
