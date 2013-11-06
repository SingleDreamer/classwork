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
        for ( int j = 0 ; j < npc.length - 1; j++ ) {
            xArray [ j ] = npc [ j ].xcor;
            yArray [ j ] = npc [ j ].ycor;
        }
        while (player.health > 0) {
            String map = new String();
            containsI p = new containsI();

            for ( int i = 0 ; i < xArray.length ; i++ )
                System.out.println ( npc[i] + ": " + xArray[i] + ", " + yArray [ i ] );

            for ( int k = player.gridRange ; k >= (-1 * player.gridRange) ; k-- ) {
                if ( p.containsInt ( yArray, k ) ) {
                    int index = p.findInt ( yArray ,k );
                    int other = xArray [ index ];
                    for ( int l = (-1 * player.gridRange) ; l < other ; l++ ) {
                        map = map + "-";
                    }
                    map = map + "E";
                    for ( int m = other + 1 ; m <= player.gridRange ; m++ ) {
                        map = map + "-";
                    }
                }
                else {
                    for ( int i = (-1 * player.gridRange) ; i <= player.gridRange ; i++ ) {
                        map = map + "-";
                    }
                }
                map = map + "\n";
            }
            System.out.println ( player.xcor + ", " + player.ycor );
            //System.out.println ( map );
            int row = player.gridRange - player.ycor;
            int column = player.gridRange + 1 + player.xcor;
            String map1 = map.substring ( 0 , row * (player.gridRange * 2 + 2) + column - 1 );
            String map2 = map.substring ( row * (player.gridRange * 2 + 2) + column );
            System.out.println ( map1 + "Y" + map2 );

            if (player.exp >= (50 + Math.pow(2, player.level))) {
                player.level = player.level + 1;
                player.exp = 0;
                player.skills += 2;
                System.out.println ( "Congratulations! You have leveled up to level " + player.level );
            }

            System.out.println(String.format("What would you line to do? (Attack nearest enemy(a), explore(e), get info(i), or distribue %d skills(d) ): ", player.skills));
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

            else if (choice.equalsIgnoreCase("a")) {
                if (npc.length <= 1) {
                    npc = new Character[r.nextInt(6) + 5];
                    for (int i=0; i<npc.length-1; i++) {
                        npc[i] = new Ogre("Ogre " + i, player);
                    }
                    npc[npc.length-1] = new MrMoran("BOSS: MR.MORAN", player);
                }
                player.encounter(npc);
                while (player.getEnemy().health > 0) {
                    player.attack();
                    player.getEnemy().attack();
                }
                Character[] tempNpc = new Character[npc.length - 1];
                int offset = 0;
                for (int i=0; i<tempNpc.length; i++) {
                    if (npc[i].equals(player.getEnemy())){
                        offset -= 1;
                    }
                    else{
                        tempNpc[i + offset] = npc[i];
                   }
                }
                npc = tempNpc;
                player.getEnemy().die(player);
            }
            else if (choice.equalsIgnoreCase("i")) {
                System.out.println(String.format("Class: %s\nLevel: %d\nExperience: %d/%d\nHealth: %d\nStrength: %d\nDexterity: %d\nIntelligence %d\n", player.charClass, player.level, player.exp, (int) (50 + Math.pow(2, player.level)), player.health, player.str, player.dex, player.iq));
            }

            else if (choice.equalsIgnoreCase("d")) {
                int add;
                System.out.println(String.format("You have %d skill points to distribute amongst your strength, dexterity, and intelligence.", player.skills));
                System.out.println(String.format("How much would you like to add to your %d strength? %d skill points remaining.", player.str, player.skills));
                add = sc.nextInt();
                while (add > player.skills) {
                    System.out.println(String.format("You don't have %d skill points to spend! Choose again.", add));
                    add = sc.nextInt();
                }
                player.skills -= add;
                player.str += add;
                System.out.println(String.format("How much would you like to add to your %d dexterity? %d skill points remaining.", player.dex, player.skills));
                add = sc.nextInt();
                while (add > player.skills) {
                    System.out.println(String.format("You don't have %d skill points to spend! Choose again", add));
                    add = sc.nextInt();
                }
                player.skills -= add;
                player.dex += add;
                System.out.println(String.format("How much would you like to add to your %d intelligence? %d skill points remaining.", player.iq, player.skills));
                add = sc.nextInt();
                while (add > player.skills) {
                    System.out.println(String.format("You don't have %d skill points to spend! Choose again", add));
                    add = sc.nextInt();
                }
                player.skills -= add;
                player.iq += add;
            }

            else
                System.out.println ( "Please enter a valid command" );
        }
        System.out.println(String.format("\nOH NOES! YOU HAVE DIED! :(\nYour legacy as a level %d %s will stay in our hearts. <3", player.level, player.charClass));
    }
}
