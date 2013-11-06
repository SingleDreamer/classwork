public class Driver {
    public static void main(String[] args) {
	Goblin c = new Goblin("Bob");
	Goblin a = new Goblin("Gob");
	while (c.encounter(c,a) == 5){
	    System.out.println(c.getHealth());
	    System.out.println(a.getHealth());

	}
    }
}
