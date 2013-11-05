import java.util.*;
import java.io.*;
import java.math.*;

public class Ogre extends Character{
    protected int addpoints;
    Random r = new Random(); 
    private int a;
    /*making a method to do the repeition of changing the availbility of points added easier */

    public int newpoints(int a){
	r.nextInt(a);
} 
    public void setAttributes(){
	addpoints= 9;       
	maxhealth=20;
	addpoints=addpoints-newpoints(addpoints);
	dexterity=6+newpoints(addpoints);
	addpoints=addpoints-newpoints(addpoints);
	strength=14+newpoints(addpoints);
	health=strength;
	addpoints=addpoints-newpoints(addpoints);
	intelligence=4+newpoints(addpoints);
	addpoints=addpoints-newpoints(addpoints);
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





