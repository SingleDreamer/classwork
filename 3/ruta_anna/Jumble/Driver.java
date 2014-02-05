import java.util.*;

public class Driver {
    public static void main(String[] args) {

		System.out.println();
		System.out.println("*-* Testing class Jumble *-*");
		System.out.println();

		 Scanner s = new Scanner(System.in);
		 Random r = new Random();
		 Jumble j;
		 System.out.println("Choose your board size: \n 1) 6 \n 2) 7 \n 3) 8");
		 int size = s.nextInt();
		 while (size != 1 && size != 2 && size !=3) {
		 	System.out.println("Choose your board size: \n 1) 6 \n 2) 7 \n 3) 8");
		 	size = s.nextInt();
	 	}
		 if (size == 1)
		 	j = new Jumble(6);
		 else if (size == 2)
		    j = new Jumble(7);
		 else
		    j = new Jumble(8);

		System.out.println();
		System.out.println("Find words using the following letters:");
        System.out.println(j);
        System.out.println();

		String word;
		s = new Scanner(System.in);
					word = s.nextLine();
			j.turn(word);

		System.out.println(j.getScore());

   }
}