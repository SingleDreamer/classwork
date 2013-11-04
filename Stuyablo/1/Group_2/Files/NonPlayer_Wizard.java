import java.io.*;
import java.util.*;

public class NonPlayer_Wizard extends Wizard{
    private int mana, health;
        
        public NonPlayer_Wizard(){
                super("Enemy Wizard");
                health = 0;
    		while (health <75){
		    health = (int)Math.random() * 100;}
    		this.mana = (int)Math.sqrt(health)*9;

        }
}
