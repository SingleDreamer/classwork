public Player extends Character {
    private int level;

    public void attack(){
	//stuff
    }

    public void loseHealth(int n){
	health = health - n;
    }
    public void gainHealth(int n){
	health = health + n;
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

    public void levelUp(){
	// if (exp >= 100)
	//insert scanner stuff here
    }


}
