import java.util.*;

public class Driver {
    public static void main(String[] args) {

		System.out.println();
		System.out.println("*-* Testing class Boggle*-*");
		System.out.println();

		 Scanner s = new Scanner(System.in);
		 Random r = new Random();
		 Boggle b;
		 System.out.println("Choose your board size: \n 1) 4x4 \n 2) 5X5 \n 3) 6x6");
		 int size = s.nextInt();
		 while (size != 1 && size != 2 && size !=3) {
		 	System.out.println("Choose your board size: \n 1) 4x4 \n 2) 5X5 \n 3) 6x6");
		 	size = s.nextInt();
	 	}
		 if (size == 1)
		 	b = new Boggle(4,4);
		 else if (size == 2)
		    b = new Boggle(5,5);
		 else
		    b = new Boggle(6,6);

		System.out.println();
        System.out.println(b);
        System.out.println();
        s = new Scanner(System.in);
        System.out.println("Find words using the letters in the Boggle Box");
        String word = s.nextLine();


   }
}