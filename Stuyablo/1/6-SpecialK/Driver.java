import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	Character n = new Character();
	n.getStatus();
	System.out.println(n.getStatus());
	Random e = new Random();
	Character p = new Character("Enemy", "Warrior", e.nextInt(18), e.nextInt(18), e.nextInt(18), e.nextInt(5));
	n.encounter(p);
}
}
