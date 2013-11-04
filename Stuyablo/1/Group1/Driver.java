public class Driver {
    public static void main(String[] args) {
	Character c = new Character("Fred");
	Character c2 = new Character("Bob");
	System.out.println(c.getStatus());
	c.encounter(c2);
    }
}
