import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args){

	Player Eric = new Player("Eric");
	ChinesePoker game = new ChinesePoker();
	game.dealHand(Eric);
	System.out.println(Eric);

    }


}
