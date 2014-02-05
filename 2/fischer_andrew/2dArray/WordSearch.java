import java.util.*;

public class WordSearch {
    private char[][] board;

    public WordSearch(int rows, int cols) {
	board = new char[rows][cols];
	for (int i=0;i<rows;i++) {
	    for (int j=0;j<cols;j++) {
		board[i][j]='-';
	    }
	}

    }

    public WordSearch() {
	this(20,20);
    }

    public String toString() {
	String s="";
	for (int i=0;i<board.length;i++) {
	    for (int j=0;j<board[i].length;j++) {
		s=s+board[i][j];
	    }
	    s=s+"\n";
	}
	return s;
    }

    public boolean AddWordH(int r,int c,String word){
	boolean complete = true;
	
	for (int i=0; i<word.length;i++){
	    if (
		(!((String)board[r][c+i].equals(word.subString(i,i+1))))
		&&
		(!((String)board[r][c+i].equals("-")))
		)
		
		{
		    complete = false;
		}
	    elif
	


	return complete;

    }


}
