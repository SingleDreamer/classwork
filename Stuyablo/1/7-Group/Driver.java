public class Driver {
    public static void main(String[] args) {
	Character c = new Character();
	Character j = new Character("Apples","person");
	//c status
	System.out.println("------------- \n My B4 Status");
	System.out.println(c.getStatus());
	System.out.println("------------- \n Other B4 Status");
	System.out.println(j.getStatus());
	c.Battle(40,j);
	System.out.println("------------- \n My After Status");
	System.out.println(c.getStatus());
	System.out.println("------------- \n Other After Status");
	System.out.println(j.getStatus());
    }
}
