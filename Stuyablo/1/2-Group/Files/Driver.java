public class Driver {
    public static void main(String[] args) {
	Warrior wa1 = new Warrior(); //Player
	wa1.getInfo();
	System.out.println("_________________");
	try {
	    Thread.sleep(2000); // how many milliseconds to pause
	} catch (Exception e) {
	    // do nothing here 
	}
        wa1.play();

	//Wizard wi = new Wizard("tom", 8);
//	System.out.println(wi.strength);

//	Wizard wi2 = new Wizard("Barry", 8);
//	System.out.println(wi2);

//	System.out.println(wi.distance(wi2));
//	c1.battle(wi);
//	System.out.println("_________________");
//	ch1.play();
    }

}
