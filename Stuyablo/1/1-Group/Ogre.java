import java.io.*;
import java.util.*;

public class Ogre extends Character{
    
    public Ogre(String name){
        super(name);
    }

   
    
    public int attack (Character other){
        int[] dice1={1,2,3,4,5,6};
        int[] dice2={1,2,3,4,5,6};
        int[] dice3={1,2,3,4,5,6};
       	xchange = this.x-other.x;
	ychange = this.y-other.y;
	double d = Math.sqrt(xchange*xchange + ychange*ychange);

        System.out.println("Choose your attack:");
        System.out.println("Press 1 to use your club");
        System.out.println("Press 2 to use your cleaver");
        System.out.println("Press 3 to use your blaze");

        Scanner sc=new Scanner(System.in);
        int answer=sc.nextInt();

        //Hammer time
        if (answer == 1) {
            int a=(dice1[new Random().nextInt(dice1.length)]);
            int b=(dice1[new Random().nextInt(dice1.length)]);
            int c=(dice1[new Random().nextInt(dice1.length)]);
            if ((a+b+c)<this.dexterity) {
            //if x,y coors are <2 or something (something small)
                System.out.println(this.name + " smashed " + other.name +" with a club!");
		return super.attack(other);
            }
            else {
                System.out.println(this.name + "'s attack failed!");
		return super.attack(other);
            }
        }
     
        //Swords at the ready!
        else if (answer == 2){
            int a=(dice1[new Random().nextInt(dice1.length)]);
            int b=(dice1[new Random().nextInt(dice1.length)]);
            int c=(dice1[new Random().nextInt(dice1.length)]);
            if ((a+b+c)<this.dexterity) {
                System.out.println(this.name + " swung at " + other.name + " with a cleaver!");
                return super.attack(other);
            }
            else {
               System.out.println(this.name + "'s attack failed!");
            }
        }


	//*pew pew*
	else if (answer == 3){
	    int a=(dice1[new Random().nextInt(dice1.length)]);
	    int b=(dice1[new Random().nextInt(dice1.length)]);
	    int c=(dice1[new Random().nextInt(dice1.length)]);
	    if ((a+b+c)<this.dexterity) {
		System.out.println(this.name + " set fire to " + other.name + " with a blaze!");
		return super.attack(other);
	    }
	    else {
		System.out.println(this.name + "'s attack failed!");
	    }
	}
	else {
	    System.out.println(this.name + "you, made a typo!");
	    return this.attack(other); 
	}
	return 5;

        
    }
}
