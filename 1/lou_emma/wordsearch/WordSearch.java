import java.util.*;

public class WordSearch {

    private char[][] board;

    public WordSearch(int rows, int cols) {
        board = new char[rows][cols];
        for (int i=0;i<rows;i++)
         for (int j=0;j<cols;j++)
                board[i][j]='-';
    }

    public WordSearch() {
        this(20,20);
    }

    public boolean addWordH(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r][c+i] != '-' && board[r][c+i]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
         board[r][c+i]=word.charAt(i);
         i++;
        }
        
        return true;
    }



    public String toString() {
        String s = "";
        for (int i=0;i<board.length;i++) {
         for (int j=0;j<board[i].length;j++) {
                s=s+board[i][j];
         }
         s=s+"\n";
        }
        return s;
    }

  

    public boolean addWordV(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r+i][c] != '-' && board[r+i][c]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
         board[r+i][c]=word.charAt(i);
         i++;
        }
        
        return true;
    }

  public boolean addWordHBack(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r][c+i] != '-' && board[r][c+i]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
	    board[r][c+i]=word.charAt(word.length()-i-1);
         i++;
        }
        
        return true;
    }

 public boolean addWordVBack(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r+i][c] != '-' && board[r+i][c]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
	    board[r+i][c]=word.charAt(word.length()-i-1);
         i++;
        }
        
        return true;
    }

 public boolean addWordDiagUR(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r-i][c+i] != '-' && board[r-i][c+i]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
         board[r-i][c+i]=word.charAt(i);
         i++;
        }
        
        return true;
    }

 public boolean addWordDiagDL(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r+i][c-i] != '-' && board[r+i][c-i]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
         board[r+i][c-i]=word.charAt(i);
         i++;
        }
        
        return true;
    }

 public boolean addWordDiagDR(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r+i][c+i] != '-' && board[r+i][c+i]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
         board[r+i][c+i]=word.charAt(i);
         i++;
        }
        
        return true;
    }

 public boolean addWordDiagUL(int r, int c, String word) {
        int i;
        int j;

        /* see if we can place the word */
        i=0;
         while (i<word.length()) {
                try {
                 //j=10/i; <-- this is only to show the Arithmetic exception
                 if ( board[r-i][c-i] != '-' && board[r-i][c-i]!=word.charAt(i)) {
                        return false; // we return false since we can't add the word
                 }
                } catch (ArrayIndexOutOfBoundsException e) { // Handle the array one
                 System.out.println(e);
                 return false; // we return false since we can't add the word
                } catch (ArithmeticException e) { // handle the divide by 0
                 System.out.println(e);
                 return false;
                } catch (Exception e) { // handle any other exceptions
                 System.out.println(e);
                 return false;
                }


                i++;
         }
    

        
        /* if we get here, we can add the word */
        i=0;
        while (i<word.length()) {
         board[r-i][c-i]=word.charAt(i);
         i++;
        }
        
        return true;
    }

    public void fill (){
	String letters = "qwertyuiopasdfghjklzxcvbnm";
	random R=new Random;
	for (int j=0; j<board.length; j++){
	    for (int i=0; i<board[j].length; i++){
		if (board[j][i].equals("-")){
		
		}
	    }
	}

    }
    
}


