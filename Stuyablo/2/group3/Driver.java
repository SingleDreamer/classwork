import java.io.*;
import java.util.*;

public class Driver {

    public static void main (String[] args) {

        Character[] npc;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
     
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String type = new String();
        Character player = new Character(name);
        int x = 0;
        while ( x == 0 ) {
            System.out.print("Which type of character do you want to be? (Warrior, Wizard, or Thief): ");
            type = sc.nextLine();
            if ( type.equalsIgnoreCase ( "Warrior" ) ) {
                player = new Warrior ( name );
                x = 1;
            }
            else if ( type.equalsIgnoreCase ( "Wizard" ) ) {
                player = new Wizard ( name );
                x = 1;
            }
            else if ( type.equalsIgnoreCase ( "Thief" ) ) {
                player = new Thief ( name );
                x = 1;
            }
            else System.out.println ("Misspelled character type");
        }

        npc = new Character[r.nextInt(6) + 5];
        for (int i=0; i<npc.length-1; i++) {
            npc[i] = new Ogre("Ogre " + i, player);
        }
        npc[npc.length-1] = new MrMoran("BOSS: MR.MORAN", player);
            
        
        while (player.health > 0) {
	    if ( player.exp >= 50 + 2 ** player.level ) {
		player.lvl = player.lvl + 1;
		player.exp = 0;
		System.out.println ( "Congratulations! You have leveled up to level " + player.lvl )
	    }
            System.out.println ( "What would you line to do? (Attack nearest enemy(a), explore(e), or talk to friend(t)): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("e")) {
                System.out.println("Which direction would you like to go? (up, down, left, right)");
                String dir = sc.nextLine();
                System.out.println ( player.xcor + ", " + player.ycor );
                if (dir.equalsIgnoreCase("up")) {
                    if ( player.ycor <= player.gridRange )
                        player.ycor = player.ycor + 1;
                    else
                        System.out.println ( "Out of bounds" );
                }
                else if (dir.equalsIgnoreCase("down")) {
                    if ( player.ycor >= player.gridRange )
                        player.ycor = player.ycor - 1;
                    else
                        System.out.println ( "Out of bounds" );
                }
                else if (dir.equalsIgnoreCase("left")) {
                    if ( player.xcor >= player.gridRange )
                        player.xcor = player.xcor - 1;
                    else
                        System.out.println ( "Out of bounds" );
                }
                else if (dir.equalsIgnoreCase("right")) {
                    if ( player.xcor <= player.gridRange )
                        player.xcor = player.xcor + 1;
                    else
                        System.out.println ( "Out of bounds" );
                }
                else
                    System.out.println ( "Misspelled direction" );
            }
            else if (choice.equalsIgnoreCase("a"))
                player.encounter();
            else
                System.out.println ( "Please enter a valid command" );
        }
    }
}
