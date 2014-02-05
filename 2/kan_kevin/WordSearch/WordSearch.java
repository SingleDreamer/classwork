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

    private boolean ableToAddH(int r, int c, String word) {
	if ((r > board.length) || (c + word.length() > board[0].length)) {
	    return false;
	} 
	for (int i =0; i< word.length(); i++){
	    if (board[r][c+i] != '-' && board[r][c+i] != word.charAt(i)) {
		return false;
	    }
	}
	return true;
    }

    private boolean ableToAddV(int r, int c, String word){
	if ((r+word.length() > board.length) || (c> board[0].length)){
	    return false;
	}
	for (int i =0; i< word.length(); i++){
	    if (board[r+i][c] != '-' && board[r+i][c] != word.charAt(i)) {
		return false;
	    }
	}
	return true;
    }

    public boolean addWordH(int row, int col, String word) {
	if (ableToAddH(row,col,word)){
	    for (int i = 0; i< word.length(); i++){
		board[row][col+i] = word.charAt(i);
	    }
	    return true;
	}
	return false;
    }

    public boolean addWordV(int row, int col, String word){
	if (ableToAddV(row,col,word)){
	    for (int i = 0; i< word.length(); i++){
		board[row+i][col] = word.charAt(i);
	    }
	    return true;
	}
	return false;
    }
    
    public boolean addBackH(int row, int col, String word){
    }
    public boolean addbackV(int row, int col, String word){
    }
    public boolean addNE(int row, int col, String word){
    }
    public boolean addNW(int row, int col, String word){
    }
    public boolean addSE(int row, int col, String word){
    }
    public boolean addSW(int row, int col, String word){
    }


}
