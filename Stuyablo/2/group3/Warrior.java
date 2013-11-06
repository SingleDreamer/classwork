import java.util.*;

public class Warrior extends Character {

    public Warrior (String n) {
        super(n);
        super.charClass = "Warrior";
        super.weapons[0] = 4; // Warrior can do 4 damage with hand
    }

    public void attack () {
        int damage = (int) Math.sqrt(str);
        super.attack(damage);
    }

/*
    public void attack() {
	Random r = new Random();
	int enemyHealth = 50;
	if ( r.nextInt() > 0 )
	    enemy = new Ogre();
	if ( r.nextInt() < 0 )
	    enemy = new MrMoran();
	while ( gameOver == 0 ) {
	    System.out.println ( "Select attack : Axe(a), Sword(s), Hammer(h), Flee(f)" );
	    String selectedAttack = sc.nextLine();
	    if ( selectedAttack.equals ( "a" ) ) {
		enemyHealth = enemyHealth - 10;
		System.out.println ( "Player's Health: " + playerHealth + "\nOpponent's Health: " + enemyHealth );
	    }
	    else if ( selectedAttack.equals ( "s" ) ) {
		enemyHealth = enemyHealth - 20;
		System.out.println ( "Player's Health: " + playerHealth + "\nOpponent's Health: " + enemyHealth );
	    }
	    else if ( selectedAttack.equals ( "h" ) ) {
		enemyHealth = enemyHealth - 15;
		System.out.println ( "Player's Health: " + playerHealth + "\nOpponent's Health: " + enemyHealth );
	    }
	    else System.out.println ( "Please select a valid attack" );	
	    playerHealth = playerHealth - 10;
	    if ( playerHealth <= 0 || enemyHealth <= 0 )
		gameOver = 1;
	}
    }
*/
}
