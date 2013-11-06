import java.util.*;

public class Character {

    protected String name;
    protected String charClass;
    protected int xcor, ycor;
    protected int str, dex, intel, health;
    protected int lvl, exp, skills;
    protected int[] weapons = new int[1];
    protected int currentWeapon = 0;
    protected int armor;

    public int gridRange = 10;

    Random r = new Random();

    public Character(String n) {
        name = n;
        xcor = (int) (Math.random() * gridRange * 2 - gridRange);
        ycor = (int) (Math.random() * gridRange * 2 - gridRange);
        str = dex = intel = 8;
        skills = 8;
    }

    public String toString() {
        return name;
    }

    protected void attack(Character other) {
        int damage = weapons[currentWeapon];
        int result = r.nextInt(6) + r.nextInt(6) + r.nextInt(6) + 3;
        if (result == 3) {
            damage *= 3;
            damage -= other.armor;
            System.out.println(String.format("You successfully hit %s for %d damage!", other, damage));
        }
        else if (result == 4) {
            damage *= 2;
            damage -= other.armor;
            System.out.println(String.format("You successfully hit %s for %d damage!", other, damage));
        }
        else if (result == 5) {
            damage -= other.armor;
            System.out.println(String.format("You successfully hit %s for %d damage!", other, damage));
        }
        else if (result == 18) {
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
            double chance = yourTestDex / other.dex;
            if (chance > 1 || Math.random() < chance) {
                damage -= other.armor;
                System.out.println(String.format("You successfully hit %s for %d damage!", other, damage));
            }
            else {
                System.out.println(String.format("%s dodged your attack!", other));
            }
        }
    }
}
