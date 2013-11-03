import java.io.*;
import java.util.*;

public class NonPlayer_Wizard extends Wizard{
    private int mana, health;
        
        //We should make a way to determine health random between 75%and 90% so that the player has an advantage over them.
        // mana should then be based on its health but not equal to it. I thought this would be creative.

        public NonPlayer_Wizard(){
                super("Enemy Wizard");
                health = 0;
    		while (health <75){
		    health = (int)Math.random() * 100;}
    		this.mana = (int)Math.sqrt(health)*9;

        }
}
