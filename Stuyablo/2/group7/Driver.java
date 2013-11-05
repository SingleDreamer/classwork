public class Driver {
    public static void main(String[] args) {
	Character c1 = new Character("Player 1");
	Character c2 = new Character("Player 2");
	System.out.println(c1.getStatus());
	c1.game(c2);
    }
}
