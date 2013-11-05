import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Game g = new Game();
        Character c = new Character("Character 1");   
        System.out.println(c.getStatus());
        Character c2 = new Character("Character 2");
        System.out.println(c2.getStatus());
       
        System.out.println("Encounter start attack");
        int status = 5;
        String cont = "Yes";
        while (status == 5 && cont.equals("Yes")){
        status = c.encounter(c2,"Light Attack");
        System.out.println("Continue (Type Yes or No): ");
        cont = sc.nextLine();
        }
    }
} 
