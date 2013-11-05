import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Game g = new Game();
<<<<<<< HEAD
        Character c = new Character("Character 1");   
        System.out.println(c.getStatus());
        Character c2 = new Character("Character 2");
        System.out.println(c2.getStatus());
        //Warrior w1 = new Warrior("Warrior");
        //System.out.println(w1.getStatus());
        Game game = new Game();

        System.out.println("Testing");    
        game.turn(c,c2);

 /*       System.out.println("Encounter start attack");
        int status = 5;
        String cont = "Yes";
        while (status == 5 && cont.equals("Yes")){
        status = c.encounter(c2,"Light Attack");
        System.out.println("Continue (Type Yes or No): ");
        cont = sc.nextLine();
        }*/
=======
        Player p1 = new Player("Player");   
	Enemy e = new Enemy();

	g.encounter(p1,e);
>>>>>>> 3dd18cbf5825fd2d64428ec7f7cec12402343f92
    }
} 
