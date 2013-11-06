public class Driver {
    public static void main(String[] args) {
	Character a,b;
	//a = new Character();
	//b = new Character();
	//a.attack(b);
	
	a = new Wizard();
	b = new Wizard();
	a.encounter(b);

    }
}
