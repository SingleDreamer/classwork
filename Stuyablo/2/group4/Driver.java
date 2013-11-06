// public class Driver {
//     public static void main(String[] args) {
// 	Character a = new Character("Michael");
// 	Character b = new Character();
// 	System.out.println("\n"+a+"\n");
// 	System.out.println(b);
//     }
// }

public class Driver {

    public static void main(String[] args) {
        System.out.println("What is your name, warrior?");
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();
	Player a = new Player(name);
        Ogre b = new Ogre();
<<<<<<< HEAD
	System.out.println("Welcome to the battlefield, " + name + "!");
        //a.getStatus();	
	//a.attack(b);
	System.out.println(a.encounter(b));
=======
        a.encounter(b);
>>>>>>> 50fbeedf651570d32692b89270d46fc943e60d66
    }
}
