public class ZhangNPC extends Character {
    
    public ZhangNPC(){
	Random n = new Random();
	charType = "Zhang";
	name = "Enemy";
	strength = 11+n.nextInt(3);
	dexterity = 8+n.nextInt(2);
	defense = 13+n.nextInt(4);
	maxhealth = strength;
	charm = 2;
    }
}
