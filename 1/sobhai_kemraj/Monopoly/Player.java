import java.util.*;
import java.io.*;
//import java.jswing.*;

public class Player{
    protected String token, name;
    protected int money, initRoll, order;
    protected Property[][] props;
    //jail shitzz
    
    public Player (String plName, String plToken){
	money = 1500;
	props = new Property[10][4];
    }
    
    public void addMoney(int amt) {//adds money for any reason
	money = money + amt;
    }
    
    public boolean loseMoney(int amt) {//deducts money for any reason
	if (money >= amt){
	    money = money - amt;
	    return true; 
	}	    
	else
	    return false;
    }
	
    public boolean giveMoney(Player other, int amt) {//gives money from one player to another
	if (this.money >= amt){
	    this.addMoney(-amt);
	    other.addMoney(amt);
	    return true; 
	}	    
	else
	    return false;
    }

    
}
    