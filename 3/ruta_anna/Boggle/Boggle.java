import java.io.*;
import java.util.*;

public class Boggle {

	private char[][] board;
	private char[][] tempBoard;
	private int rows,cols;
	private Random rand;
	private ArrayList<String> wordList;
	private ArrayList<String> wordsFound;

	//Constructor allows player to pick the size of the board
	public Boggle(int r, int c) {
			rand = new Random();
			rows = r;
			cols = c;
	    	board = new char[rows][cols];
	    	for (int i=0; i<rows; i++) {
			    for (int j=0;j<cols;j++)
			    	board[i][j]='-';
       		}
	    	int minVowel = (rows*cols)/5;
	    	for (int i=0; i<minVowel; i++){
				char vowel = assignVowels();
				int a = rand.nextInt(rows);
				int b = rand.nextInt(cols);
				board[a][b] = vowel;
			}
	        for (int i=0; i<rows; i++) {
	        	for (int j=0;j<cols;j++) {
					if (board[i][j] == '-')
						board[i][j] = (char)(rand.nextInt(26)+65);
	         	}
	        }
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

	//Loads words from a seperate file into an arraylist*/
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

	//Create a temporary board identical to the actual board game
	/*Will be helpful when checking if word is present,so we
	dont have to mess up the actual game board*/
	public void createTempBoard(){
		tempBoard = new char[board.length][board[0].length];
		for (int i=0; i<board.length; i++){
			for (int j=0; j<board[0].length; j++){
				tempBoard[i][j] = board[i][j];
			}
		}
	}

	//Check if the entered word exists in the dictionary
	public boolean isWordInDict(String word){
		for (int i=0; i<wordList.size(); i++){
			if (wordList.get(i).equals(word))
				return true;
			}
		return false;
	}

	//Checks if all the letters in the word appear on the board
	public boolean areLettersOnBoard(String word){
		createTempBoard();
		boolean result;
		char letter;
		for (int i = 0; i<word.length(); i++){
			letter = word.charAt(i);
			result = false;
			for (int j=0; j<tempBoard.length; j++){
				for (int k=0; k<tempBoard[j].length; k++){
					if (tempBoard[j][k]==letter){
						result = true;
						tempBoard[j][k] = '-';
						j=tempBoard.length;
					}
				}
			}
			if (result == false)
				return false;
		}
		return true;
	}

	//Main method that checks if the entered word is valid
	//CLEARLY NOT COMPLETE
	public boolean isValidWord(String word){
		String Upword = word.toUpperCase();
		if (isWordInDict(Upword)){
			if (areLettersOnBoard(Upword)){
			}}
		return false;
	}


    public String toString() {
		String s="";
	        for (int i=0;i<rows;i++) {
	        	for (int j=0;j<cols;j++) {
	                s=s+board[i][j];
	         	}
	        s=s+"\n";
			}
	  	return s;
	}



}