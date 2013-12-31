import java.io*;
import java.util*;

public class ConnectFour extends MainBoard{
	private boolean go1;
	private int MoveRow, MoveCol;
	public ConnectFour(){
		super();
		this.board = new char [6][7];
		go1 = true;
	}
	
	//We have to implement GUI input or Scanners to get the user decisions.
	public void Play_Game(){
		while (play){
			if (go1){
				move(P1, MoveRow, MoveCol);
			}
			else{
				move(P2, MoveRow, MoveCol);
			}
			go1 = !go1;
			
			
		}
	}
}