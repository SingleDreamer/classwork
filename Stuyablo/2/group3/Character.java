import java.util.*;

public class Character {
    protected int strength, dexterity, iq, xcor, ycor;

    public Character() {
        int range = 10;
	xcor = (int)Math.random()*range*2 - 10;
	ycor = (int)Math.random()*range*2 - 10;
    }

    public void attack() {
	System.out.println ( "attack" );
    }
}
