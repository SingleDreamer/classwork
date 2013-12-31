import java.io.*;
import java.util.*;

public class MainBoard{
	private char [][] board;
	private boolean play;
	private char P1, P2;
	private String Player1, Player2;
	
	public MainBoard(){
		//board = new char [3][3];
		this.play = true;
		P1 = 'X';
		P2 = 'O';
		//Player1 = name1;
		//Player2 = name2;
	}
	
	public void move(char player, int row, int col){
		this.board[row][col]=player;
	} 
	
}	