public class Driver {
    public static void main(String[] args) {
	Character ch1 = new Character();
	Warrior wa2 = new Warrior("Bob", 8);
	ch1.battle(wa2);
	
	ch1.getInfo();
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
	ch1.play();
    }

}
