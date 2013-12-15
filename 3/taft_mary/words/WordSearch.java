import java.io.*;
import java.util.*;

public class WordSearch {

    private char[][] board;
    private Random rand = new Random();
    private int rows, cols;
    private ArrayList<String> dictionary, wordsinpuzzle;
    private char defaultchar;

    public WordSearch(int rows, int cols, char c) {
	loadWords("wordlist");
	this.rows = rows;
	this.cols = cols;
	board = new char[rows][cols];
	defaultchar = c;
	for (int i=0; i<rows; i++) {
	    for (int j=0; j<cols; j++)
		board[i][j] = defaultchar;
	}
    }

    public WordSearch() {
	this(15,15,'-');
    }

    private void loadWords(String filename) {
	dictionary = new ArrayList<String>();
	try {
	    Scanner sc = new Scanner(new File(filename));
	    while (sc.hasNext())
	        dictionary.add(sc.next());
	} catch (FileNotFoundException e) {
	    System.out.println("File not found.");
	    System.exit(0);
	}
    }

    public boolean addWord(int row, int col, int deltaR, int deltaC, String word) {
	if(deltaR<-1||deltaR>1||deltaC<-1||deltaC>1||(deltaR==0&&deltaC==0))
	    return false;
	int r=row, c=col;
	for (int i=0; i<word.length(); i++, r+=deltaR, c+=deltaC) { //check the word is good to go
	    try {
		if ((board[r][c]!=defaultchar)&&(board[r][c]!=word.charAt(i)))
		    return false;
	    } catch (ArrayIndexOutOfBoundsException e) {
		return false;
	    }
	}
	r=row;
	c=col;
	for (int i=0; i<word.length(); i++, r+=deltaR, c+=deltaC) //then put it in
	    board[r][c] = word.charAt(i);
	return true;
    }

    public boolean addWordRandomly(String word) {
	int r = rand.nextInt(board.length),
	    c = rand.nextInt(board[0].length),
	    deltaR = rand.nextInt(3)-1,
	    deltaC = rand.nextInt(3)-1;
	return addWord(r,c,deltaR,deltaC,word);
    }

    public void fillWithWords() {
	int reasonablenumberofwords = rows*cols/5;
	wordsinpuzzle = new ArrayList<String>();
	while(reasonablenumberofwords>0) {
	    String s = dictionary.get(rand.nextInt(dictionary.size()));
	    while(wordsinpuzzle.contains(s))  //check for duplicates
		s = dictionary.get(rand.nextInt(dictionary.size()));
	    boolean b = false;
	    int tryagain = 3; //try entering the word a few times before giving up
	    while (!b && tryagain>0) {
		b = addWordRandomly(s);
		if(b) {
		    wordsinpuzzle.add(s);
		    tryagain = 3;
		}
		tryagain--;
	    }	    
	    reasonablenumberofwords--;
	}
    }

    public void fillSpaces() {
	for (int r=0;r<board.length;r++) {
	    for (int c=0;c<board[0].length;c++) {
		if (board[r][c]=='-')
		    board[r][c]=(char)('a'+rand.nextInt('z'-'a'+1));
	    }
	}
    }

    public String toString() {
	String s = "";
	for (int i=0;i<board.length;i++) {
	    for (int j=0;j<board[i].length;j++) {
		s+=board[i][j];
	    }
	    s+="\n";
	}
	s+="\n\nWords to find:\n";
	for (int i=0;i<wordsinpuzzle.size();i++)
	    s+=wordsinpuzzle.get(i)+"\n";
	return s;
    }

}
