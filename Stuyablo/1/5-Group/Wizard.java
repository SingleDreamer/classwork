import java.util.*;
import java.io.*;

public class Wizard extends playerChracter {
    private Random r = new Random();


    public void basicAttack (Character c){
	int x = 3 + r.nextint(6) + r.nextint(6) + r.nextint(6);
	if (x < dex) {
	    c.subhealth(1);
	}

}
