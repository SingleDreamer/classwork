import java.util.*;
import java.io.*;

public class Game{
    Random rand = new Random();
	Scanner input = new Scanner(System.in);
    /*
	public void createAdv(String name, String type){
		
    }
	*/
	
	/*
	turn() signifies the player's turn.
	*/
	
	public void Turn(Character player, player2) {
		turn = true;
		while (turn == true) {
			System.out.println("Commands:");
			System.out.println("0. Light Attack");
			System.out.println("1. Heavy Attack");
			System.out.println("2. Spell NOT IMPLEMENTED");
			System.out.println("3. Item NOT IMPLEMENTED");
			System.out.println("4. Flee");
			
			int select = input.nextLine();
			
			//battle commands
			if (select == 0) {
				player.encounter(player2, "Light Attack");
			}
			if (select == 1) {
				player.encounter(player2, "Heavy Attack");
			}
			if (select == 4) {
				turn = !player.flee();
			}
			
		}
	}
}
