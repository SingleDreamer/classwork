import java.util.*;

public class Wizard extends Character {

    public Wizard (String n) {
        super(n);
        super.playerInit();
        super.charClass = "Wizard";
        super.weapons[0] = 2; // Wizard can do 2 damage with hand
    }

    public void attack () {
        int damage = (int) Math.sqrt(iq / 1.25);
        super.attack(damage);
    }
}
