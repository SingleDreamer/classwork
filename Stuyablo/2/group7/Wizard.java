public class Wizard extends Character{
	public Wizard(int extra) {
		super("Wizard", 8, 8, 8, int extra);
	}

	public Wizard(String name, int addStr, int addDex, int addInt) {
		super(String name, 8, 8, 8, int addStr, int addDex, int addInt);
	}
	
	protected int damageMulti(Character other) {
		dist = getDistance(other);
		tempDex = dexterity - Math.round(dist);
		return 
	}
	
    public void attack(Character other) {
				int cDex = 0, tempDex = 0, dist = 0;
				dist = getDistance(other);
				cDex = dexterity;
				dexterity = dexterity - Math.round(dist);
                Random r = new Random();
                //the dice rolls
                int x = r.nextInt(6) + 1, y = r.nextInt(6) + 1, z = r.nextInt(6) + 1;
                if (x+y+z <= dexterity) {
                    //needs damage calculator!
                    int dmg = this.strength * damageMulti(other);
                    other.loseHealth(dmg);
                    System.out.println("\n" + name + " did " + dmg + " damage to " + other + "!");
                }
                else {
                    System.out.println("\n" + name + " missed!");
                }
				dexterity = cDex;
    }
}