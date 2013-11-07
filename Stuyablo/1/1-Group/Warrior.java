import java.io.*;
import java.util.*;

public class Warrior extends Character{
    
    public Warrior(String name){
        super(name);
		setAttributes();
    }
<<<<<<< HEAD

   
    
    public void attack (Character other){
	int[] dice1={1,2,3,4,5,6};
	int[] dice2={1,2,3,4,5,6};
	int[] dice3={1,2,3,4,5,6};
	double xchange,ychange;
	xchange = this.x-other.x;
	ychange = this.y-other.y;
	double d = Math.sqrt(xchange*xchange + ychange*ychange);

	System.out.println("Choose your attack:");
	System.out.println("Press 1 to use your hammer");
	System.out.println("Press 2 to use your sword");
	System.out.println("Press 3 to use your bow and arrow");

	Scanner sc=new Scanner(System.in);
	int answer=sc.nextInt();

	//Hammer time
	if (answer == 1) {
	    int a=(dice1[new Random().nextInt(dice1.length)]);
	    int b=(dice1[new Random().nextInt(dice1.length)]);
	    int c=(dice1[new Random().nextInt(dice1.length)]);
	    if ((a+b+c)<this.dexterity && d<2) { 
		System.out.println(this.name + " whacked " + other.name +" with a hammer!");
		other.health = other.health - 1;
		other.dexterity = other.dexterity - 1;
	    }
	    else {
		System.out.println(this.name + "'s attack failed!");
=======
	
	public int attack (Character other){
		System.out.println("Choose your attack:");
        System.out.println("Press 1 to use your hammer");
        System.out.println("Press 2 to use your sword");
        System.out.println("Press 3 to use your bow and arrow");

        Scanner sc=new Scanner(System.in);
        int answer=sc.nextInt();

        //Hammer time
        if (answer == 1) {
            //if x,y coors are <2 or something (something small)
        	System.out.println(this.name + " whacked " + other.name +" with a hammer!");
			return super.attack(other);
            }
		else if (answer == 2){
                System.out.println(this.name + " slashed " + other.name + " with a sword!");
                return super.attack(other);
            }
		else if (answer == 3){
			System.out.println(this.name + " shot " + other.name + " with a bow and arrow!");
			return super.attack(other);
>>>>>>> b101d9bbd9e687c9246b8e09a2ed185f4324263d
	    }
		else {
	    	System.out.println(this.name + "you, made a typo!");
	    	return this.attack(other); 
		}
	}
<<<<<<< HEAD
     
	//Swords at the ready!
	else if (answer == 2){
	    int a=(dice1[new Random().nextInt(dice1.length)]);
	    int b=(dice1[new Random().nextInt(dice1.length)]);
	    int c=(dice1[new Random().nextInt(dice1.length)]);
	    if ((a+b+c)<this.dexterity) {
		if (d<2) {
		   System.out.println(other.name + " has been stabbed in the heart");
		   other.health = other.health - 3;
		}
		else if (d<5) { 
		    System.out.println(other.name + " has been stabbed in the arm");
		    other.health = other.health - 2;
		}
		else {
		    System.out.println(other.name + " has been slashed. He's angry and his adrenaline is pumping!");
		    other.health = other.health - 2;
		    other.strength = other.strength + 1;
		}
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
		if (d<3) { 
		    System.out.println(this.name + " shot " + other.name + " with a bow and arrow!");
		    this.dexterity = this.dexterity + 1;
		    other.health = other.health - 1;
		}
		else {
		    System.out.println(this.name + " missed!");
		    this.dexterity = this.dexterity - 1;
		}     
	    }
	    else { 
		System.out.println(this.name + "'s attack failed!");
	    }
	}
	else {
	    System.out.println(this.name + "you, made a typo!");
	}
    }
}





=======
}
>>>>>>> b101d9bbd9e687c9246b8e09a2ed185f4324263d
