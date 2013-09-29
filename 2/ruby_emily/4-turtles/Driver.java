import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String args[]){
	Turtle t,t2;
	t=new Turtle();
	System.out.println(t.getName());
	t2=new Turtle("Emily");
	System.out.println(t2.getName());
       	System.out.println(t.getSpeed());
	System.out.println(t.getAge());
	
    }
}

