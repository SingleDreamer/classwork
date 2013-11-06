public class Driver {
    public static void main(String[] args) {
	Goblin c = new Goblin("Bob");
	Goblin a = new Goblin("Gob");
	Human h = new Human("Anna");
	while (a.encounter(a,c) == 5){
	    System.out.println("#################");
	}

    }
}

