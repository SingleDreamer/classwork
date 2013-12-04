import java.util.*;
public class WordSearch {

    private char[][] board;
    private int rows, cols;

    public WordSearch(int rows, int cols) {
	board = new char[rows][cols];
	this.rows = rows;
	this.cols = cols;
	for (int i=0;i<rows;i++) 
	    for (int j=0;j<cols;j++) 
		board[i][j]='-';
    }

    public WordSearch() {
	this(20,20);
    }

    public String toString() {
	String s = "";
	for (int i=0;i<board.length;i++) {
	    for (int j=0;j<board[i].length;j++) {
		s=s+board[i][j];
	    }
	    s=s+"\n";
	}
	return s;
    }

    public boolean AddWord(int r, int c, String word) {
	int len = word.length();
	if (c + len >= cols) {
	    System.out.println("You cannot enter this word at this position");
	    return false;
	}
	for (int i = 0; i < len; i++) {
	    char x = word.charAt(i);
	    board[r][c + i] = x;
	}
	return true;
    }

}
