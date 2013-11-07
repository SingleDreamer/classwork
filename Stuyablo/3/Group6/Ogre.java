import java.util.*;
import java.io.*;
import java.math.*;

public class Ogre extends Character{
    protected int addpoints;
    Random r = new Random(); 
    /*making a method to do the repeition of changing the availbility of points added easier */

    
    public void setAttributes(){
	experience=50;
	gold=100;
	addpoints= 9;       
	addpoints=addpoints-(r.nextInt(addpoints));
	dexterity=6+(r.nextInt(addpoints));
	addpoints=addpoints-(r.nextInt(addpoints));
	strength=14+(r.nextInt(addpoints));
	health=strength;
	maxhealth=strength;
	addpoints=addpoints-(r.nextInt(addpoints));
	intelligence=4+(r.nextInt(addpoints));
	addpoints=addpoints-(r.nextInt(addpoints));
	//need to figure out what to do if there are points left over, should i
	//it just be given to the remaining attribute?; possibly a random thing
	//for distributing those last points?
	 if (addpoints !=0){
	   x=r.nextInt(3);
	   if (x==0){
	       dexterity=dexterity+addpoints;}
	   else if (x==1){
	       strength=strength+ addpoints;
	   health=strength;}
	   else{
	       intelligence=intelligence+addpoints;} }
          
      	name="Ogre";
	setCharClass("NPC");

}

    public void die (Character other){
	other.gold=other.gold+this.gold;
	other.experience=other.experience+this.experience;
	String winmessage= "You have defeated the "+ name+ " and gained "+this.experience+" and "+this.gold+" gold!";
	System.out.println(winmessage);

    }
    public void attack(Character other) {
	System.out.println("The " + name+ " tried attacking you!");
	if (roll() == false){
	    System.out.println("The " + name+" tried to attack you and failed!!!");
	    System.out.println();
    }
	else {
	    System.out.println("The "+ name + " has hit you with a tree");
	    int damage= (int)(strength/4 + (Math.random() * 3))-1;
	    other.health=other.health-damage;
	}

    }}





