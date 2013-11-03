public class Driver {
    public static void main(String[] args) {
	Wizard wi = new Wizard("tom");
	System.out.println(wi);

	Wizard wi2 = new Wizard("Barry");
	System.out.println(wi2);

	System.out.println(wi.distance(wi2));
    }

}
