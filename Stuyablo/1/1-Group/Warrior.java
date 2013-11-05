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
	    System.out.println(this.name + " whacked " + other.name +" with a hammer!");
	    return super.attack(other);
	}
	

	//Swords at the ready!
	else if (answer == 2){
	    System.out.println(this.name + " slashed " + other.name + " with a sword!");
	    return super.attack(other);
	}

	//*pew pew*
	else if (answer == 3){
	    System.out.println(this.name + " shot " + other.name + " with a bow and arrow!");
	    return super.attack(other);
	}

	    else 
		return super.attack(other);

    }
}









