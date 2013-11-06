import java.util.*;

public class Character {

    public int gridRange = 10;

    protected String name;
    protected String charClass;
    protected int xcor, ycor;
    protected int str, dex, iq, health;
    protected int lvl, exp, skills;
    protected int[] weapons = new int[1];
    protected int currentWeapon = 0;
    protected int armor;

    private Character currentEnemy;

    Random r = new Random();

    public Character(String n) {
        name = n;
        xcor = (int) (Math.random() * gridRange * 2 - gridRange);
        ycor = (int) (Math.random() * gridRange * 2 - gridRange);
        str = dex = iq = health = 8;
        skills = 8;
    }

    public void playerInit() {
        xcor = 0;
        ycor = 0;
    }

    public void npcInit() {

    }

    public String toString() {
        return name;
    }

    public void setEnemy(Character enemy) {
        currentEnemy = enemy;
    }

    protected void encounter() {

    }

    protected void attack(int initDamage) {
        int damage = initDamage + weapons[currentWeapon];
        int dice = r.nextInt(6) + r.nextInt(6) + r.nextInt(6) + 3;
        if (dice == 3) {
            damage *= 3;
            damage -= currentEnemy.armor;
            System.out.println(String.format("You successfully hit %s for %d damage!", currentEnemy, damage));
        }
        else if (dice == 4) {
            damage *= 2;
            damage -= currentEnemy.armor;
            System.out.println(String.format("You successfully hit %s for %d damage!", currentEnemy, damage));
        }
        else if (dice == 5) {
            damage -= currentEnemy.armor;
            System.out.println(String.format("You successfully hit %s for %d damage!", currentEnemy, damage));
        }
        else if (dice == 18) {
            int[] tempWeapons = new int[weapons.length - 1];
            int offset = 0;
            for (int i=0; i < tempWeapons.length; i++) {
                if (i == currentWeapon)
                    offset += 1;
                else
                    tempWeapons[i] = weapons[i + offset];
            }
            weapons = tempWeapons;
            System.out.println("Oops! You broke your weapon! Now you have to use your hands!");
        }
        else {
            int yourTestDex = (int) (dex / (Math.random() + 1));
            double chance = yourTestDex / currentEnemy.dex;
            if (chance > 1 || Math.random() < chance) {
                damage -= currentEnemy.armor;
                System.out.println(String.format("You successfully hit %s for %d damage!", currentEnemy, damage));
            }
            else {
                System.out.println(String.format("%s dodged your attack!", currentEnemy));
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

    public Character getEnemy() {
        return currentEnemy;
    }
}
