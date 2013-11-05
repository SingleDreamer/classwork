import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected int gold;
    protected double x,y;
    protected String name;
    protected String charClass;
 
    public double getHealth() {
        return health;
    }
    public int getDex() {
        return dexterity;
    }
    public int getStr() {
        return strength;
    }
    public int getIntel() {
        return intelligence;
    }
    public int getEXP() {
        return experience;
    }
    public double getDistance(Character other) {

        // distance between two characters
        double distance;
        double differX, differY;
        differX = this.x - other.x;
        differY = this.y - other.y;
        distance = Math.sqrt( (differX*differX) + (differY*differY) );
        return distance;
    }
	public Character(String name, int baseStr, int baseDex, int baseInt, int extra) {
		Random r = new Random();
		this.name = name;
		eStr = r.nextInt(9);
		eDex = r.nextInt(9- eStr);
		eInt = 8 - eStr - eDex;
		this.dexterity = baseDex + eDex;
		this.strength = baseStr + eStr;
		this.intelligence = baseInt + eInt;
		this.maxhealth = this.strength;
		this.health = this.maxhealth;
	}
    /* THIS IS THE RANDOMIZED CONSTRUCTOR, COPY PASTE INTO THE SPECIFIC CLASS FILES AND TWEAK
    public Character(String name) {
            Random r = new Random();
            int str, dex, intel;
                this.name = name;
                str = r.nextInt(9);
                dex = r.nextInt(9 - str);
                intel = 8 - str - dex;
                dexterity = 8 + dex;
                strength = 8 + str;
                intelligence = 8 + intel;
                maxhealth = strength;
                health = maxhealth;
    }
    */
    public void attack(Character other) {
                Random r = new Random();
                //the dice rolls
                int x = r.nextInt(6) + 1, y = r.nextInt(6) + 1, z = r.nextInt(6) + 1;
                if (x+y+z <= dexterity) {
                    //needs damage calculator!
                    int dmg = damageDone(other, 1);
                    other.loseHealth(dmg);
                    System.out.println("\n" + name + " did " + dmg + " damage to " + other + "!");
                }
                else {
                    System.out.println("\n" + name + " missed!");
                }
    }
    
    public int damageDone(Character other, int multiplier){
        return this.strength * multiplier;
    }
    
    // returns true if you succesfully flee, false otherwise
    public boolean flee(Character other) {
                Random r = new Random();
                boolean flee = false;
                int x = r.nextInt(6) + 1, y = r.nextInt(6) + 1, z = r.nextInt(6) + 1;
                int chance = this.intelligence - other.intelligence;
                if (chance <= 0) {
                        //gives the character at least 1/18 chance of fleeing
                        chance = 0;
                }
                flee = x+y+z <= chance + 3;
                return flee;
    }
    
    public void loseHealth(int hp) {
            health = health - hp;
    } 
    
    /*
      this routine will decide first ask if other tries to flee. If
      so, and if it's succesful it should adjust experience and or
      gold as needed and return a 0.

      Then, it should decide if this character tries to flee. 
      If so and it's succesful, return a 1;
      
      Otherwise, call attack on both sides:
      this.attack(other);
      if (other.health>0) 
        other.attack(this);

      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead
    */

    public int encounter(Character other) {
        Scanner sc = new Scanner(System.in);
        if (other.flee(this)) {
            return 0;
        }
        else {
                System.out.println("\n" + other + " tried to flee, but failed.");
        }
        pause();
        System.out.println("\n" + this + "\n1 - Attack \n2 - Flee");
        System.out.print("Enter your choice: ");
        String option = sc.nextLine();
        pause();
        if (option.equals("2")) {
            if (this.flee(other)){
                    return 1;
                }
                else {
                        System.out.println("\n" + this + " tried to flee, but failed."); 
                }
        }
        else if (option.equals("1")){
            this.attack(other);
            pause();
            if (other.health>0) {
                        other.attack(this);
                        if (this.health<=0) {
                            return 2;
                        }        
            }
            else {
                        return 3;
            }
            return 5;
        }
        return 5;
    }
        
    //actually runs game, calls on encounter multiple times
    public void fight(Character other) {
                int options = 5, turn = 1;
                while (options == 5) {
                        pause();
                        pause();
                        System.out.println("\n~~~\nTurn: "+ turn+ "\n" + this + "'s health: " + this.getHealth());
                        System.out.println(other + "'s health: " + other.getHealth());
                    options = encounter(other);
                    turn = turn + 1;
                }
                if (options == 0) {
                    System.out.println("\n" + other + " fled!");
                }
                else if (options == 1) {
                    System.out.println("\n" + this + " fled!");
                }
                else if (options == 2) {
                    System.out.println("\n" + this + " died!");
                }
                else if (options == 3) {
                    System.out.println("\n" + other + " died!");
                }
    }
            
            
            
    public String getStatus() {
        String attrib1=String.format("Str: %d Dex: %d Int: %d",
                                     strength, dexterity, intelligence);
        String attrib2=String.format("Exp: %d Health: %d of %d",
                                     experience,health,maxhealth);
        String locale = String.format("x: %5.2f y: %5.2f",x,y);
        String whole=String.format("%s\n%s\n%s\n%s\n",
                                   name,attrib1,attrib2,locale);
        return whole;
    }
                   
    public String toString() {
        return name;
    }

    public void pause() {
            try {
            Thread.sleep(500); // pause for that many milliseconds
        } 
        catch (Exception e) {
                // do nothing here - it should never get run 
        }
    }
}
