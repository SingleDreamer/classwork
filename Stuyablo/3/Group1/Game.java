import java.util.*;
import java.io.*;

public class Game{
    public int encounter(Player plr, Enemy foe) {
	//swing first, mf
	Fight f = new Fight(plr,foe);
        f.swing();
    }
}
