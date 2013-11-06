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

<<<<<<< HEAD
=======
    public Ogre(){
	name="Ogre";
	double r1 = new random();
	double r2 = new random();
	double r3 = new random();
	setStr=(r1*10)%1;
        setDex=(r1*10)%1;
        setInt=(r1*10)%1;
>>>>>>> f14821dd0248bf3273ac8c78d046584da099d260
    }


}
