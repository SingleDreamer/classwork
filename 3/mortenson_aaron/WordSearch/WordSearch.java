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
/*
Precondition: row, col represent the location to try to place the
	          first character of word

              word represents the word to try to place in the puzzle

Postcondition: If the word can be legally placed in the puzzle, modify
	           the board array so that the word is in the puzzle and
			   return True.
			   Otherwise, return false
	          
*/
    public boolean addWordH(int row, int col, String word) {
	int len = word.length();
	int rows = board.length;
	int cols = board[0].length;
	boolean go = true;
	if (col<=cols && row+len<=rows) {
	    for (int i=row;i<row+len;i++) {
		if (go)
		    go = (board[col][i]==word.charAt(i-row) || board[col][i]=='-');
	    }
	    if (go) {
		for (int i=row;i<row+len;i++)
		    board[col][i]=word.charAt(i-row);
	    }
	}
	return go;
}

}