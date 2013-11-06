import java.util.*;
import java.os.*;

public claass Nonplayer extends Character {
    private int cooldown;
    public void attack(){
	if (cooldown != 0){
	    basicattack();
	}
	else{
	    if ((Random.nextInt(10)<3)){
		specialattack2();
	    }
	    else if ((Random.nextInt(10)<5)){
		specialattack1();
	    }
	    else
		basicattack();
	}
    }
    public int getHealth(){
	return health;
    }
    public void basicattack(){
	int damage = 0;
        if (charClass == "Ogre"){
            damage = strength - 4 + Random.nextInt(3);
        }
        else {
            damage = intelligence + 2 + Random.nextInt(3);
        }
        if (cooldown > 0){
            cooldown = cooldown - 1;
        }	
	if (hit()){
            c.loseHealth(damage);
            System.out.println (name + " has attacked " + c + " with " + aname + "and did " + damage + " damage!\n");
        }
        else {
            System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
        }
    }
    public void specialattack1(){
	int damage = 0;
	String aname = "";
        if (cooldown = 0){
            if (charClass == "Ogre"){
                damage = strength + 8;
		aname = "Club whack";
            }
            else {
                damage = intelligence + 13;
		aname = "Call parent"
            }
            cooldown = 3;
        }
	if (hit()){
            c.loseHealth(damage);
            System.out.println (name + " has attacked " + c + " with " + aname + "and did " + damage + " damage!\n");
        }
        else {
            System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
        }
    }
    public void specialattack2(){
	String aname = "";
	int damage = 0;
        if (cooldown = 0){
            if (charClass == "Ogre"){
                damage = strength + 20;
		aname = "Slime ball at head";
            }
            else {
                damage = intelligence + 25;
		aname = "Confiscate phone";
            }
            cooldown = 5;
        }
	if (hit()){
            c.loseHealth(damage);
            System.out.println (name + " has attacked " + c + " with " + aname + "and did " + damage + " damage!\n");
        }
        else {
            System.out.println ("Oooh! What a shame! " + name+ " has used " + aname + ", but missed!\n");
        }
    }
    public void loseHealth(int n){
	health = health - n;
    }

    public void gainHealth(int n){
	health = health + n;
    }
    
    public void giveExp(Character c, int n){
	c.gainExp(n);
    }
    public boolean hit(){
        Random r = new Random();
        int dice1, dice2, dice3;
        dice1 = r.nextInt(6)+ 1;
        dice2 = r.nextInt(6)+ 1;
        dice3 = r.nextInt(6)+ 1;
        int sum = dice1 + dice2 + dice3;
        return (sum <= dexterity);
    }




}
