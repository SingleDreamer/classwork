import java.io.*;
import java.util.*;

public class Character {
    protected String Name;
    protected int Health,maxhealth;
    protected int Mana;
    protected int Strength;
    protected int Intelligence;
    protected int Dexterity;
    protected int Level = 1;
    protected int experience = 0,gold;
    protected double x,y;
    private Scanner sc1 = new Scanner(System.in);

    public Character () {
        System.out.println("Character name is:");
        Name = sc1.nextLine();
        Health = 16;
        Strength = 8;
        Mana = 8;
        Intelligence = 8;
        Dexterity = 8;
        Level = 1;
        experience = 0;
        maxhealth = 50;
        gold = 0;
    }

    public String getStatus() {
        String attrib1=String.format("Str: %d Dex: %d Int: %d",
                                     Strength,Dexterity, Intelligence);
        String attrib2=String.format("Exp: %d Health: %d of %d",
                                     experience,Health,maxhealth);
        String locale = String.format("x: %5.2f y: %5.2f",x,y);
        String whole=String.format("%s\n%s\n%s\n%s\n",
                                   Name,attrib1,attrib2,locale);
        return whole;
    }

    public String toString() {
        return Name;
    }

    public int getHealth() {
        return Health;
    }

    public boolean flee () {
        Random r = new Random();
        int Dice = r.nextInt(36);
        if (Dice < this.Dexterity) {
            System.out.println("You escaped!");
            return true;
        } else {
            System.out.println("You must fight!");
            return false;
        }
    }

    public int encounter (Character other) {
<<<<<<< HEAD
	if (other.flee() == true){
	    other.experience();
	    return 0;}
	if (this.flee() == true){
	    this.experience();
	    return 1;
	} else {
	    Random r = new Random();
	    int Dice = r.nextInt(18);
	    if (Dice <= this.Dexterity) {
		this.attack(other);
		System.out.println("You attacked " + other.toString() + "!");
		this.experience();
	        if (other.getHealth() > 0) {
		    other.attack(this);
		}
	    } else {
		System.out.println("You missed!");
	    }
	}
	if (this.getHealth() <= 0) return 2;
	else if (other.getHealth() <= 0) return 3;
	else if (this.getHealth() <= 0 && other.Health <= 0) return 4;
	else return 5;
=======
        if (other.flee() == true){
            other.experience();
            return 0;}
        if (this.flee() == true){
            this.experience();
            return 1;
        } else {
            Random r = new Random();
            int Dice = r.nextInt(18);
            if (Dice <= this.Dexterity) {
                this.attack(other);
                System.out.println("You attacked" + other.toString() + "!");
                this.experience();
                if (other.getHealth() > 0) {
                    other.attack(this);
                }
            } else {
                System.out.println("You missed!");
            }
        }
        if (this.getHealth() <= 0) return 2;
        else if (other.getHealth() <= 0) return 3;
        else if (this.getHealth() <= 0 && other.Health <= 0) return 4;
        else return 5;
>>>>>>> f85b12f9d35f54e8e4159988614ab402c70eb41e
    }

      public void attack (Character other) {
        int hit = 1;
        //this hit should take into account weapon choice
        boolean damage = true;
        Random r = new Random();
        int Dice = r.nextInt(18);
        if (Dice <= this.Dexterity) {
            damage = true;
            System.out.println("It's a hit for " + this.toString() + " !");
        } else {
            damage = false;
            System.out.println(this.toString() + " Missed!");
        }
        if (damage==true) {
            other.Health = other.Health - hit;
        }
      }

    public void experience () {
        if (Level == 10) {
            experience = 0;
        } else {
            experience = experience + 5;
            if (experience == 100) {
                Level = Level + 1;
                Health = Health + 1;
                Mana = Mana + 1;
                Dexterity = Dexterity + 1;
                Intelligence = Intelligence + 1;
                Strength = Strength + 1;
                experience = 0;
            }
        }
    }
}
