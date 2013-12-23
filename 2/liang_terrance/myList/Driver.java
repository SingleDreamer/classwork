
public class Driver {
    public static void main(String[] args) {
	/*	myList L = new myList();

	System.out.println(L);
	for (int i = 0; i<5;i++) {
	    L.add((i+1)*5);
	}
	System.out.println(L);

	for (int i = 0; i<7;i++) {
	    L.add((i+1)*5);
	}
	System.out.println(L);
	System.out.println("Inserted 3 to position 3");
	L.add (3,3);
	System.out.println(L);
	System.out.println("Inserted 2 to position 5");
	L.add(5,2);
	System.out.println(L);
	

	myList A = new myList();
	System.out.println (A);
	A.add(2);
	System.out.println (A);
	A.add(3,5);
	System.out.println(A);
	A.remove(2);
	System.out.println (A);

	L.grow();
	
*/

	myStringList a = new myStringList();
	a.set(0,"Hello");
	a.set(1,"Eric");
	a.set(2, "Terrance");
	a.set(3, "WOOO");
	a.set(4,"YAYYYY");
	System.out.println(a);
        a.add("LETSGO!");
	

    }	
   

}
