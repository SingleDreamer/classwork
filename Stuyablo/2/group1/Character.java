import java.util.*;

public class Character {
   
	protected String name;
	protected int health,maxHealth;

	protected int dex,str,intel;
 	protected int armor;   

	public Character() {
		name="Barry";
		Random r = new Random();
		
		dex = r.nextInt(10) + 5;
		str = r.nextInt(10) + 5;
		intel = r.nextInt(10) + 5;
		
		armor = 1;

		maxHealth = 10;
		health = 10;
	}

	public Character(String n, int d, int s, int i, int a, int h)
	{
		name = n;
		dex = d;
		str = s;
		intel = i;
		armor = a;
		maxHealth = h;
		health = h;
	}

	    
	    
	public String toString() {
		return name;
	}

	public void attack(Character c) {
		System.out.println(name + " hits " + c.getName());
		c.getAttacked(str, 0.7 + ((double) dex / 100));
	}
	
	public void getAttacked(int dam, double prob) {
		dam -= armor;
		if(dam < 0) 
			dam = 0;

		Random r = new Random();
		if(r.nextDouble() < prob) {
			health -= dam;
			System.out.println("Hits for" + dam);
		} else {
			System.out.println("Misses!");
		}
		
	
	}

	public String getName(){
		return name;
	}




}
