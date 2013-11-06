import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	Character n = new Character();
	n.getStatus();
	System.out.println(n.getStatus());
	Random e = new Random();
	Character p = new Character("Enemy", "Warrior", e.nextInt(12), e.nextInt(12), e.nextInt(12), e.nextInt(2));
	n.encounter(p);
}
}
