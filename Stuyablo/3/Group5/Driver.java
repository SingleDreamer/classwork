public class Driver {
    public static void main(String[] args) {
		Goblin g = new Goblin("TestGoblin");
		Warrior w = new Warrior("TestWarrior");
		while (w.encounter(g) == 5){
			System.out.println();
		    System.out.println("#################");
		    try {
			Thread.sleep(2500);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		    System.out.println("Next Round");
		    System.out.println();
		    try {
			Thread.sleep(2000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
    }
}

