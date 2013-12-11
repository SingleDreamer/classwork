import java.util.*;
import java.io.*;


public class WordSearch2 {
    private int rows, cols, listlength;
    private char[][] board;
    private ArrayList<String> words, selected;

    public WordSearch2(int rows, int cols) {
       	board = new char[rows][cols];
	for (int i=0;i<rows;i++) {
	    for (int j=0;j<cols;j++) {
		board[i][j]='-';
	    }
	}
	this.rows = rows;
	this.cols = cols;
	getList();
    }

    public WordSearch2() {
	this(20,20);
    }
    
    public boolean addWord(int row, int col, String word, int x){
	/* int x indicates which position you want to insert the word in
	   1 = Horizontal Forward
	   2 = Right Upward
	   3 = Right Downward
	   4 = Horizontal Backward
	   5 = Left Upward
	   6 = Left Downward
	   7 = Vertical Upward
	   8 = Vertical Downward
	*/
	int length = 0;
	int width = 0;
	int nlength = 0;
	int nwidth = 0;
	int n = 0;
	int m = 0;

	if(x==1){
	    length = word.length();
	    width = 0;
	    nlength = 0;
	    nwidth = 0;
	    n = 0;
	    m = 1;
	}

	if(x==2){
	    length = word.length();
	    width = 0;
	    nlength = 0;
	    nwidth = -1 * word.length();
	    n = -1;
	    m = 1;   
	}

	if(x==3){
	    length = word.length();
	    width = word.length();
	    nlength = 0;
	    nwidth = 0;
	    n = 1;
	    m = 1;
	}

	if(x==4){
       	    length = 0;
	    width = 0;
	    nlength = -1 * word.length();
	    nwidth = 0;
	    n = 0;
	    m = -1;
	}

	if(x==5){
	    length = 0;
	    width = 0;
	    nlength = -1 * word.length();
	    nwidth = -1 * word.length();
	    n = -1;
	    m = -1;
	}

	if(x==6){
	    length = 0;
	    width = word.length();
	    nlength = -1 * word.length();
	    nwidth = 0;
	    n = 1;
	    m = -1;
	}

	if(x==7){
	    length = 0;
	    width = 0;
	    nlength = 0;
	    nwidth = -1 * word.length();
	    n = -1;
	    m = 0;
	}

	else{
	    length = 0;
	    width = word.length();
	    nlength = 0;
	    nwidth = 0;
	    n = 1;
	    m = 0;
	}

	if(row+nlength<0||col+width>cols||col+nwidth<0||row+length>rows){
	    return false;
	}
	
	int i = 0;
	int j = 0;
	int k = 0;
	while(k<word.length()){
	    if(board[row+i][col+j] != '-'&& board[row+i][col+j] != word.charAt(k)){
		return false;
	    }
	    i = i + n;
	    j = j + m;
	    k = k + 1;
	}
	
	i = 0;
	j = 0;
	k = 0;
	while(k<word.length()){
	    board[row+i][col+j] = word.charAt(k);
	    i = i + n;
	    j = j + m;
	    k = k + 1;
	}

	return true;
    }
   
    public void getList() {
	try{
	    System.out.println("Startin' it");
	    Scanner s = new Scanner(new File("words"));
	    System.out.println("What?");
	    listlength = 0;
	    while(s.hasNext()){
		words.add(s.next());
		listlength++;
	    }
	    System.out.println("Been there, done that.");
	}
	catch (Exception e){}
    }

    public boolean availability(String werd) {
	if(werd.length() > 1 && !selected.contains(werd)) 
	    return true;
	return false;
    }

    public boolean tryToAddWord() {
	Random r = new Random();
	String werd = words.get(r.nextInt(listlength));
	int rrow = r.nextInt(rows+1);
	int rcol = r.nextInt(cols+1);
	int place = r.nextInt(8)+1;
	if (availability(werd)) {
	    while(!addWord(rrow,rcol,werd,place)){
	    }
	    return true;
	}
	return false;
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

}
