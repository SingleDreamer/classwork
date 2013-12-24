import java.io.*;
import java.util.*;

public class Card{
    private int Suit;
    private int Number;
    private ArrayList<String> Suits = new ArrayList<String> ();
    private ArrayList<String> Numbers = new ArrayList<String>();    

    public Card (int n) {
	Suit = n/13;
	Number = n%13;
	Numbers.add("Ace");
	Numbers.add("Two");
	Numbers.add("Three");
	Numbers.add("Four");
	Numbers.add("Five");
	Numbers.add("Six");
	Numbers.add("Seven");
	Numbers.add("Eight");
	Numbers.add("Nine");
	Numbers.add("Ten");
	Numbers.add("Jack");
	Numbers.add("Queen");
	Numbers.add("King");
	Suits.add("Spades");
	Suits.add("Hearts");
	Suits.add("Clubs");
	Suits.add("Diamonds");
    }

    public String toString(){
	return Numbers.get(Number) + " of " + Suits.get(Suit);
    }

    public int getSuit(){
	return Suit;
    }
    
    public int getNumber(){
	return Number;
    }


}
