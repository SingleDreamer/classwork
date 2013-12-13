import java.util.*;
import java.io.*;

public class WordSearch {
    private char[][] board;
    private Random rand;
    private ArrayList<String> dictionary, puzzlewords=null;
    
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

    public void chooseWords() {
	for(int i = rows*cols/6; i>0; i--) {
	    int next = rand.nextInt(dictionary.size());
	    // if (dictionary.get(next)) //NOT IN puzzlewords)
		puzzlewords.add(dictionary.get(next));
	}
    }

    public WordSearch(int rows, int cols) {
	rand = new Random();
	loadWords("wordlist");
	System.out.println(wordList);
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

    public boolean addWordH(int row, int col, String word) {
	
	for (int i=0;i<word.length();i++) {
	    try {
		// int j = 10/0; // <-- only here to show ArithmeticException
		if (board[row][col+i]!='-' && board[row][col+i]!=word.charAt(i))
		    return false;

	    } catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("Got ArrayIndex thing: "+e);
		return false;
	    } catch (ArithmeticException e) {
		System.out.println("Got the math thing: "+e);
		return false;
	    } catch (Exception e) {
		System.out.println("Last case, generic exception: "+e);
		return false;
	    }
	    

	   
	}

	for (int i=0;i<word.length();i++) {
	    board[row][col+i]=word.charAt(i);
	}

	return true;
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
