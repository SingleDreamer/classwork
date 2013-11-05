public class Ogre extends Character {

    public Ogre(){
	name="Ogre";
	double r1 = new random();
	double r2 = new random();
	double r3 = new random();
	setStr=(r1*10)%1;
        setDex=(r1*10)%1;
        setInt=(r1*10)%1;
    }


}