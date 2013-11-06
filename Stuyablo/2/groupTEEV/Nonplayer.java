public claass Nonplayer extends Character {

    public void attack(){
	
    }
    public void basicattack(){
	int damage = 0;
        if (charClass == "Ogre"){
            damage = strength - 4 + Random.nextInt(3);
        }
        else {
            damage = intelligence + 2 + Random.nextInt(3);
        }
        if (cooldown > 0){
            cooldown = cooldown - 1;
        }	
    }
    public void specialattack1(){
	int damage = 0;
        if (cooldown = 0){
            if (charClass == "Ogre"){
                damage = strength + 8;
            }
            else {
                damage = intelligence + 13;
            }
            cooldown = 3;
        }
    }
    public void specialattack2(){
	int damage = 0;
        if (cooldown = 0){
            if (charClass == "Ogre"){
                damage = strength + 20;
            }
            else {
                damage = intelligence + 25;
            }
            cooldown = 5;
        }
    }
    public void loseHealth(int n){
	health = health - n;
    }

    public void gainHealth(int n){
	health = health + n;
    }
    
    public void giveExp(Character c, int n){
	c.gainExp(n);
    }





}
