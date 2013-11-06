import java.util.*;
import java.io.*;
import java.math.*;

public class Ogre extends Character{
    protected int addpoints;
    Random r = new Random(); 
    /*making a method to do the repeition of changing the availbility of points added easier */

    
    public void setAttributes(){
	addpoints= 9;       
	maxhealth=20;
	addpoints=addpoints-(r.nextInt(addpoints));
	dexterity=6+(r.nextInt(addpoints));
	addpoints=addpoints-(r.nextInt(addpoints));
	strength=14+(r.nextInt(addpoints));
	health=strength;
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
	   
	//expiernece 
	//gold
	//distance, very confused on this
	name="Ogre";
	setCharClass("NPC");

}


}





