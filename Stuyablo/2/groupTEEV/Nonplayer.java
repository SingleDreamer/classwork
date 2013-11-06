public class Nonplayer extends Character {

    public void attack(){
	//stuff
    }

    public void loseHealth(int n){
	health = health - n;
    }

    public void gainHealth(int n){
	health = health + n;
    }
    
    public void giveExp(Player c, int n){
	c.gainExp(n);
    }





}
