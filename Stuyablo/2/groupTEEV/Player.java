public Player extends Character {
    private int strength;
    private int dexterity;
    private int health;
    private int experience;
    private int level;
    public void attack(){
	//stuff
    }
    public string status(){
	return "the health of the player character is " + health;
    }
    public void loseHealth(int n){
	health = health - n;
    }
    public void gainHealth(int n){
	health = health + 1;
    }
    public void battle(){
	if (health == 0)
	    return "The battle is over. You have lost";
	else
	    attack();
    }
    public void gainExp(int n){
	experience = experience + n;
    }
    public void addStrenth(){
	strength = strength + 1;
    }
    public void addDexterity(){
	dexterity = dexterity + 1;
    }
    
}
