import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
	Turtle t0,t1,t2;
	t0 = new Turtle();
	t1 = new Turtle("Cornelius");
	t2 = new Turtle("Zippy",33,75);
	System.out.println("The first test uses the constructor with no parameters,");
	System.out.println("the second test uses the constructor with two parameters,");
	System.out.println("and the third test uses the constructor with three parameters. \n");
	System.out.println(t0.returnName());
	System.out.print("Age: ");
	System.out.println(t0.returnAge());
	System.out.print("Speed: ");
	System.out.println(t0.returnSpeed());
	System.out.println();

	System.out.println(t1.returnName());
	System.out.print("Age: ");
	System.out.println(t1.returnAge());
	System.out.print("Speed: ");
	System.out.println(t1.returnSpeed());
	System.out.println();

	System.out.println(t2.returnName());
	System.out.print("Age: ");
	System.out.println(t2.returnAge());
	System.out.print("Speed: ");
	System.out.println(t2.returnSpeed());
	System.out.println();

	System.out.println("The following test uses the getOlder() method and the speedUp() method (increasing by 5 units) on Shelly. \n");
	t0.getOlder();
	t0.speedUp(5);
	System.out.print("Age: ");
	System.out.println(t0.returnAge());
	System.out.print("Speed: ");
	System.out.println(t0.returnSpeed());
	System.out.println();

	System.out.println("Now, this test uses the slowDown() method (decreasing by 5 units) on Shelly, to get her speed back to its original value. \n");
	t0.slowDown(5);
	System.out.print("Speed: ");
	System.out.println(t0.returnSpeed());
    }
}
