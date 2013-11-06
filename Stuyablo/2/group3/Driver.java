import java.io.*;
import java.util.*;

public class Driver {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
     
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        String type = new String();
        Character player = new Character(name);
        int x = 0;
        while ( x == 0 ) {
            System.out.print("Which type of character do you want to be? (Warrior, Wizard, or Thief): ");
            type = sc.nextLine();
            if ( type.equals ( "Warrior" ) ) {
                player = new Warrior ( name );
                x = 1;
            }
            else if ( type.equals ( "Wizard" ) ) {
                player = new Wizard ( name );
                x = 1;
            }
            else if ( type.equals ( "Thief" ) ) {
                player = new Thief ( name );
                x = 1;
            }
            else System.out.println ("Misspelled character type");
        }
        
        System.out.print ( "Hello " + name + "! Congratulations on becoming a " + type + "! Please select what you want to do next. (Attack nearest enemy(a), explore(e), or talk to friend(t)): ");
        String choice = sc.nextLine();
        if (choice.equals("e")) {
            System.out.println("Which direction would you like to go? (up, down, left, right)");
            String dir = sc.nextLine();
            if (dir == "up"){
                player.ycor = player.ycor + 1;
            }
            else if (dir == "down"){
                player.ycor = player.ycor - 1;
            }
            else if (dir == "left"){
                player.xcor = player.xcor - 1;
            }
            else if (dir == "right"){
                player.xcor = player.xcor + 1;
            }
        }
        else if (choice.equals( "a" )) {
            player.encounter();
        }
    }
}
