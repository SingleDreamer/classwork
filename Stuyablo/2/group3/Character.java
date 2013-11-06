import java.util.*;

public class Character {

    public int gridRange = 10;

    protected String name;
    protected String charClass;
    protected int xcor, ycor;
    protected int str, dex, iq, health;
    protected int level, exp, skills;
    protected int[] weapons = new int[1];
    protected int currentWeapon = 0;
    protected int[] armors = new int[1];
    protected int currentArmor = 0;

    protected Character currentEnemy;

    Random r = new Random();

    public Character(String n) {
        name = n;
        str = dex = iq = health = 8;
        exp = 0;
        skills = 8;
    }

    public void playerInit() {
        xcor = ycor = 0;
        armors = new int[] {1}; // Has mama's rags
        level = 1;
    }

    public void npcInit(Character player) {
        /*xcor = (int) (Math.random() * gridRange * 2 - gridRange);
        ycor = (int) (Math.random() * gridRange * 2 - gridRange);*/
        xcor=ycor=0;

        // Code used for balancing strength of player and nonplayers
        level = player.level;
        skills += level * 2;
        int strGain = r.nextInt(skills);
        int dexGain = r.nextInt(skills - strGain);
        int iqGain = skills - strGain - dexGain;
        str += strGain;
        dex += dexGain;
        iq += iqGain;

        armors = new int[] {r.nextInt(3)};
        setEnemy(player);
    }

    public String toString() {
        return name;
    }

    public void setEnemy(Character enemy) {
        currentEnemy = enemy;
    }

    public double getDistance(Character other) {
        double sq1 = Math.pow(xcor, 2) + Math.pow(ycor, 2);
        double sq2 = Math.pow(other.xcor, 2) + Math.pow(other.ycor, 2);
        return Math.sqrt(sq1 + sq2);
    }

    protected void encounter(Character[] npc) {
        for (int i=0; i<npc.length; i++) {
            if (getDistance(npc[i]) < 1.5) {
                setEnemy(npc[i]);
                break;
            }
        }
    }

    // Dummy method since Java won't compile if you're in the superclass calling a subclass method that works perfectly fine
    protected void attack() {
        attack(0);
    }

    protected void attack(int initDamage) {
        int damage = initDamage + weapons[currentWeapon];
        int dice = r.nextInt(6) + r.nextInt(6) + r.nextInt(6) + 3;
        if (dice == 3) {
            damage *= 3;
            damage -= currentEnemy.armors[currentArmor];
            currentEnemy.health -= damage;
            System.out.println(String.format("%s successfully hit %s for %d damage!", this, currentEnemy, damage));
        }
        else if (dice == 4) {
            damage *= 2;
            damage -= currentEnemy.armors[currentArmor];
            currentEnemy.health -= damage;
            System.out.println(String.format("%s successfully hit %s for %d damage!", this, currentEnemy, damage));
        }
        else if (dice == 5) {
            damage -= currentEnemy.armors[currentArmor];
            currentEnemy.health -= damage;
            System.out.println(String.format("%s successfully hit %s for %d damage!", this, currentEnemy, damage));
        }
        else if (dice == 18 && (getClass().toString().equals("Warrior") || getClass().toString().equals("Thief") || getClass().toString().equals("Wizard"))) {
            int[] tempWeapons = new int[weapons.length - 1];
            int offset = 0;
            for (int i=0; i < tempWeapons.length; i++) {
                if (i == currentWeapon)
                    offset -= 1;
                else
                    tempWeapons[i + offset] = weapons[i];
            }
            weapons = tempWeapons;
            System.out.println("Oops! You broke your weapon! Now you have to use your hands!");
        }
        else {
            int yourTestDex = (int) (dex / (Math.random() + 1));
            double chance = yourTestDex / currentEnemy.dex;
            if (chance > 1 || Math.random() < chance) {
                damage -= currentEnemy.armors[currentArmor];
                currentEnemy.health -= damage;
                System.out.println(String.format("%s successfully hit %s for %d damage!", this, currentEnemy, damage));
            }
            else {
                System.out.println(String.format("%s dodged %s's attack!", currentEnemy, this));
            }
        }
    }

    protected boolean flee() {
        double roll = Math.random();
        if ((charClass == "Thief" && roll < .25) || (charClass == "Warrior" && roll < .1) || (charClass == "Wizard" && roll < .2)) {
            currentEnemy = null;
            return true;
        }
        else
            return false;
    }

    public void die(Character player) {
        boolean loot = r.nextBoolean();
        int playerWeaponsL = player.weapons.length;
        int playerArmorsL = player.armors.length;
        if (loot) {
            int[] tempWeapons = new int[playerWeaponsL + 1];
            for (int i=0; i<playerWeaponsL; i++) {
                tempWeapons[i] = player.weapons[i];
            }
            tempWeapons[playerWeaponsL] = r.nextInt((int) (player.level * 1.5));
            player.weapons = tempWeapons;
        }
        else {
            int[] tempArmors = new int[playerArmorsL + 1];
            for (int i=0; i<playerArmorsL; i++) {
                tempArmors[i] = player.armors[i];
            }
            tempArmors[playerArmorsL] = r.nextInt((int) (player.level + 2));
            player.armors = tempArmors;
        }
        player.currentEnemy = null;
        int expGain = r.nextInt(10) + 10;
        player.exp += expGain;
        System.out.println(String.format("%s has slain %s. %s has gained %d exp!", player, this, player, expGain));
    }

    public Character getEnemy() {
        return currentEnemy;
    }
}
