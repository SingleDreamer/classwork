import java.io*;
import java.util*;

public class ConnectFour extends MainBoard{
    private boolean go1;
    private int MoveRow, MoveCol, row;
    private Scanner input;
    
    public ConnectFour(){
	super();
	this.board = new char [6][7];
	go1 = true;
    }
    
    public void move(char player, int col){
	boolean fails = true;
	int row = 0;
	while (fails && (rows<7)){
	    if (this.board[row][col]==null){
		super.move(player, row, col);
		fails = false;
	    }
	    else
		row++;
	}
    }

    
    
    //We have to implement GUI input or Scanners to get the user decisions.
    public void Play_Game(){
	while (play){
	    if (go1){
		//Will move player1
	    }
	    else{
		//will move player2
	    }
	    go1 = !go1;	    
	}
    }
}