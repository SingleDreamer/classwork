import java.io.*;
import java.util.*;

public class Jumble {

	private char[] board;
	private char[] tempBoard;
	private Random rand;
	private ArrayList<String> wordList;
	private int score = 0;

	public Jumble (int charNum){
			rand = new Random();
	    	board = new char[charNum];
	    	int minVowel = (charNum/2)-1;
	    	for (int i=0; i<minVowel; i++){
				char vowel = assignVowels();
				board[i] = vowel;
			}
	        for (int j=minVowel; j<charNum; j++)
					board[j] = (char)(rand.nextInt(26)+65);
	        loadWords("wordList.txt");
	}

	public char assignVowels(){
		rand = new Random();
		int r = rand.nextInt(5);
		if (r == 0)
			return 'A';
		else if (r == 1)
			return 'E';
		else if (r == 2)
			return 'I';
		else if (r == 3)
			return 'O';
		else
			return 'U';
	}

	private void loadWords(String filename) {
	    wordList = new ArrayList<String>();
	    try {
	    	Scanner sc = new Scanner(new File(filename));
	     	while (sc.hasNext()) {
	                wordList.add(sc.nextLine());
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Can't open wordlist - exiting");
	        System.exit(0);
	    }
	    for (int i=0; i<wordList.size(); i++){
			if (wordList.get(i).length() <3){
				wordList.remove(i);
				i--;
			}
		}
    }

	public boolean isWordInDict(String word){
		for (int i=0; i<wordList.size(); i++){
			if (wordList.get(i).equals(word))
				return true;
			}
		return false;
	}

	public void createTempBoard(){
		tempBoard = new char[board.length];
		for (int i=0; i<board.length; i++)
				tempBoard[i]= board[i];
	}

	public boolean areLettersOnBoard(String word){
			createTempBoard();
			boolean result;
			char letter;
			for (int i = 0; i<word.length(); i++){
				letter = word.charAt(i);
				result = false;
				for (int j=0; j<tempBoard.length; j++){
					if (tempBoard[j]==letter){
						result = true;
						tempBoard[j]= '-';
						j=tempBoard.length;
					}
				}
				if (result == false)
					return false;
			}
			return true;
		}

	public boolean turn(String word) {
		String Upword = word.toUpperCase();
		if (isWordInDict(Upword)){
			if(areLettersOnBoard(Upword)){
				score = score + Upword.length();
				return true;
			}
			else {
				System.out.println("Invalid Word");
				return false;
			}
		} else {
			System.out.println("Invalid Word");
			return false;
		}
	}

	public int getScore() {
		return score;
	}

     public String toString() {
		String s="";
		for (int i=0;i<board.length;i++)
			s=s+board[i];
		return s;
	}


}

