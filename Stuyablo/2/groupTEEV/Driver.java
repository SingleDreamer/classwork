public class Driver {
    public static void main(String[] args) {
	Player c = new Player();
	c.setClass();
	System.out.print("\n" + c.getStatus());
	c.setStat();
        System.out.print("\n" + c.getStatus());
	c.gainExp(100);
	if (c.getExperience() >= 100){
	    c.levelUp();
	}
        System.out.print("\n" + c.getStatus());
    }
}
