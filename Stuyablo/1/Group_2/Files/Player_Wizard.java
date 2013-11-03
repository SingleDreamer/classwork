import java.io.*;
import java.util.*;

public class Player_Wizard extends Wizard{

	private int mana, health;

	public Player_Wizard(String name){
		super(name);
		health = 100;
		mana = 100;		
	}
}
