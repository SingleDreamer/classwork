import java.io.*;
import java.util.*;

public class ChinesePoker{
    private ArrayList<Card> deck = new ArrayList<Card>();
    private Random r = new Random();

    public ChinesePoker(){ 
	for (int place=0; place < 52; place ++){
	    deck.add(new Card(place));
	}
    }

    public void dealHand(Player name){
	int i = 0;
	while (i < 13){
	    int add = r.nextInt(deck.size());
	    name.addCard(deck.remove(add));
	    i++;
	}
    }
}
