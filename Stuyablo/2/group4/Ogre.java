import java.io.*;
import java.util.*;

public class Ogre extends Character {
    Random r = new Random();
    public Ogre() {
	name = "Ogre";
        // Strength, dexterity, and health will be a random number between 4 and 12
        strength = r.nextInt(8) + 4;
	maxStr = 16;
	dexterity = r.nextInt(8) + 4;
	maxDex = 16;
	health = r.nextInt(8) + 4;
	maxHealth = 16;

    }


}
