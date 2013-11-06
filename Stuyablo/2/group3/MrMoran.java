import java.util.*;

public class MrMoran extends Character {

    private boolean loot; // true for weapon, false for armor

    Random r = new Random(); 

    public MrMoran(String n, Character player) {
        super(n);
        npcInit(player);
        loot = r.nextBoolean();
    }

    public void die(Character player) {
        int playerWeaponsL = player.weapons.length;
        int playerArmorsL = player.armors.length;
        if (loot) {
            int[] tempWeapons = new int[playerWeaponsL];
            for (int i=0; i<playerWeaponsL; i++) {
                tempWeapons[i] = player.weapons[i];
            }
            tempWeapons[playerWeaponsL] = r.nextInt((int) (player.level * 1.5));
            player.weapons = tempWeapons;
        }
        else {
            int[] tempArmors = new int[playerArmorsL];
            for (int i=0; i<playerArmorsL; i++) {
                tempArmors[i] = player.armors[i];
            }
            tempArmors[playerArmorsL] = r.nextInt((int) (player.level + 2));
            player.armors = tempArmors;
        }
    }
}
