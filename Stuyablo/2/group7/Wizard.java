public class Wizard extends Character{
	public Wizard(int baseStr, int baseDex, int baseInt, int extra) {
		super("Wizard", int baseStr, int baseDex, int baseInt, int extra);
	}

	public Wizard(String name, int baseStr, int baseDex, int baseInt, int addStr, int addDex, int addInt) {
		super(String name, int baseStr, int baseDex, int baseInt, int addStr, int addDex, int addInt);
	}
}