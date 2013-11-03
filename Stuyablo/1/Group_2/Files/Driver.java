public class Driver {
    public static void main(String[] args) {
	Character c1 = new Character();
	Character c2 = new Character("Bob");

	c1.getInfo();
	System.out.println("_________________");
	c2.getInfo();
	System.out.println("_________________");

	Wizard wi = new Wizard("tom");
	System.out.println(wi.strength);

	Wizard wi2 = new Wizard("Barry");
	System.out.println(wi2);

	System.out.println(wi.distance(wi2));
	c1.battle(wi);
    }

}
