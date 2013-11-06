public class Driver {
    public static void main(String[] args) {
	Warrior w = new Warrior("James",5,2,1);
	System.out.println(w.getStatus());
	Warrior wbot = new Warrior("Bot",0,0,0);
	System.out.println(wbot.getStatus());
	w.calcDmg();
	System.out.println(w.dmgdouble);
	w.encounter(wbot);
    }
}
