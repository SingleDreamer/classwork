import java.io.*;
import java.util.*;

public class Warrior extends Character{
    private int level;
    private int cooldown;

    public Warrior (){
	Scanner n = new Scanner (System.in);
	System.out.print("Enter your name: ");
	name = n.nextLine();
	System.out.print("Welcome to StuyabloII, " + name + "\n");
	charClass = "Warrior";
    }

    public void action(){
	if (experience > 100){
	    levelUp();
	    action();
	}
	Scanner s = new Scanner (System.in);
	System.out.print("what would you like to do? \n 1: Heal yourself or 2: Fight enemies? or 3: Check Status\n ");
        int ans = s.nextInt();
	if (ans == 1){
	    if (health < maxhealth){
		int amt = maxhealth - health;
		if ((gold - amt) >= 0){
		    gold = gold - (maxhealth - health);
		    health = maxhealth;
		    System.out.println("Your health is now max. Used " + amt + " gold.\n");
		    action();
		}
		else{
		    System.out.println("You do not have the gold for that.\n");
		    action();
		}
	    }
	    else {
		System.out.println("Your health is maxed already!\n");
		action();
	    }
	}
	else if (ans == 2){
	    encounter();
	}
	else if (ans == 3){
	    System.out.println(getStatus());
	    action();
	}
	else {
	    System.out.println("Silly player. That's not a command.\n");
	    action();
	}
    }


    public void battle(Character other) {
        if (health > 0){
            this.attack(other);
        }
        if (other.getHealth() > 0){
	    if (other.getChar().equals("Mr.Moran")){
		((MrMoran)other).attack(this);
	    }
	    else {
		((Ogre)other).attack(this);
	    }
        }
        int otherHealth = other.getHealth();
        if (otherHealth < 0){
            otherHealth = 0;
        }
        if (health < 0){
            health = 0;
        }
        System.out.print(this + " : " +  health + " \n");
        System.out.print(other + " : " + otherHealth+ " \n");
        if ((health > 0) && (other.getHealth() > 0)){
            this.battle(other);
        }
        else {
            if (health <= 0){
                System.out.print("GAME OVER!");
            }
            else {
                System.out.print("You have won the fight! Gained 300 gold and 30 experience. \n");
                gold = gold + 300;
                experience = experience + 30;
                action();
            }
        }
    }

    public void encounter(){
	Random r = new Random();
	String ans;
	Scanner s = new Scanner (System.in);
	if (r.nextInt(3)== 2){
	    System.out.println("You have encountered Mr. Moran! Fight like a hero or flee like a coward? Input 'Fight' or 'Flight'\n");
	    ans = s.nextLine();
	    if (ans.equals("Fight")){
	        MrMoran enemy = new MrMoran();
		enemy.setStrength();
		enemy.setDexterity();
		enemy.setIntelligence();
	        battle (enemy);
	    }
	    else if (ans.equals("Flight")){
		flee();
		action();
	    }
	    else{
		System.out.println("Invalid response, the enemy has run away.\n");
	    }
	}
	else {
	    System.out.println("You have encountered an ogre! Fight like a hero or flee like a coward? Input 'Fight' or 'Flight'\n");
	    ans = s.nextLine();
	    if (ans.equals("Fight")){
	        Ogre enemy = new Ogre();
		enemy.setStrength();
		enemy.setDexterity();
		enemy.setIntelligence();
	        battle (enemy);
	    }
	    else if (ans.equals("Flight")){
		flee();
		action();
	    }
	    else{
		System.out.println("Invalid response, the enemy has run away.\n");
		action();
	    }
	}
    }
    public void flee(){
	if (experience >= 20){
	    experience = experience - 20;
	}
	else{
	    experience = 0;
	}
	System.out.println ("Coward! You have fled! Lost 20 experience. \n");
    }

    public void attack(Character c){
	Scanner s = new Scanner (System.in);
	System.out.print ("How would you like to fight? \n1 : Basic Attack\n2: Special Attack 1\n3: Special Attack 2 \nOr would you like to flee? \n4: Flee\n  ");
	int attack = s.nextInt();
	if (attack == 1)
	    basicattack(c);
	else if (attack == 2){
	    if (cooldown > 0){
		System.out.println("You do not have the energy for that. Wait "+ cooldown + " more turns.");
		attack(c);
	    }
	    else
		specialattack1(c);
	}
	else if (attack == 3){
	    if (cooldown > 0){
		System.out.println("You do not have the energy for that. Wait "+ cooldown + " more turns.");
		attack (c);
	    }
	    else
		specialattack2(c);
	}
	else if (attack == 4){
	    flee();
	    action();
	}
	else {
	    System.out.print ("That is not an attack.");
	    attack(c);
	}
    }

    public void basicattack(Character c){
	Random r = new Random();
	int damage = 0;
	String aname = "Basic Attack";
	damage = strength - 2 + r.nextInt(5);
	if (cooldown > 0)
	    cooldown = cooldown - 1;
	if (hit()){
	    c.loseHealth(damage);
	    System.out.println (name + " has attacked " + c + " with " + aname + " and did " + damage + " damage!\n");
	}
	else {
	    System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
	}
    }

    public void specialattack1(Character c){
	int damage = 0;
	String aname = "";
	if (cooldown == 0){
	    damage = strength + 10;
	    aname = "Sword Spin";
	    cooldown = 1;
	}
	if (hit()){
	    c.loseHealth(damage);
	    System.out.println (name + " has attacked " + c + " with " + aname + " and did " + damage + " damage!\n");
	}
	else {
	    System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
	}
    }

    public void specialattack2(Character c){
	int damage = 0;
	String aname = "";
	if (cooldown == 0){
		damage = strength + 25;
		aname = "Sword Lunge";
		cooldown = 3;
	}
	if (hit()){
	    c.loseHealth(damage);
	    System.out.println (name + " has attacked " + c + " with " + aname + " and did " + damage + " damage!\n");
	}
	else {
	    System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
	}
    }

    public void levelUp(){
	experience = experience - 100;
	level = level + 1;
	gold = gold + 100;
	maxhealth = maxhealth + 50;
	health = maxhealth;
	System.out.print("Congratulations! You have leveled up!" + "\n");
	System.out.print("Here are three stat points to use. \n");
	int points = 3;
	points = setStrength (points);
	System.out.print ("\n" + "There are " + points + " points left");
        if (points > 0){
	    points = setDexterity (points);
	    System.out.print ("\n" + "There are " + points + " points left");
	}
	if (points > 0){
	    points = setIntelligence (points);
	    System.out.print ("\n" + "There are " + points + " points left");
	}
	if (points > 0){
	    System.out.print ("\n" + "Due to failure to use all your points, they are now gone. -poof-" + "\n");
	}	
    }
}
