import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String args[]) {
	Character c1 = new Character("Evil Bob");
	Player p1 = new Player();
	System.out.println(c1.getStats());
	System.out.println(p1.getStats());
    }  
}