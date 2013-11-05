public class Ogre extends Character {

    public Character(){
	name="Ogre";
	strength=toChance()+100;
	dexterity=((int)((toChance()*.01)*5))+15;
	health=((int)((toChance()*.01)*1000))+5000;
	maxhealth=health;
    }


}