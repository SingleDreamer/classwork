public class Wizard extends Character{
	public Wizard(int extra) {
		super("Wizard", 8, 8, 8, int extra);
	}

	public Wizard(String name, int addStr, int addDex, int addInt) {
		super(String name, 8, 8, 8, int addStr, int addDex, int addInt);
	}
}