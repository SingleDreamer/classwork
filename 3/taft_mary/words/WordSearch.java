import java.util.*;
import java.io.*;

public class WordSearch {
    private char[][] board;
    private Random rand = new Random();
    private int rows=20, cols=20;
    private ArrayList<String> dictionary, wordsinpuzzle;
    
    private void loadWords(String filename) {
	dictionary = new ArrayList<String>();

	try {
	    Scanner sc = new Scanner(new File(filename));
	    while (sc.hasNext()) {
		String s = sc.next();
		dictionary.add(s);
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("Can't open wordlist - exiting");
	    System.exit(0);
	}
    }

    public WordSearch(int rows, int cols) {
	loadWords("wordlist");
	board = new char[rows][cols];
	for (int i=0;i<rows;i++) {
	    for (int j=0;j<cols;j++) {
		board[i][j]='-';
	    }
	}
	this.rows = rows;
	this.cols = cols;
    }
    
    public WordSearch() {
	this(20,20);
	makeWordSearch();
    }

    public boolean addWord(int row, int col, int deltaR, int deltaC, String word) {
	int r,c;

	if (deltaR<-1||deltaR>1||deltaC<-1||deltaC>1||
	    (deltaR==0&&deltaC==0))
	    return false;

	r = row;
	c=col;
	for (int i=0;i<word.length();i++) {
	    try {
		if (board[r][c]!='-' && board[r][c]!=word.charAt(i))
		    return false;

	    } catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Got ArrayIndex thing: "+e);
		return false;
	    }
	    r = r + deltaR;
	    c = c + deltaC;
	}

	r=row;
	c=col;
	for (int i=0;i<word.length();i++) {
	    board[r][c]=word.charAt(i);
	    r = r + deltaR;
	    c = c + deltaC;
	}

	return true;
    }

    public boolean addWordRand(String w) {
	int r = rand.nextInt(board.length);
	int c = rand.nextInt(board[0].length);
	int deltaR = rand.nextInt(3)-1;
	int deltaC = rand.nextInt(3)-1;
	System.out.println(r+" "+c+" "+deltaR+" "+deltaC);
	return addWord(r,c,deltaR,deltaC,w);
    }

    public void fillWords() {
	ArrayList<String> wordstoattempt = null;
	int reasonablenumberofwords = rows*cols/4;
	while(reasonablenumberofwords>0) {
	    String s = dictionary.get(rand.nextInt(dictionary.size()));
	    if (!wordstoattempt.contains(s))
		wordstoattempt.add(s);
	    reasonablenumberofwords--;
	}
	for(int i = wordstoattempt.size(); i>0; i--) {
	    boolean previousattempt = true;
	    int tryagain = 3;
	    String s = wordstoattempt.get(i);
	    while (!previousattempt && tryagain > 0) {//if adding the word failed and you have more tries...
	        previousattempt = addWordRand(s);
		if (previousattempt)
		    wordsinpuzzle.add(s);
		tryagain--;
	    }
        }
    }

    public void fillSpaces() {
	for (int r=0;r<board.length;r++) {
	    for (int c=0;c<board[0].length;c++) {
		if (board[r][c]=='-') {
		    board[r][c]=(char)('A'+rand.nextInt('Z'-'A'+1));
		}
	    }
	}
    }

    public void makeWordSearch() {
	fillWords();
	fillSpaces();
	System.out.println(toString());
	System.out.println();
	System.out.println("Find: ");
	String s="";
	for(int i=0;i<wordsinpuzzle.size();i++)
	    s+=wordsinpuzzle.get(i)+"\n";
	System.out.println(s);
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
