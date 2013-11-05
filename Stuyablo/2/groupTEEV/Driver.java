public class Driver {
    public static void main(String[] args) {
	Character c = new Player();
	System.out.print("\n" + c.getStatus());
	c.setStat();
        System.out.print("\n" + c.getStatus());
    }
}
