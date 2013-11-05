public class Driver {
    public static void main(String[] args) {
	Warrior wa1 = new Warrior();
	Warrior wa2 = new Warrior("Bob", 8);
	wa1.battle(wa2);
	
	wa1.getInfo();
	System.out.println("_________________");
	wa2.getInfo();
	System.out.println("_________________");

	//Wizard wi = new Wizard("tom", 8);
//	System.out.println(wi.strength);

//	Wizard wi2 = new Wizard("Barry", 8);
//	System.out.println(wi2);

//	System.out.println(wi.distance(wi2));
//	c1.battle(wi);
	System.out.println("_________________");
	wa1.turn();
    }

}
