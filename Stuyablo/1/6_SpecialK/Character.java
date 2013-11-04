import java.io.*;
import java.util.*;

public class Character {
    protected int health, maxhealth;
    protected int dexterity, strength, intelligence;
    protected int experience;
    protected int gold;
    protected double x,y,distance;
    protected String name;
    protected String charClass;
    
    //CONSTRUCTORS WILL BE FOUND ON THE SUBCLASSES!
    
    public initChar (int maxhealth1, int dexterity1, int  strength1, int  intelligence1, int  experience1, int gold1) {
        maxhealth = maxhealth1;
        dexterity = 8+ dexterity1;
        strength = 8+ strength1;
        intelligence = 8+ intelligence1;
        experience = experience1;
        gold = gold1;
        health = maxhealth;
    } //the dex1 str1 and int1 should add up to 8 in total!
 
    public int getHealth() {
	return health;
    }
    
    public int getDexterity(){
    	return dexterity
    }


    public void attack(Character other) {
	Random r1 = new Random();
	Random r2 = new Random();
	Random r3 = new Random(); //3 die
	
    }

    public boolean flee(Character other) {
    	return (this.getDexterity()>other.getDexterity()) //you can flee if enemy has less dex than you
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

      and then return 2 if this is dead, 3 if other is dead, 4 if both dead, 5 if none dead.

    */
    public int encounter(Character other) {
    	System.out.println("Enter 1 to flee, 2 to fight")
    	Scanner sc = new Scanner(System.in);
    	int response = sc.nextInt();
    	Random x = new Random();
    	
    	if (x.nextInt(100)>50 && other.flee()){ //randomizes if enemy tries to flee
		return 0;}
	else if (response==1 && this.flee()){
		return 1;}
	else{
		this.attack(other);
		if (other.getHealth()>0){
			other.attack(this);
			if (this.getHealth()<=0){
				return 2;}
			else{
				return 5;}
		}
		else if (other.getHealth()<=0 && this.getHealth()<=0){
			return 4;
		} 
		else{
			return 3;}
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
    
}
