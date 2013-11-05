import java.util.*;
import java.io.*;

public class Game{
    public int encounter(Player plr, Enemy foe) {
	//swing first, mf
	Fight f = new Fight(plr,foe);
        f.swing();
    }
<<<<<<< HEAD
	*/
	
	/*
	turn() signifies the player's turn.
	*/
	
	public void turn(Character player,Character player2) {
		boolean turn = true;
                int status = 0; //Status of game returned from encounter
		while (turn == true) {
			System.out.println("Commands:");
			System.out.println("0. Light Attack");
			System.out.println("1. Heavy Attack");
			System.out.println("2. Spell NOT IMPLEMENTED");
			System.out.println("3. Item NOT IMPLEMENTED");
			System.out.println("4. Flee");
			
			int select = input.nextInt();
			
			//battle commands
			if (select == 0) {
				status = player.encounter(player2, "Light Attack");
                                if (status == 2 || status == 3)
                                    turn = false;
			}
			if (select == 1) {
				status = player.encounter(player2, "Heavy Attack");
                                if (status == 2 || status == 3)
                                    turn = false;
			}
			if (select == 4) {
				status = player.encounter(player2,"Flee");
                                if (status == 1){
                                    System.out.println("Flee successful!");
                                    turn = false;
                                }
                        }
			
		}
	}
=======
>>>>>>> 3dd18cbf5825fd2d64428ec7f7cec12402343f92
}
