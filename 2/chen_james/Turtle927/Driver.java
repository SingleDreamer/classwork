import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String args[]) {
	Turtle t = new Turtle();
	Turtle t2 = new Turtle("Mario");
	Turtle t3 = new Turtle("Wario", 1, 50);

	System.out.println(t3.getName());
	System.out.println(t3.getSpeed());
	System.out.println(t3.getAge());
    }

}
