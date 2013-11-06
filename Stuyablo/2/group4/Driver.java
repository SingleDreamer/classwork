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
        Player a = new Player("Aida");
        Ogre b = new Ogre();
        //a.getStatus();	
	//a.attack(b);
	System.out.println(a.encounter(b));
    }
}
