import java.io.*;
import java.util.*;

public class ChinesePoker{
    private Card[][] deck = new Card[4][13];

    public ChinesePoker(){    
	for (int i=0; i<4; i++){
	    for (int j=0; j<13; j++){
		deck[i][j]= new Card (i,j);
	    }
	}
    }












}
