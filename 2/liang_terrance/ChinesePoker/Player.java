import java.io.*;
import java.util.*;

public class Player{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;

    public Player (String n){
	name = n;
    }

    public void addCard(Card c){
	hand.add(c);
    }
 
    public String toString(){
	String ans = name + " has ";
	for (int i = 0; i < hand.size(); i ++){
	    ans = ans + hand.get(i)+ ";";
	}
	return ans;
    }
}
