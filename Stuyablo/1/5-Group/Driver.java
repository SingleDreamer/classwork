import java.util.*;
import java.io.*;

public class Driver {

    public static Boolean play = true;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ////STARTUP:
        playerCharacter p1 = Startup(s);
        Kracken A = new Kracken("Agbol",p1.lvl);
        Kracken B = new Kracken("Blib",p1.lvl);
        Kracken C = new Kracken("Chogg'du",p1.lvl);
        Kracken D = new Kracken("Dlo",p1.lvl);
        Kracken E = new Kracken("Eggbutt",p1.lvl);
        Kracken[] K = {A,B,C,D,E};
        A.x = 3;
        B.x = 1; B.y = 3;
        C.x = 3; C.y = 5;
        D.y = 7;
        E.x = 7; E.y = 7;
        ////GAMEPLAY
        while (play){
            for (int i = 0; i<5; i++){
                if (Math.abs(p1.x - K[i].x) <= 1 && Math.abs(p1.y -K[i].y) <= 1){
                    System.out.print ("ENCOUNTER!" + "\n");
                    System.out.print ("It's the notorious Kracken "+K[i].name + "\n");
                    int rehp = p1.hp;
                    int redex = p1.dex;
                    while (K[i].hp >= 0 && p1.hp >=0 && Math.abs(p1.x - K[i].x) <= 1 && Math.abs(p1.y -K[i].y) <= 1){
                        EncounterTurn(p1,K[i],s);
                    }
                    p1.hp = rehp;
                    p1.dex = redex;
                }
            }
            //moving around
            if (s.hasNext()){
                String in = s.next().toUpperCase();
                if (in.equals("W") && p1.y<7){
                    p1.y = p1.y + 1;
                    System.out.println (p1.x + ", " + p1.y);
                }
                else if (in.equals("A") && p1.x>0){
                    p1.x = p1.x - 1;
                    System.out.println (p1.x + ", " + p1.y);
                }
                else if (in.equals("S") && p1.y>0){
                    p1.y = p1.y - 1;
                    System.out.println (p1.x + ", " + p1.y);
                }
                else if (in.equals("D") && p1.x<7){
                    p1.x = p1.x + 1;
                    System.out.println (p1.x + ", " + p1.y);
                }
                else if (p1.x==7 || p1.y==7){
                    type("You may not exceed the grid of (0,0) to (7,7)");
                }
                else if (in.equals("QUIT")){
                    System.exit(2);
                }
                else if (in.equals("HELP")){
                    type("Press W to go up");
                    type("Press A to go left");
                    type("Press S to go down");
                    type("Press D to go right");
                    type("Type QUIT to stop playing");
                    type("Type HELP to see this message again");
                    type("Press the enter/return key after each command");
                }
                else {
                    type("not a valid input, type HELP for valid inputs");
                }
            }
            if (K[0].x == 10 && K[1].x == 10 && K[2].x == 10 && K[3].x == 10 && K[4].x == 10) {
                type("YOU DID IT! YOU KILLED THEM ALL!");
                System.exit(1);
            }
        }
        s.close();
    }

    public static playerCharacter Startup(Scanner s) {
        playerCharacter c;
        System.out.print("\nWELCOME TO THE GAME!\n\n");
        //character type
        type("-Warrior");
        type("-Wizard");
        type("Which class would you like to be? ");
        int n = 1;
        c = new Wizard();
        String a = "";
        while (n>0){
            a = s.next();
            if (a.toUpperCase().equals("WARRIOR")) {
                c = new Warrior();
                n = n-1;
            }
            else if (a.toUpperCase().equals("WIZARD")){
                c = new Wizard();
                n = n-1;
            }
            else{
                type("The computer doesn't understand, please type something that looks like 'warrior' or 'wizard'");
            }
        }
        //name
        type("Please enter your Desired Name: ");
        c.name = s.next();
        type("");
        type("Greetings, young " + a + " named " + c.name  + "\n");
        //stats
        type("Do you wish to allocate your skill points Manually or Randomly? ");
        type("");
        Boolean done = false;
        while (!done){
            a = s.next();
            if (a.toUpperCase().equals("MANUALLY")) {
                int x = 8;
                type("");                
                type("1. Strength (and hp)");
                type("2. Dexterity");
                type("3. Intelligence");
                type("4. Defense");
                type("Select the number of the Attribute you would like to increase: ");
                while (x>0){
                    type("");
                    type("You have " + x + " attribute points left");
                    int attIncrease = s.nextInt();
                    if (attIncrease == 1) {
                        c.str = c.str + 1;
                        c.maxhp = c.maxhp + 1;
                        c.hp = c.maxhp;
                        x = x - 1;
                    }
                    else if (attIncrease == 2) {
                        c.dex = c.dex + 1;
                        x = x - 1;
                    }
                    else if (attIncrease == 3) {
                        c.intl = c.intl + 1;
                        x = x - 1;
                    }
                    else if (attIncrease == 4){
                        c.def = c.def + 1;
                        x = x - 1;
                    }
                    else {
                        type("please just type 1, 2, 3, or 4");
                    }
                }
                done = true;
            }
            else if (a.toUpperCase().equals("RANDOMLY")){
                Random f = new Random();
                for(int x=8; x>0; x--) {
                    int y = f.nextInt(3);
                    if (y==1) {
                        c.str = c.str + 1;
                        c.maxhp = c.maxhp + 1;
                    }
                    else if (y==2) {
                        c.dex = c.dex + 1;
                    }
                    else if (y==3) {
                        c.intl = c.intl + 1;
                    }
                    else {
                        c.def = c.def + 1;
                    }
                }
                done = true;
            }
            else {
                type("Please input either 'Manually' or 'Randomly'");
            }
        }
        type("\n You are on an 8 by 8 grid with 5 Krackens, defeat them all in a doomed attempt to win, type 'help' for help\n");
        System.out.println(c.x + ", " + c.y);
        return c;
    }

    public static void EncounterTurn (playerCharacter m, Kracken n, Scanner S){
        type(mult("|",n.hp) + n.name);
        type(mult("|",m.hp) + m.name);
        type("your turn");
        System.out.println("attack");
        try{
            Thread.sleep(100);
        } catch (Exception e){}
        System.out.println("flee\n");
        m.turn(S,n);
        if (n.hp <= 0){
            type("You defeated " + n.name + "!");
            n.x = 10; n.y = 10;
            type("You have gained 50 XP and regained all your health");
            m.xp += 50;
            if (m.xp == 100) {
                m.levelUp();
            }
            type(m.x + ", " + m.y);
        }
        else {
            n.turn(m);
            if (m.hp <= 0){
                type("You have died.");
                System.exit(0);
            }
        }
    }
    
    public static String mult(String s, int n){
        String result = "";
        for (n = n; n > 0; n--){
            result = result + s;
        }
        return result;
    }

    public static void type(String s){
        for (int a = 0; a < s.length(); a++){
            try{
                Thread.sleep(30);
                System.out.print(s.charAt(a));
            } catch (Exception e){}
        }
        System.out.println();

    }
}
