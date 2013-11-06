public class Driver {
    public static void main(String[] args) {
	Goblin c = new Goblin("Bob");
	Goblin a = new Goblin("Gob");
	
	int battle = 0;
	while (battle < 20){
	    while (c.encounter(c,a) == 5){
		System.out.println(c.getHealth());
		System.out.println(a.getHealth());
		c.level();
		a.level();
		System.out.println(c.getLevel());
		System.out.println(a.getLevel());
	    }
	    c.health = c.maxhealth;
	    a.health = a.maxhealth;
	    battle ++;
	}
    }
}

