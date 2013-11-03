public class Driver {
    public static void main(String[] args) {
	Character c1 = new Character("Name",3,3,2,8,8,false,false);
	System.out.println(c1.name);
	System.out.println(c1.intelligence);
	System.out.println(c1.dexterity);
	System.out.println(c1.strength);
	Wizard wi = new Wizard("tom");
	System.out.println(wi.strength);

	Wizard wi2 = new Wizard("Barry");
	System.out.println(wi2);

	System.out.println(wi.distance(wi2));
	c1.battle(wi);
    }

}
