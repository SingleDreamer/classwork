import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
        Game g = new Game();
        Player p1 = new Player("Player");   
	Enemy e = new Enemy();

	g.encounter(p1,e);
    }
} 
