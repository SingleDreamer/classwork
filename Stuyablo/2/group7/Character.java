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
    
    public Character(String name, int baseStr, int baseDex, int baseInt, int addStr, int addDex, int addInt) {
            this.name = name;
            this.dexterity = baseDex + addDex;
            this.strength = baseStr + addStr;
            this.intelligence = baseInt + addInt;
            this.maxhealth = this.strength;
            this.health = this.maxhealth;
    }
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
    public void distributeStats() {
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ", choose your stats:\n\nStrength affects health and the damage done by melee characters.\nDexterity affects accuracy.\nIntelligence affects the chance of fleeing and the damage done by magic users.\n\nWarriors start off with 10 strength, 6 dexterity, and 8 intelligence.\nWizards start off with 6 strength, 8 dexterity, and 10 intelligence.\nThieves start off with 8 strength, 10 dexterity, and 6 intelligence.\n\nYou have 8 more points to allocate.");
        System.out.println("\nHow many points do you want to add to strength?");
        System.out.print(">");
        int str = sc.nextInt();
        System.out.println("\nHow many points do you want to add to dexterity?");
        System.out.print(">");
        int dex = sc.nextInt();
        System.out.println("\nHow many points do you want to add to intelligence?");
        System.out.print(">");
        int intel = sc.nextInt();
        this.name = name;
        strength = 10 + str;
        dexterity = 6 + dex;
        intelligence = 8 + intel;
        System.out.println(String.format("\nStr: %d Dex: %d Int: %d\n\n",
                                    strength, dexterity, intelligence));
        if (dexterity + strength + intelligence > 32) {
            System.out.println("You have added too many points, please try again.\n\n");
            distributeStats();
        }
    }
}