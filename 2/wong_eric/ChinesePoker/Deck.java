import java.io.*;
import java.util.*;

public class Deck {
    private Card[][] pile = new Card[4][13];
    
    public Deck(){
	for (int i=0; i<4; i++){
	    for (int j=0; j<13; j++){
		pile[i][j]= new Card (i,j);
	    }
	}
    }

}


