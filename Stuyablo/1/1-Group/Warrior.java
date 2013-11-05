import java.io.*;
import java.util.*;

public class Warrior extends Character{
 
    public Warrior(String name){
	super(name);
    }

    public int attack (Character other){
	//will add complicated x and y coor stuff later
	/*attacks include hitting with:
	  hammer(close range)
	  sword(med range)
	  arrow(far range)*/

	System.out.println("Choose your attack:");
	System.out.println("Press 1 to use your hammer");
	System.out.println("Press 2 to use your sword");
	System.out.println("Press 3 to use your bow and arrow");

	Scanner sc=new Scanner(System.in);
	int answer=sc.nextInt();

	//Hammer time
	if (answer == 1){    
	    //if x,y coors are <2 or something (something small)
	    while (this.health > 0 || other.health > 0){
		if (dexterity <= roll()){
		    other.takedamage(this.strength);
		    say (other + " has lost " + strength + " health points and has "+other.getHealth()+" health points left");
		    try {
			Thread.sleep(2000);
		    }
		    catch(Exception e){
                
		    } 
            }
            if (other.dexterity <= other.roll()){
                this.takedamage(other.strength);
                say(name + " has lost " + other.strength + " health points and has "+this.getHealth()+" health points left");
                try {
                    Thread.sleep(2000);
                }
                catch(Exception e){
                
                } 
            }
            if (this.health <= 5){
                if (this.flee(other)){
                    return 0;
                }
            }
            if (other.health <= 5){
                if (other.flee(this)){
                    return 1;
                }
            }
                
	    }
	    if (this.health <= 0){
		this.die();
		return 3;
	    }
	    else{
		other.die();
		return 2;
	    }
	}
	

	//Swords at the ready!
	if (answer == 2){

	}

	//*pew pew*
	if (answer == 3){

	}

	return 0;

    }

}









