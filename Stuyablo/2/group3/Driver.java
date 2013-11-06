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

	int[] xArray = new int [ npc.length - 1 ];
	int[] yArray = new int [ npc.length - 1 ];
	for ( int j = 0 ; j < npc.length - 1 ; j++ ) {
	    xArray [ j ] = npc [ j ].xcor;
	    yArray [ j ] = npc [ j ].ycor;
	}

        while (player.health > 0) {
	    String map = new String();
	    containsI p = new containsI();

	    for ( int i = 0 ; i < xArray.length ; i++ )
		System.out.println ( xArray[i] + ", " + yArray [ i ] );

	    for ( int k = 10 ; k >= -10 ; k-- ) {
		if ( p.containsInt ( yArray, k ) ) {
		    int index = p.findInt ( yArray ,k );
		    int other = xArray [ index ];
		    for ( int l = -10 ; l < other ; l++ ) {
			map = map + "-";
		    }
		    map = map + "E";
		    for ( int m = other + 1 ; m <= 10 ; m++ ) {
			map = map + "-";
		    }
		}
		else {
		    for ( int i = -10 ; i <= 10 ; i++ ) {
		        map = map + "-";
		    }
		}
		map = map + "\n";
	    }
	    System.out.println ( player.xcor + ", " + player.ycor );
	    //System.out.println ( map );
	    int row = 10 - player.ycor;
	    int column = 11 + player.xcor;
	    String map1 = map.substring ( 0 , row * 22 + column - 1 );
	    String map2 = map.substring ( row * 22 + column );
	    System.out.println ( map1 + "Y" + map2 );
	    System.out.println ( map.substring ( 1 , 25 ) );
	    if ( player.exp >= 50 + Math.pow ( 2 , player.level ) ) {
		player.level = player.level + 1;
		player.exp = 0;
		System.out.println ( "Congratulations! You have leveled up to level " + player.level );
	    }
            System.out.println ( "What would you like to do? (Attack nearest enemy(a), explore(e), or talk to friend(t)): ");
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
