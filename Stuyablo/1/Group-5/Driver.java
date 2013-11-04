public class Driver {
    public static void main(String[] args) {
	Character c = new Character("Tom");
	System.out.println(c);

        playerCharacter p = new playerCharacter("Zens");
	System.out.println(p);
	System.out.println(p.attack());
    }

}
