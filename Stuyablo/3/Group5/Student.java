import java.util.*;
import java.io.*;

public class Student extends Character{

    public Student(String name){
	this.name = name;
	health = 8;
	dexterity = 8;
	strength = 8;
	experience = 0;
	
	
    }
    
    public boolean flee(){
	boolean result;
	Scanner sc = new Scanner(System.in);
	System.out.println("You have encountered a creature! Press 1 to flee, press 2 to attack");
	String response = sc.nextLine();
	if (response.equals("2")){
	    result = false;
	    System.out.println("You have decided to attack");
	    System.out.println("----------------");
	    try {
		Thread.sleep(3000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	} 
	else{
	    boolean f = super.flee();
	    System.out.println("You have attempted to flee.");
	    System.out.println("----------------");
	        
	    if (f == true) {
		result = true;
		System.out.println("Your flight was successful");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Your health:" + this.health);
		System.out.println("Your experience:" + this.experience);
	    }
	    else {
		result = false;
		System.out.println("Your flight was unsuccessful. Your opponent will now attempt to attack you.");
		System.out.println("----------------");
		try {
		    Thread.sleep(3000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	    }
	}
	return result;
    }
    
    public int encounter(Character other){
	if (other.flee() == true){
	    experience = experience + 1;
	    System.out.println(other.name + " has fled");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    return 0;
	} 

	if (this.flee() == true){
	    System.out.println(this.name + " has fled");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    return 1;
	} 

	this.attack(other);
	System.out.println("You have attacked " + other.name);
	try {
	    Thread.sleep(3000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}

	if (other.health> 0){
	    other.attack(this);
	    System.out.println("You have been attacked by " + other.name);
	    try {
		Thread.sleep(3000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    if (this.health < 0){
		System.out.println("You have died");
		try {
		    Thread.sleep(3000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return 2;
	    }
	} else if (other.health < 0 && this.health < 0){
	    System.out.println("You and your opponent have died");
	    try {
		Thread.sleep(3000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    return 4;
	}
	else {
	    System.out.println(other.name + "has died");
	    try {
		Thread.sleep(3000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    experience = experience + 2;
	    return 3;
	}
	return 5;
    }

}
