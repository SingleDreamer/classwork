import java.io.*;
import java.util.*;

public class MainBoard extends Board{
	
    public MainBoard(String name1, String name2){
		board = new char [3][3];
		this.play = true;
		P1 = 'X';
		P2 = 'O';
		Player1 = name1;
		Player2 = name2;
	}
	
	public void move(char player, int row, int col){
		this.board[row][col]=player;
	} 
	
}	