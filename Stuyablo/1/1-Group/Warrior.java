import java.io.*;
import java.util.*;

public class Warrior extends Character{

    String name=super.getname();

    public class Warrior(){
	charClass="Warrior";
    }


    public void attack (Character other){
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

	}

	//Swords at the ready!
	if (answer == 2){

	}

	//*pew pew*
	if (answer == 3){

	}

    }

}
