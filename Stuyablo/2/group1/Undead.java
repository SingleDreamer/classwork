import java.io.*;
import java.util.*;

public class Undead extends Character{
    Random r = new Random();

    public Undead(){
        maxHealth = 6 + r.nextInt(4);
        name = "The Lich King";
        health = maxHealth
        strength = health;
        dexterity = 8 - r.nextInt(4);
	intelligence = 8 + r.nextInt(4);
    }
}
