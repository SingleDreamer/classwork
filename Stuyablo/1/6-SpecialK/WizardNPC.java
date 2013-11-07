import java.io.*;
import java.util.*;

public class WizardNPC extends Character {
    
    public WizardNPC(){
	Random n = new Random();
	name = "Gandolf";
	charType = "Wizard";
	strength = 10 + n.nextInt(5);
	dexterity = 11+n.nextInt(5);
	defense = 6+n.nextInt(5);
	maxhealth = strength;
	charm = 0;
    }
}
