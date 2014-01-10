import java.io.*;
import java.util.*;

public class Board{
    protected char [][] board;
    private boolean play;
    protected char P1, P2;
    protected String Player1, Player2;
    
    public Board(){
	//board = new char [3][3];
	play = true;
	P1 = 'X';
	P2 = 'O';
	//Player1 = name1;
	//Player2 = name2;
    }
    
    public void move(char player, int row, int col){
	board[row][col]=player;
    } 
    
   
	
}	
